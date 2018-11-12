/**
    组装工人类
 */
 import java.util.concurrent.CountDownLatch;
 import java.lang.Runnable;
  import java.lang.Thread;
    import java.lang.Exception;



 public class AssembleWorker implements Work {

     CountDownLatch cdl;
     
     public AssembleWorker(CountDownLatch cdl){
        this.cdl = cdl;
     }
     
     public boolean prepare(){
         System.out.println("------------组装工人准备完毕！--------------");
         return true;
         
     }

     public int produce(String productName,int count){return 0; };

     public boolean finish(){
        return true;
     }

     public void run() {
         
        try{
            System.out.println("-------AssembleWorker-------开始工作了-----------");
            Thread.currentThread().sleep(15000);
            System.out.println("-------AssembleWorker-------手机一部-----------");
             cdl.countDown();
         }catch(Exception e){
            e.printStackTrace();
         }
     }

 }