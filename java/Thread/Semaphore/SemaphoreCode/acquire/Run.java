import java.lang.InterruptedException;

public class Run{
	public static void main(String[] args) throws InterruptedException{
		Service service  = new Service();
		ThreadA[] array = new ThreadA[10];
		for(int i=0;i<10;i++){
		
		  ThreadA a = new ThreadA(service);
		  a.start();
		}
	}
}
