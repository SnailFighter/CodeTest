/**
    工厂工人的接口
 */

 public interface Work extends Runnable{
     public boolean prepare();

     public int produce(String productName,int count);

     public boolean finish();
 }