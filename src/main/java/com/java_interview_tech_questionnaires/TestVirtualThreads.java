package com.java_interview_tech_questionnaires;

import org.springframework.context.annotation.Bean;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.core.task.support.TaskExecutorAdapter;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author RavikantS on Jul 17, 2025
 */
public class TestVirtualThreads {

    public static final ExecutorService EXECUTOR = Executors.newVirtualThreadPerTaskExecutor();

    @Bean
    public static AsyncTaskExecutor virtualTaskExecutor() {
        return new TaskExecutorAdapter(EXECUTOR);
    }

    public static void main(String[] args) {
        List<JobConfig> jobConfigs = List.of(
                new JobConfig(11L, "jobName 1", null, null),
                new JobConfig(12L, "JobName 2", "Payments, Business", null));

        int totalTasks = jobConfigs.stream().mapToInt(job -> Optional.ofNullable(job.jobParams())
                        .map(params -> params.split(",").length).orElse(1)).sum();

        final CountDownLatch latch = new CountDownLatch(totalTasks);
        System.out.println("Before Latch : " + latch.hashCode() + " Value : " + latch.getCount());

        AsyncTaskExecutor executorService = virtualTaskExecutor();
        try (EXECUTOR) {
            long start = System.currentTimeMillis();
            IntStream.range(0, 1).forEach(index -> {
                System.out.println("Loop index : " + index);
                jobConfigs.forEach(job -> Optional.ofNullable(job.jobParams()).ifPresentOrElse(params ->
                                Arrays.stream(params.split(",")).forEach(param ->
                                        executorService.submit(new JobConfig(job.id(), job.jobName(), param.trim(), latch))),
                        () -> executorService.submit(new JobConfig((long) index, job.jobName(), null, latch)))
                );
            });
            latch.await();
            System.out.println("Execution Completed Successfully");
            System.out.printf("Execution time : in %.2f minutes%n", ((System.currentTimeMillis() - start) / 1_000_000.0 / 60.0 / 60.0));
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
        }
    }
}
