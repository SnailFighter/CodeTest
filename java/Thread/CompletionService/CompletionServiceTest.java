import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CompletionServiceTest {
	public static void main(String[] args){
		try{
			List<MyCallable> callableList = new ArrayList<MyCallable>(6);
			for(int i=0;i<=5;i++){
				MyCallable callable = new MyCallable("username"+i,(6-i)*1000);
				callableList.add(callable);
			}


			ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,5,TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>());
			CompletionService completionService  = new ExecutorCompletionService(executor);

			for(int i=0;i<=5;i++){
				completionService.submit(callableList.get(i));
			}

			for(int i=0;i<=5;i++){ // if we modify the i<=6, so the result will be?
				System.out.println("---------------------------------");
				//System.out.println(completionService.take().get());
				// if we use poll method ,what result is ?
			//	System.out.println(completionService.poll().get());
				System.out.println(completionService.poll(3,TimeUnit.SECONDS).get());
			}

			executor.shutdown();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
