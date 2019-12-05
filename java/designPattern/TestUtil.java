
import java.util.concurrent.CountDownLatch;
import java.lang.Thread;
import java.lang.Exception;

public class TestUtil {
	public static void main(String[] args) throws Exception{
		CountDownLatch cdl = new CountDownLatch(5);
		for(int i=0;i<5;i++){
			new Thread(()->{			
					Instance1 instance = Instance1.getInstance();
					System.out.println("--------------"+instance.toString());
					}).start();
				
			cdl.countDown();
		}	
		
		Thread.sleep(1000);
		System.out.println("-----------------------------------------");

		for(int i=0;i<5;i++){
			Thread.sleep(5000);
			new Thread(()->{			
					Instance1 instance = Instance1.getInstance();
					System.out.println("--------------"+instance.toString());
					}).start();
		}	
	}
}

/**
*

[snial@snail designPattern]$ java TestUtil 
--------------SingleInstance@352ebfc0
--------------SingleInstance@352ebfc0
--------------SingleInstance@352ebfc0
--------------SingleInstance@352ebfc0
--------------SingleInstance@352ebfc0




[snial@snail designPattern]$ java TestUtil 
--------------Instance@7ac3ed36
--------------Instance@144816f1
--------------Instance@352ebfc0
--------------Instance@7fc089c2
--------------Instance@22c679df
-----------------------------------------
--------------Instance@5b069dab
--------------Instance@6ca1879
--------------Instance@3c8eb742
--------------Instance@d8488cb
--------------Instance@37c3a03e


可以看到这里的实例的内存地址不是同一个


*/
