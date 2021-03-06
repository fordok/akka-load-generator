package net.fordok.messages;

import java.io.Serializable;
import java.util.Map;

/**
 * User: fordok
 * Date: 6/25/2015
 */
public class WorkResult implements Serializable {

    private static final long serialVersionUID = -5432699993270746409L;

    private String name;
    private long startTs;
    private long endTs;
    private String error = "";
    private Map<String,String> output;

    public WorkResult(){}

    public WorkResult(String name) {
        this.name = name;
    }

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

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Map<String, String> getOutput() {
        return output;
    }

    public void setOutput(Map<String, String> output) {
        this.output = output;
    }

    @Override
    public String toString() {
        return "WorkResult{" +
                "name='" + name + '\'' +
                ", error='" + error + '\'' +
                ", output=" + output +
                '}';
    }
}
