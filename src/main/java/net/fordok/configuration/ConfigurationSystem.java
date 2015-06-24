package net.fordok.configuration;

import net.fordok.work.HttpWork;
import net.fordok.work.Work;

/**
 * User: Fordok
 * Date: 1/3/2015
 * Time: 2:53 PM
 */
public class ConfigurationSystem {

    public static final ConfigurationSystem DEFAULT = new ConfigurationSystem(1, 100, 100, new HttpWork("http work", "http://google.com"));

    private int workersCount;
    private long period;
    private long rampUp;
    private Work work;

    public ConfigurationSystem(int workersCount, long period, long rampUp, Work work) {
        this.workersCount = workersCount;
        this.period = period;
        this.rampUp = rampUp;
        this.work = work;
    }

    public int getWorkersCount() {
        return workersCount;
    }

    public void setWorkersCount(int workersCount) {
        this.workersCount = workersCount;
    }

    public long getPeriod() {
        return period;
    }

    public void setPeriod(long period) {
        this.period = period;
    }

    public long getRampUp() {
        return rampUp;
    }

    public void setRampUp(long rampUp) {
        this.rampUp = rampUp;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    @Override
    public String toString() {
        return "ConfigurationSystem{" +
                "workersCount=" + workersCount +
                ", period=" + period +
                ", rampUp=" + rampUp +
                ", work=" + work +
                '}';
    }
}
