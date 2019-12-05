/**
    公司
 */

 public class Company{

     private BankAccount ba；
     private Employee employee;
     private Cashier cashier;

     {
         ba = new BankAccount("8888888","刁德一");
         employee = new Employee("杨白劳");
         cashier = new Cashier("出纳");
     }

     public static void main(String[] args){

         //1 添加1000元
         cashier.putMoney(ba,1000);
         

     }
 }