/**
 * 懒汉式，这种方法不适合在多线程的环境下，不推荐使用
 */

 public class Instance {
     private static Instance instance;
     private Instance(){}

     public static Instance getInstance(){
         if(instance == null)
            return new Instance();
         else
            return instance;   
     }
 }