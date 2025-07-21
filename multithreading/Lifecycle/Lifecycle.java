class Counter {

private int count = 0;

public void increaseCount() {
this.count++;
System.out.print(Thread.currentThread().getName()+" gave: "+this.count);
}

public int getCount() {
return this.count;
}
}

class Worker implements Runnable {

Counter counter; 

public Worker(Counter counter) {
this.counter = counter;
}

public void run() {
for(int i=0;i<10;i++){
counter.increaseCount();
try {
   Thread.sleep(1000); 
} catch (Exception e) {
    // TODO: handle exception
}
}
}
}

class Lifecycle {
public static void main(String args[]) throws InterruptedException {

Counter counter = new Counter();
Thread t1 = new Thread(new Worker(counter),"Hindu");
Thread t2 = new Thread(new Worker(counter),"Muslim");
t1.start();
t2.start();
t1.join();
System.out.println("The count currently is : "+counter.getCount());

}}