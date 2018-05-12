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




/*

1
int --------------3
AtomicInteger----3
int --------------4
AtomicInteger----5
int --------------5
AtomicInteger----7
int --------------6
AtomicInteger----9
int --------------7
AtomicInteger----11
int --------------8
AtomicInteger----13
int --------------9
AtomicInteger----15
int --------------10
AtomicInteger----17
int --------------11
AtomicInteger----19
int --------------12
AtomicInteger----21
int --------------13
AtomicInteger----23
int --------------14
AtomicInteger----25
int --------------15
AtomicInteger----27
int --------------16
AtomicInteger----29
int --------------17
AtomicInteger----31
int --------------18
AtomicInteger----33
int --------------19
AtomicInteger----35
int --------------20
AtomicInteger----37
int --------------21
AtomicInteger----39
int --------------22
AtomicInteger----41
int --------------23
AtomicInteger----43
int --------------24
AtomicInteger----45
int --------------25
AtomicInteger----47
int --------------26
AtomicInteger----49
int --------------27
AtomicInteger----51
int --------------28
AtomicInteger----53
int --------------29
AtomicInteger----55
int --------------30
AtomicInteger----57
int --------------31
AtomicInteger----59
int --------------32
AtomicInteger----61
int --------------33
AtomicInteger----63
int --------------34
AtomicInteger----65
int --------------35
AtomicInteger----67
int --------------36
AtomicInteger----69
int --------------37
AtomicInteger----71
int --------------38
AtomicInteger----73
int --------------39
AtomicInteger----75
int --------------40
AtomicInteger----77
int --------------41
AtomicInteger----79
int --------------42
AtomicInteger----81
int --------------43
AtomicInteger----83
int --------------44
AtomicInteger----85
int --------------45
AtomicInteger----87
int --------------46
AtomicInteger----89
int --------------47
AtomicInteger----91
int --------------48
AtomicInteger----93
int --------------49
AtomicInteger----95
int --------------50
AtomicInteger----97
int --------------51
AtomicInteger----99
when the current value is not equal to the former value,the new value is 1
int --------------52
when the current value is equal to the former value,the new value is10
AtomicInteger----101
AtomicInteger getAndSet:10
AtomicInteger getAndSet:20
the current productNum is:  100
the current productNum is:  200


**/