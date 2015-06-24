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
        loadGenerator.init(new ConfigurationSystem(10, 500, 100, new HttpWork("Http work", "http://google.com")));
        loadGenerator.start();

        Thread.sleep(5000);

        loadGenerator.stop();
    }
}
