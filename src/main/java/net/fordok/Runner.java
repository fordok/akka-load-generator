package net.fordok;

import net.fordok.configuration.ConfigurationSystem;
import net.fordok.core.LoadGenerator;
import net.fordok.core.LoadGeneratorImpl;
import net.fordok.work.HttpWork;

/**
 * User: Fordok
 * Date: 1/1/2015
 * Time: 6:13 PM
 */
public class Runner {
    public static void main(String[] args) throws InterruptedException {
        LoadGenerator loadGenerator = new LoadGeneratorImpl();
        loadGenerator.init(new ConfigurationSystem(10, 1000, 100, new HttpWork("HttpWork", "http://locdfalhost:8080", "POST")));
        loadGenerator.start();

        Thread.sleep(5000);

        loadGenerator.stop();
    }
}
