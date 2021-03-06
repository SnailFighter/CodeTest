import java.util.concurrent.*;
import java.lang.InterruptedException;
import java.lang.Thread;

public class Service{
	private Semaphore semaphore = new Semaphore(1);

	public void testMethod(){
		try{
			semaphore.acquire();
			System.out.println(Thread.currentThread().getName()+" begin time: "+System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName()+" end time: "+System.currentTimeMillis());
				semaphore.release();	
		}catch(InterruptedException e){
			e.printStackTrace();	
			semaphore.release();	
		}
	}

}
