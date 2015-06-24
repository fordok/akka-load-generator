package net.fordok.work;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.HeadMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * User: Fordok
 * Date: 2/15/2015
 * Time: 6:55 PM
 */
public class HttpWork implements Work {

    private static Logger log = LoggerFactory.getLogger(HttpWork.class);

    private String name;
    private String url;

    public HttpWork(String name, String url) {
        this.name = name;
        this.url = url;
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

    @Override
    public void doWork() {
        HttpClient client = new HttpClient();
        HttpMethod method = new HeadMethod(url);
        try {
            int responseCode = client.executeMethod(method);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "HttpWork{" +
                "name='" + HttpWork.class.getCanonicalName() + '\'' +
                "url='" + url + '\'' +
                '}';
    }
}
