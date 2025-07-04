import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 1; i <= 30; i++) {
            int taskId = i;
            executor.submit(() -> {
                String name = Thread.currentThread().getName();
                System.out.println(name + " executing task " + taskId);
                try {
                    Thread.sleep(100); // simulate work
                } catch (InterruptedException ignored) {}
            });
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

        executor.shutdown();
    }
}
