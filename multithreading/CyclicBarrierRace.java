import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

class CyclicBarrierRace {
    public static void main(String args[]) throws InterruptedException{

        CyclicBarrier barrier = new CyclicBarrier(3,()->{
            System.out.println("All runners are ready. Race begins!");
        });

        CountDownLatch latch = new CountDownLatch(3);
        Runnable worker =()->{
            try{
            System.out.println(Thread.currentThread().getName()+" has arrived on the starting line...");
            int time=3000+new Random().nextInt(2000);
            Thread.sleep(time);
            System.out.println(Thread.currentThread().getName()+" is ready...");
            barrier.await();
            System.out.println(Thread.currentThread().getName()+" starts running!");
            int timetoFinish=4000+new Random().nextInt(4000);
            Thread.sleep(timetoFinish);
            System.out.println(Thread.currentThread().getName()+" has reached the finish line!");
            latch.countDown();
            }
            catch(Exception e){
                System.out.println(e);
            }
        };



        new Thread(worker,"Runner-A").start();
        new Thread(worker,"Runner-B").start();
        new Thread(worker,"Runner-C").start();
        latch.await();
        System.out.println("Race has Ended!");

    }
}