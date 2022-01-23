package com.vegasoft.simulation.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

public class FrequencyExecutor {
    private static final Logger logger = LoggerFactory.getLogger(FrequencyExecutor.class);
    private Runnable runnable;
    private long sleepTimeInMS;
    private Thread thread;
    private AtomicBoolean keepRunning = new AtomicBoolean(true);
    private long executionCount;
    private long executionStartTime;
    private long lastLogPrintInSeconds = 1;

    public FrequencyExecutor(Runnable runnable, int sleepTimeInMS) {
        this.sleepTimeInMS = sleepTimeInMS;
        this.runnable = runnable;
        thread = new Thread(this::start);
        thread.start();
    }

    private void start() {
        executionStartTime = new Date().getTime();
        while (keepRunning.get()) {
            runnable.run();
            executionCount++;
            printStatsIfNeeded();
        }
    }

    private void printStatsIfNeeded() {
        Long executionTime = new Date().getTime() - executionStartTime;
        double executionTimeSeconds = executionTime / 1000;
        if (executionTimeSeconds > lastLogPrintInSeconds && executionTimeSeconds % 10 == 0) {
            logger.info("Execution frequency per seconds = {} ", executionCount / executionTimeSeconds);
            lastLogPrintInSeconds = (long) executionTimeSeconds;
        }
    }

    private void sleepFor(long pauseTime) {
        try {
            if (pauseTime > 0) {
                Thread.sleep(pauseTime);
            }
        } catch (InterruptedException e) {
            logger.warn("Interrupted... :(", e);
        }
    }


    public void stop() {
        keepRunning.set(false);
    }
}
