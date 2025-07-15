import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class FixedSchedulerOperation {

    public static void main(String[] args){
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        AtomicInteger count = new AtomicInteger();
        Runnable display = () -> {
            int currentCount = count.incrementAndGet();
            System.out.println("Current Time : " + LocalTime.now());
            if(currentCount > 10){
                System.out.println("Scheduler stopped after 10 executions.");
                executorService.shutdown();
            }
        };

        executorService.scheduleWithFixedDelay(display, 0, 10, TimeUnit.SECONDS);

        try {
            executorService.awaitTermination(120, TimeUnit.SECONDS);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }

}
