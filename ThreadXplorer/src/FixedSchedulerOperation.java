import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class FixedSchedulerOperation {

    public static void main(String[] args){
        // Initializing a Fixed Scheduler executor service
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        // Atomic Integer - Thread safe counter
        Runnable display = getRunnable(executorService);

        // Starts the executor service
        executorService.scheduleWithFixedDelay(display, 0, 10, TimeUnit.SECONDS);

        // Wait for the executor service to run the task 10 times.
        try {
            executorService.awaitTermination(120, TimeUnit.SECONDS);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }

    private static Runnable getRunnable(ScheduledExecutorService executorService) {
        AtomicInteger count = new AtomicInteger();

        // Runnable method - which prints the current time and stops the executor service once counter reaches 10.
        return () -> {
            int currentCount = count.incrementAndGet();
            if(currentCount > 10){
                System.out.println("Scheduler stopped after 10 executions.");
                executorService.shutdown();
            }
            System.out.println("Current Time : " + LocalTime.now());
        };
    }
}
