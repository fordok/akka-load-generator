package net.fordok.work;

import net.fordok.messages.WorkResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * User: Fordok
 * Date: 2/15/2015
 * Time: 6:55 PM
 */
public class HttpWork implements Work {

    private static Logger log = LoggerFactory.getLogger(HttpWork.class);

    private String name;
    private String url;
    private String method;

    public HttpWork() {}

    public HttpWork(String name, String url, String method) {
        this.name = name;
        this.url = url;
        this.method = method;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public WorkResult doWork() {
        WorkResult result = new WorkResult(name);
        try {
            result.setStartTs(System.currentTimeMillis());
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod(method);
            int responseCode = con.getResponseCode();
            result.setResponseCode(responseCode);
            result.setEndTs(System.currentTimeMillis());
        } catch (IOException e) {
            result.setError(e.getMessage());
            result.setEndTs(System.currentTimeMillis());
        }
        return result;
    }

    @Override
    public String toString() {
        return "HttpWork{" +
                "name='" + HttpWork.class.getCanonicalName() + '\'' +
                "url='" + url + '\'' +
                '}';
    }
}
