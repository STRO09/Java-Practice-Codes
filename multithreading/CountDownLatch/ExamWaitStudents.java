import java.util.concurrent.CountDownLatch;


class ExamWaitStudents {
    public static void main(String args[]) throws InterruptedException{
        
        CountDownLatch latch = new CountDownLatch(3);

        Runnable worker =() -> {
            try {
                System.out.println(Thread.currentThread().getName()+" started the exam");
                int time = 1000 + new java.util.Random().nextInt(5000);
                // Thread.sleep(3000); 
                Thread.sleep(time); 
                System.out.println(Thread.currentThread().getName()+" finished the exam");
                latch.countDown();
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(Thread.currentThread().getName()+" ran into an exception: "+e);
            }
           

        };

        new Thread(worker,"Student-A").start();
        new Thread(worker,"Student-B").start();
        new Thread(worker,"Student-C").start();

        latch.await();
        System.out.println("All Students completed their Exam. Exam was a success");
        
    }
}