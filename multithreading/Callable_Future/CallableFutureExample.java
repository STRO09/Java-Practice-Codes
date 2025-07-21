import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CallableFutureExample{
    public static void main(String args[]) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> task = ()-> {
            Thread.sleep(2000);
            return Thread.currentThread().getName()+"is executing";
        };
        System.out.println("Waiting for result....");
        Future<String> future=executorService.submit(task);
        String result = future.get();
        System.out.println(result);
        if(future.isDone()) {
            System.out.println("Done.");
            executorService.shutdown();
        };
        
    }
}