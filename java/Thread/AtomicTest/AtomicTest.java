import java.util.concurrent.atomic.*;
import java.lang.Thread;
import java.lang.Runnable;
import java.lang.Exception;

public class AtomicTest {
	public static void main(String[] args) throws Exception{

		/*--------what is different between  AtmoicInteger and Integer?----------*/
		int normalInteger = 1;
		AtomicInteger atomicInt = new AtomicInteger(1);
		System.out.println(atomicInt.get());
		for(int i=0;i<50;i++){
			Thread.sleep(2);
			normalInteger++;
			// owning of passing the copy of normalInteger's value ,
			//so new thread update the copy value and cannot affect the originlly value.
			new Thread(new ComputeNum(normalInteger,atomicInt)).start();
		}


		/*----------------------------compareAndSet------------------------------*/

		int expect = 10;
		int update = 10;
		AtomicInteger atomicInteger = new AtomicInteger(1);
		atomicInteger.compareAndSet(expect,update);
		System.out.println("when the current value is not equal to the former value,the new value is "+atomicInteger.get());
		atomicInteger.compareAndSet(1,update);
		System.out.println("when the current value is equal to the former value,the new value is"+atomicInteger.get());

		/*----------------------------getAndSet  get the old value---------------*/

		AtomicInteger atomicInteger1 = new AtomicInteger(10);
		System.out.println("AtomicInteger getAndSet:"+atomicInteger1.getAndSet(20));
		System.out.println("AtomicInteger getAndSet:"+atomicInteger1.getAndSet(30));

		/*-------------------------AtomicIntegerFieldUpdater--------------------*/
		/*
			Suppose you have a object named Factory,the object has two fields,name and productNum.
			Now,if you want to use more than one thead to update the productNum,what should you do?
			Here AtomicIntegerFieldUpdater can be a solution.  Let us show an example.
		*/

		AtomicIntegerFieldUpdater<Factory>  intUpdate 
						= AtomicIntegerFieldUpdater.newUpdater(Factory.class,"productNum"); 


		Factory factory = new Factory("McDownland",100);	
		System.out.println("the current productNum is:  "+factory.getProductNum());	
		intUpdate.addAndGet(factory,100);		

		System.out.println("the current productNum is:  "+factory.getProductNum());	



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



class Factory {
	private String name;
	public volatile int productNum;//notice:the field must be public!!!!

	public Factory(){}

	public Factory(String name,int productNum){
		this.name = name;
		this.productNum = productNum;
	}

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}

	public int getProductNum(){
		return this.productNum;
	}

	public void setProductNum(int productNum){
		this.productNum = productNum;
	}
}