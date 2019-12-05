/**
出纳人员
 */

 public class Cashier {

     private String name;

     public Cashier(String name){
         this.name = name;
     }

     public double subMoney(BankAccount account,int money){
        return account.subAmount(money);
     }

     public void putMoney(BankAccount account,int money){
        return account.addAmount(money);
     }


 }