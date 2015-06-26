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
    private String error = "";

    private int responseCode;
    private String responseBody = "";

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

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "WorkResult{" +
                "name='" + name + '\'' +
                ", startTs=" + startTs +
                ", endTs=" + endTs +
                ", error='" + error + '\'' +
                ", responseCode=" + responseCode +
                ", responseBody=" + responseBody +
                '}';
    }
}
