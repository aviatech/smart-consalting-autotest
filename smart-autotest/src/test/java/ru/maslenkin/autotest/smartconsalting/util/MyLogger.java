package ru.maslenkin.autotest.smartconsalting.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyLogger {
    private static Logger logger = null;

    public static Logger getInstance() {
        if (logger == null) {
            logger = LogManager.getLogger();
        }
        return logger;
    }

    public MyLogger() {
    }
}

