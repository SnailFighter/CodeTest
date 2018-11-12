/**
    CountDownLatch 测试
    工厂生产手机，一个流水线需要20个人同时工作，每个人都是一个线程。
    工人需要 主板生产工、零件生产工、组装工人
 */
 import java.lang.Exception;

 public class Factory {

     public static void main(String[] args) throws Exception{
         AssemblyLine al = new AssemblyLine(3);
         al.start();
     }

 }



