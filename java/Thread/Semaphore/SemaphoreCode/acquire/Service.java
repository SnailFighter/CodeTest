import java.util.concurrent.*;
import java.lang.InterruptedException;
import java.lang.Thread;

public class Service{
	private Semaphore semaphore = new Semaphore(10);//允许2个线程执行acquire & release之间的代码;

	public void testMethod(){
		try{
			semaphore.acquire(2);
			System.out.println(Thread.currentThread().getName()+" begin time: "+System.currentTimeMillis());
			
			Thread.sleep((5000));

			System.out.println(Thread.currentThread().getName()+" end time: "+System.currentTimeMillis());
			semaphore.release();	
		}catch(InterruptedException e){
			e.printStackTrace();	
			semaphore.release();	
		}
	}

}
// 需要注意的是构造方法permits>1 不能保证线程安全。
