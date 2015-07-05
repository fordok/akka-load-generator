package net.fordok.core;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.PoisonPill;
import akka.actor.Props;
import net.fordok.actors.Master;
import net.fordok.configuration.ConfigurationSystem;
import net.fordok.messages.CommandsManage;

/**
 * User: Fordok
 * Date: 6/24/2015
 * Time: 11:15 PM
 */
public class LoadGeneratorImpl implements LoadGenerator {

    private ActorSystem actorSystem;
    private ActorRef master;
    private ConfigurationSystem confSystem = ConfigurationSystem.DEFAULT;

    @Override
    public void init(ConfigurationSystem confSystem) {
        actorSystem = ActorSystem.create("loadGenerator");
        master = actorSystem.actorOf(Props.create(Master.class));
        master.tell(confSystem, ActorRef.noSender());
        this.confSystem = confSystem;
    }

    @Override
    public void start() {
        master.tell(new CommandsManage.Start(), ActorRef.noSender());
    }

    @Override
    public void stop() {
        master.tell(new CommandsManage.Stop(), ActorRef.noSender());
        master.tell(PoisonPill.getInstance(), ActorRef.noSender());
    }

    @Override
    public void suspend() {
        master.tell(new CommandsManage.Suspend(), ActorRef.noSender());
    }

    @Override
    public void resume() {
        master.tell(new CommandsManage.Resume(), ActorRef.noSender());
    }

    @Override
    public void setConfiguration(ConfigurationSystem confSystem) {
        this.confSystem = confSystem;
        master.tell(confSystem, ActorRef.noSender());
    }

    @Override
    public ConfigurationSystem getConfiguration() {
        return confSystem;
    }
}
