package net.fordok.messages;

import java.io.Serializable;

/**
 * User: fordok
 * Date: 6/25/2015
 */
public class WorkResult implements Serializable {

    private static final long serialVersionUID = -5432699993270746409L;

    private String name;
    private long startTs;
    private long endTs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getStartTs() {
        return startTs;
    }

    public void setStartTs(long startTs) {
        this.startTs = startTs;
    }

    public long getEndTs() {
        return endTs;
    }

    public void setEndTs(long endTs) {
        this.endTs = endTs;
    }

    @Override
    public String toString() {
        return "WorkResult{" +
                "name='" + name + '\'' +
                ", startTs=" + startTs +
                ", endTs=" + endTs +
                '}';
    }
}
