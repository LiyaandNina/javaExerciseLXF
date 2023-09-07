package com.iwans.stringtesttwo;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

public class TestLogging {
    public static void main(String[] args) {
//        Logger logger = Logger.getGlobal();
//        logger.info("starting process...");
//        logger.warning("memory is running out...");
//        logger.fine("ignored.");
//        logger.severe("process will be terminated...");
        Logger logger = Logger.getLogger(Main.class.getName());
        logger.info("Start process...");
        try {
            "".getBytes("invalidCharsetName");
        } catch (UnsupportedEncodingException e) {
            // TODO: 使用logger.severe()打印异常
            logger.severe(e.toString());
        }
        logger.info("Process end.");

    }
}




