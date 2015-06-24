package net.fordok.actors;

import akka.actor.Cancellable;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import net.fordok.configuration.ConfigurationWorker;
import net.fordok.messages.CommandsManage;
import net.fordok.work.Work;
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
    private Work work;

    private int id;

    public Worker(int id, ConfigurationWorker conf) {
        this.id = id;
        this.conf = conf;
        log.info("Worker with id : " + id + " was created");
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof ConfigurationWorker) {
            conf = (ConfigurationWorker)message;
            log.info("Worker with id : " + id + " received configuration : " + conf);
        } else if (message instanceof CommandsManage.Start) {
            if (conf == null) {
                log.error("No configuration for worker! : " + id);
            } else {
                scheduler = initSchedulerWithPeriod(conf.getPeriod());
            }
        } else if (message.equals("Tick")) {
            doWork();
        }
    }

    private void doWork() {
        long start = System.currentTimeMillis();
        conf.getWork().doWork();
        long lag = System.currentTimeMillis() - start;
        conf.getStatsActor().tell(lag, getSelf());
    }

    private Cancellable initSchedulerWithPeriod(long period) {
        return getContext().system().scheduler().schedule(Duration.Zero(),
                Duration.create(period, TimeUnit.MILLISECONDS), getSelf(), "Tick",
                getContext().system().dispatcher(), null);
    }

}
