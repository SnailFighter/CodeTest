/**
    银行账号
 */

 import java.lang.Double;
 import java.util.concurrent.locks.ReentrantLock;

 public class BankAccount {

     private String accountNum;

     private String name;

     private Double amount=0.00D;

     private ReentrantLock lock;

     public BankAccount(String accountNum,String name){
         lock = new ReentrantLock();
         this.accountNum = accountNum;
         this.name = name;
     }

    public double addAmount(double num) throws Exception{
        lock.lock();
        try {
            if num<0.00D
                throw new Exception("num 不能小于0");
            amount+=num;
            return amount;
        } finally {
            lock.unlock()
        }
    }

    public double subAmount(double num){

        lock.lock();
        try {
            if num<0.0D
                throw new Exception("num 不能小于0");
            if (amount-=num) <0.00D
                throw new Exception("amount 不能小于0");
            return amount;
        } finally {
            lock.unlock()
        }
    }

    public double getAmount(){
        return amount;
    }

 }