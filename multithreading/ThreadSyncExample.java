class Counter {
int count=0;
public synchronized void increaseCount(){
count++;
}

}


class Thread1 implements Runnable {
Counter counter;
public Thread1(Counter counter) {
this.counter = counter;
}
public void run(){
for(int i=1;i<=10;i++){
synchronized (counter) {
            counter.increaseCount();
            System.out.println(i);
            System.out.println("Done by + " + Thread.currentThread().getName());
        }
}
}

}

class Thread2 implements Runnable {
Counter counter;
public Thread2(Counter counter ) {
this.counter = counter;
}
public void run(){
for(int i=1;i<=10;i++){
synchronized (counter) {
            counter.increaseCount();
            System.out.println(i);
            System.out.println("Done by + " + Thread.currentThread().getName());
        }
}

}
}

class ThreadSyncExample {

public static void main(String args[]){
Counter sharedcounter = new Counter();
Thread t1 = new Thread(new Thread1(sharedcounter));
Thread t2 = new Thread(new Thread2(sharedcounter));


t1.start();
t2.start();

}

} 