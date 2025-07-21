import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolDemo{
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        Runnable task = () -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + " running periodic task at " + System.currentTimeMillis());
        };

        // Start after 2 seconds, then repeat every 3 seconds
        scheduler.scheduleAtFixedRate(task, 2, 3, TimeUnit.SECONDS);
        
        // Optional: stop after 10 seconds
        scheduler.schedule(() -> {
            System.out.println("Shutting down scheduler...");
            scheduler.shutdown();
        }, 10, TimeUnit.SECONDS);
    }
}
