import java.util.concurrent.atomic.*;
import java.lang.Thread;
import java.lang.Runnable;
import java.lang.Exception;

public class AtomicTest {
	public static void main(String[] args) throws Exception{

		int normalInteger = 1;
		
		AtomicInteger atomicInt = new AtomicInteger(1);
		System.out.println(atomicInt.get());


		for(int i=0;i<50;i++){
			Thread.sleep(2);
			normalInteger++;
			// owning of passing the copy of normalInteger's value ,
			//so new thread update the copy value cannot affect the originlly value.
			new Thread(new ComputeNum(normalInteger,atomicInt)).start();
		}
	}
}

class ComputeNum extends Thread{

	private int num1;
	private AtomicInteger num2;

	public ComputeNum(int num1,AtomicInteger num2){
		this.num2 = num2;
		this.num1 = num1;
	}

	public ComputeNum(){}

	@Override
	public void run(){
		System.out.println("int --------------"+(num1+1));
		num2.incrementAndGet();
		System.out.println("AtomicInteger----"+(num2.addAndGet(1)));

	}
}