package com.java_interview_tech_questionnaires;

import java.util.concurrent.CountDownLatch;

/**
 * @author RavikantS on Jul 31, 2025
 */
//@Component
//@Scope("prototype")
public record JobConfig(Long id, String jobName, String jobParams, CountDownLatch latch) implements Runnable, Comparable<JobConfig> {
    @Override
    public void run() {
        try {
            System.out.println("Config hash : " + hashCode());
            System.out.printf("Running job: ID=%d, Name=%s, Params=%s, Thread=%s%n",
                    id, jobName, jobParams, Thread.currentThread());
        } finally {
            latch.countDown();
        }
    }
    
    @Override
    public int compareTo(JobConfig o) {
        return 0;
    }
}
