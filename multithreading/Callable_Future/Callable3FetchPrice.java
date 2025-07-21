import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Callable3FetchPrice {

    public static void main(String args[]) throws InterruptedException, ExecutionException{
        

        Callable<Double> callable1 = new Callable<Double>() {

            @Override
            public Double call() throws Exception {
                // TODO Auto-generated method stub
                System.out.println("Task A is fetching price with "+Thread.currentThread().getName()+"...");
                try {
                    Thread.sleep(new Random().nextInt(4000));
                } catch (Exception e) {
                    // TODO: handle exception
                }
                return (double) 500;
            }
            
        };

        Callable<Double> callable2 = ()-> {
            System.out.println("Task B is fetching price with "+Thread.currentThread().getName()+"...");
            try {
                    Thread.sleep(new Random().nextInt(4000));
                } catch (Exception e) {
                    // TODO: handle exception
                }
                return (double) 1400;
        }; 
        Callable<Double> callable3 = ()-> {
            System.out.println("Task C is fetching price with "+Thread.currentThread().getName()+"...");
            try {
                    Thread.sleep(new Random().nextInt(4000));
                } catch (Exception e) {
                    // TODO: handle exception
                }
                return (double) 900;
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Double> future1= executorService.submit(callable1);
        Future<Double> future2= executorService.submit(callable2);
        Future<Double> future3= executorService.submit(callable3);
        System.out.println("Task A returned"+future1.get());
        System.out.println("Task A returned"+future2.get());
        System.out.println("Task A returned"+future3.get());
        
        executorService.shutdown();

    }
}