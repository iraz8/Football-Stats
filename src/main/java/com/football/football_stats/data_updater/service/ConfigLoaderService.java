package com.football.football_stats.data_updater.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoaderService {
    private static final File config_filename = new File("src/main/java/com/football/football_stats/data_updater/config/config.yaml");
    private static volatile Properties config;

    private ConfigLoaderService() {
    }

    public static Properties getInstance() {
        if (config == null) {
            synchronized (ConfigLoaderService.class) {
                if (config == null) {
                    config = new Properties();
                    try {
                        config.load(new FileInputStream(config_filename));
                    } catch (IOException e) {
                        System.out.println("Exception thrown  :" + e);
                    }
                }
            }
        }
        return config;
    }
}

