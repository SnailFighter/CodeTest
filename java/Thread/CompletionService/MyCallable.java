import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

	private String username;
	private long sleeptime;

	public MyCallable(String username,long sleeptime){
		super();
		this.username = username;
		this.sleeptime = sleeptime;
	}

	@Override
	public String call() throws Exception{
		System.out.println("the username : "+username+"   I sleep: "+sleeptime +" ms");
		Thread.sleep(sleeptime);
		return "return"+username;
	}

}
