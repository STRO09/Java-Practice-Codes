import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CachedThreadPoolApiHandle {

    public static void main(String args[]) throws InterruptedException{

        ExecutorService executor = Executors.newCachedThreadPool();

        for(int i=0;i<20;i++){  
            int taskid = i;

            executor.submit(()-> {
                System.out.println(Thread.currentThread().getName()+" is handling api-"+taskid);
                int time = 100 + new Random().nextInt(400);
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" finished handling api-"+taskid);
            });

            Thread.sleep(50);
        }


        // for(int i=0;i<20;i++){  
        //     int taskid = i;
        //     Runnable worker = () -> {

        //      System.out.println(Thread.currentThread().getName()+" is handling api-"+taskid);
        //         int time = 100 + new Random().nextInt(400);
        //         try {
        //             Thread.sleep(time);
        //         } catch (InterruptedException e) {
        //             // TODO Auto-generated catch block
        //             e.printStackTrace();
        //         }
        //         System.out.println(Thread.currentThread().getName()+" finished handling api-"+taskid);
        // };
        //     executor.submit(worker);

        //     Thread.sleep(50);
        // }
        executor.shutdown();
    }
}