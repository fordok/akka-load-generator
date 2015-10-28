package net.fordok;

import net.fordok.configuration.ConfigurationSystem;
import net.fordok.core.LoadGenerator;
import net.fordok.core.LoadGeneratorImpl;
import net.fordok.work.HttpWork;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Fordok
 * Date: 1/1/2015
 * Time: 6:13 PM
 */
public class Runner {
    public static void main(String[] args) throws InterruptedException {
        LoadGenerator loadGenerator = new LoadGeneratorImpl();
        Map<String, String> inputParams = new HashMap<>();
        inputParams.put("url", "http://google.com");
        inputParams.put("method", "GET");

        loadGenerator.init();
        loadGenerator.start(new ConfigurationSystem(10, 1000, 100, new HttpWork(inputParams)));

        Thread.sleep(30000);

        loadGenerator.stop();
    }
}
