package net.fordok;

import net.fordok.configuration.ConfigurationSystem;
import net.fordok.core.LoadGenerator;
import net.fordok.core.LoadGeneratorImpl;
import net.fordok.work.HttpWork;
import org.yaml.snakeyaml.Yaml;

/**
 * User: Fordok
 * Date: 1/1/2015
 * Time: 6:13 PM
 */
public class Runner {
    public static void main(String[] args) throws InterruptedException {

        Yaml yaml = new Yaml();
        LoadGenerator loadGenerator = new LoadGeneratorImpl();
        loadGenerator.init(new ConfigurationSystem(10, 1000, 100, new HttpWork("HttpWork", "http://google.com", "GET")));
        loadGenerator.start();

        Thread.sleep(5000);

        loadGenerator.stop();
    }
}
