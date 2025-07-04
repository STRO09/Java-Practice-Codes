class BankAccount {
private int balance; 
private String name; 

BankAccount(String name, int balance){
    this.balance=balance;
    this.name=name;
}

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

public synchronized void transferTo(BankAccount acc, int amount){

    try{
        if(balance>=amount) {
            System.out.println("Attempting Transfer...");
            Thread.sleep(1000);
            this.withdraw(amount);
            acc.deposit(amount);
            System.out.println("Amount Transferred Successfully!. Current balance"+balance);
        }
        else {
            System.out.println("Insufficient funds to Transfer. Current balance"+balance);
        }
    }
    catch(Exception e) {
        System.out.println(e);
    }
}

}


class Thread1 implements Runnable {
BankAccount bankacc, target;

public Thread1(BankAccount acc, BankAccount target) {
this.bankacc = acc;
this.target = target;
}
public void run(){
bankacc.transferTo(target, 5000);
}
}

class Thread2 implements Runnable {

BankAccount bankacc, target;

public Thread2(BankAccount acc, BankAccount target) {
this.bankacc = acc;
this.target = target;
}
public void run(){
bankacc.transferTo(target, 15000);
}

}

class MoneyTransferTwoAccounts {
public static void main(String args[]){

BankAccount acc1 = new BankAccount("Account-A",10000 );
BankAccount acc2 = new BankAccount("Account-B",7000 );

Thread t1 = new Thread(new Thread1(acc1,acc2));
Thread t2 = new Thread(new Thread2(acc2,acc1));

t1.start();
t2.start();
}

}