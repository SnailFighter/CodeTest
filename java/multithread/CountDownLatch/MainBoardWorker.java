/**
    主板生产工人
 */
 import java.util.concurrent.CountDownLatch;
 import java.lang.Runnable;
 import java.lang.Thread;
   import java.lang.Exception;


 public class MainBoardWorker implements Work {

     CountDownLatch cdl;
     
     public MainBoardWorker(CountDownLatch cdl){
        this.cdl = cdl;
     }
     
     public boolean prepare(){
         
         System.out.println("------------主板生产工人准备完毕！--------------");
         return true;
         
     }

     public int produce(String productName,int count){return 0; };

     public boolean finish(){
         return true;

     }

     public void run() {
         
         try{
            System.out.println("-------MainBoardWorker-------开始工作了-----------");
            Thread.currentThread().sleep(10000);
            System.out.println("-------MainBoardWorker-------主板一个-----------");
             cdl.countDown();
         }catch(Exception e){
            e.printStackTrace();
         }
     }
 }