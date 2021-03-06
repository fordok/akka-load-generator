package net.fordok.core;

import net.fordok.configuration.ConfigurationSystem;

/**
 * User: Fordok
 * Date: 1/3/2015
 * Time: 4:18 PM
 */
public interface LoadGenerator {
    void init();
    void start(ConfigurationSystem confSystem);
    void stop();
}
