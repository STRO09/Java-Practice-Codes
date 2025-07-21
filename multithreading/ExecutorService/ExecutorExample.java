import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3); // pool of 3 threads

        Runnable task = () -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + " is executing a task");
            try {
                Thread.sleep(3000);
            } catch(Exception e) {
              System.out.println(e);
            }

        };

        // Submit 5 tasks (only 3 run at once)
        for (int i = 0; i < 5; i++) {
            executor.submit(task);
        }

        executor.shutdown(); // always shut down when done
    }
}