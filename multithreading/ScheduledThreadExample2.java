import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class ScheduledThreadExample2{
    public static void main(String args[]) {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        Runnable task = ()-> {
            System.out.println(Thread.currentThread().getName()+"pinging at "+System.nanoTime());
        };

        executorService.scheduleAtFixedRate(task, 2, 5, TimeUnit.SECONDS);

        executorService.schedule(()->{System.out.println(Thread.currentThread().getName()+"is pinging 10 secs");}, 12, TimeUnit.SECONDS);
        executorService.schedule(()->{executorService.shutdown();}, 20, TimeUnit.SECONDS);
    }
}