package net.fordok.actors;

import akka.actor.ActorRef;
import akka.actor.Cancellable;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import net.fordok.configuration.ConfigurationWorker;
import net.fordok.messages.CommandsManage;
import net.fordok.messages.WorkResult;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;

/**
 * User: Fordok
 * Date: 1/3/2015
 * Time: 2:50 PM
 */
public class Worker extends UntypedActor {

    private LoggingAdapter log = Logging.getLogger(getContext().system(), this);
    private Cancellable scheduler = null;
    private ConfigurationWorker conf = null;

    private int id;

    public Worker(int id, ConfigurationWorker conf) {
        this.id = id;
        this.conf = conf;
        log.info("Worker with id : " + id + " was created");
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof ConfigurationWorker) {
            conf = (ConfigurationWorker) message;
            log.info("Worker with id : " + id + " received configuration : " + conf);
        } else if (message instanceof CommandsManage.Start) {
            if (conf == null) {
                log.error("No configuration for worker! : " + id);
            } else {
                scheduler = initSchedulerWithPeriod(conf.getPeriod());
            }
        } else if (message instanceof CommandsManage.Suspend) {
            scheduler.cancel();
        } else if (message instanceof CommandsManage.Resume) {
            scheduler = initSchedulerWithPeriod(conf.getPeriod());
        } else if (message instanceof WorkResult) {
            conf.getStatsActor().tell(message, getSelf());
        } else if (message.equals("Tick")) {
            doWork();
        }
    }

    private void doWork() {
        ActorRef executor = getContext().actorOf(Props.create(WorkerExecutor.class));
        executor.tell(conf.getWork(), getSelf());
    }

    private Cancellable initSchedulerWithPeriod(long period) {
        return getContext().system().scheduler().schedule(Duration.Zero(),
                Duration.create(period, TimeUnit.MILLISECONDS), getSelf(), "Tick",
                getContext().system().dispatcher(), null);
    }

}
