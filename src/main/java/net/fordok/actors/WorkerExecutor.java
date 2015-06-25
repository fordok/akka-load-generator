package net.fordok.actors;

import akka.actor.UntypedActor;
import net.fordok.messages.WorkResult;
import net.fordok.work.Work;

/**
 * User: fordok
 * Date: 6/25/2015
 */
public class WorkerExecutor extends UntypedActor {

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof Work) {
            Work work = (Work)message;
            WorkResult result = work.doWork();
            getSender().tell(result, getSelf());
        }
    }
}
