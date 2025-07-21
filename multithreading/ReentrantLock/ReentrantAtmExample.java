import java.util.concurrent.locks.ReentrantLock;

class BankAcc {
private int balance = 5000;
private final ReentrantLock lock = new ReentrantLock();


public void withdraw(int amount, String atmname){

try {
    lock.lock();
System.out.println(atmname+ "Trying to withdraw money");

if(balance>=amount) {
System.out.println("Processing withdrawal");
Thread.sleep(2000);
balance-=amount;
System.out.println(atmname+ "withdrew"+ amount);
System.out.println("Current Balance : "+balance);
lock.unlock();
}
else {
System.out.println("Insufficient funds. Current Balance : "+balance);
}

}
catch(Exception e) {
System.out.println("Thread interrupted"+e);
}

}
}



class Atm implements Runnable {

BankAcc account;
String atmname;

public Atm(BankAcc account, String atmname) {
this.account  = account;
this.atmname = atmname;

}

public void run () {
account.withdraw(3000, atmname);
}


}


class ReentrantAtmExample {

public static void main(String[] a) {

BankAcc account = new BankAcc();

Thread t1 = new Thread(new Atm(account,"Atm-1"));
Thread t2 = new Thread(new Atm(account,"Atm-2"));

t1.start();
t2.start();
}

}