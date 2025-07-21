class BankAccount {
private int balance =5000; 

public synchronized void deposit(int amount){
try{
System.out.println("Processing deposit....");
Thread.sleep(1000);
balance+= amount;
System.out.println(amount+" deposited successfully!. Current Balance:"+balance);
}
catch(Exception e) {
System.out.println(e);
}

}

public synchronized void withdraw(int amount){
try{
if(amount<=balance){
System.out.println("Processing withdrawal....");
Thread.sleep(1000);
this.balance-= amount;
System.out.println(amount+" withdrawn successfully!. Current Balance:"+balance);
}
else {
System.out.println("Insufficient funds. Current Balance:"+balance);
}
}
catch(Exception e) {
System.out.println(e);
}

}


}


class Thread1 implements Runnable {
BankAccount bankacc;

public Thread1(BankAccount acc) {
this.bankacc = acc;
}
public void run(){
for(int i=0;i<10;i++){
bankacc.deposit(1000);
bankacc.withdraw(5000);
}
}
}

class Thread2 implements Runnable {

BankAccount bankacc;

public Thread2(BankAccount acc) {
this.bankacc = acc;
}
public void run(){
for(int i=0;i<10;i++){
bankacc.withdraw(5000);
bankacc.deposit(1000);
}
}

}

class BankWithdrawDepositExample {
public static void main(String args[]){
BankAccount acc = new BankAccount();

Thread t1 = new Thread(new Thread1(acc));
Thread t2 = new Thread(new Thread2(acc));


t1.start();
t2.start();

}

}