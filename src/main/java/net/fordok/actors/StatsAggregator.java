package net.fordok.actors;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Fordok
 * Date: 2/24/2015
 * Time: 12:07 AM
 */
public class StatsAggregator extends UntypedActor {

    private LoggingAdapter log = Logging.getLogger(getContext().system(), this);
    private List<Long> lags = new ArrayList<Long>();

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof Long) {
            lags.add((Long)message);
            log.info("Received lag : " + message.toString());
        }
    }
}
