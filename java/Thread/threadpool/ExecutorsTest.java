import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import java.lang.InterruptedException;


public class ExecutorsTest {
	private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    private static final int RUNNING    = -1 << COUNT_BITS;
	public static void main(String[] args) throws InterruptedException{
	    
	    System.out.println(RUNNING);
		
		int m=0;
		BlockingQueue<Integer> customers = new ArrayBlockingQueue(20,true);
		System.out.println(">>>>>>>>>>>"+customers.remainingCapacity());
		do {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>"+customers.remainingCapacity());
			customers.put(m++); //notice,if while time>20 put method will block all the time
		}while(customers.size()<=11);
		System.out.println("-----------end while----------");
		ExecutorService executor = Executors.newCachedThreadPool();
		//ThreadFactory threadFactory = Executors.defaultThreadFactory();
		for(int i=0;i<customers.size();i++) {
			executor.execute(new Taxi("taxi "+i,2,customers));
		}
		executor.shutdown();
		System.out.println("-------------end--------------");
		
		ScheduledExecutorService executor1 = Executors.newScheduledThreadPool(2);
		for(int i=0;i<5;i++) {
			executor1.schedule(()->{
				try{
					Thread.sleep(10000);
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				System.out.println("------------>>>>>>>>>>>>>>>");
			}, 
				10,
				TimeUnit.SECONDS);
		}
		
		executor1.shutdown();
		
	}
}

interface iTaxi {
	String take();
	void go();
}

class Taxi implements iTaxi,Runnable{
	
	private String name;
	private Integer customerNum;
	private BlockingQueue<Integer> queue;
	
	public Taxi(String name,Integer customerNum,BlockingQueue queue) {
		this.name = name;
		this.customerNum = customerNum;
		this.queue = queue;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String take() {
		if(null==queue) {
			return "queue is null!";
		}
		for(int i=0;i<customerNum;i++) {
			System.out.println("---------------------");
			System.out.println(this.getName() +"  >>> I take "+queue.poll()+" cusomer(s)");
		}
		return "";
	}
	
	
	public void go() {
		System.out.println(this.getName()+">>>Go>>>>");
	}
	
	public void run() {
		System.out.println(take());
		go();
	}
	
}
