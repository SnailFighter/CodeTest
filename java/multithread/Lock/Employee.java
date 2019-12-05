/**
    员工
 */

 public class Employee {

     private String name;
     
     private CyclicBarrier barrier;

     public Employee(String name,CyclicBarrier barrier){
         this.name = name;
         this.barrier = barrier;
     }

     public double getMoney(BankAccount account,int money){
        return account.subAmount(money);
     }

     public double putMoney(BankAccount account,int money){
        return account.addAmount(money);
     }


 }