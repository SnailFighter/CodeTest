/**
 * 懒汉式加锁，这种方法线程安全，但是性能降低了,并不能实现单例
 */

public class Instance1 {
    private static Instance1 instance;
    private Instance1(){}

    public static synchronized Instance1 getInstance(){
        if(instance == null){
           System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
           return new Instance1();
        }else{
           System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
           return instance;   
        }
    }
}