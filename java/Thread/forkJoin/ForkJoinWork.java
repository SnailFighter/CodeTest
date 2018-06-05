import java.util.concurrent.RecursiveTask;

public class ForkJoinWork extends RecursiveTask<Long>{
	
	private Long start;
	private Long end;

	public static final Long critical = 100L;

	public ForkJoinWork(Long start,Long end){
		this.start=start;
		this.end=end;
	}

	@Override
	protected Long compute(){
		//
		Long length = end - start;
		if(length<critical){
			Long sum = 0L;
			for (Long i=start;i<=end;i++){
				sum+=i;
			}
			return sum;
		}else {
			Long middle = (end+start)/2;
			ForkJoinWork right = new ForkJoinWork(start,middle);
			right.fork();
			ForkJoinWork left = new ForkJoinWork(middle,end);
			left.fork();
			return right.join() + left.join();
		}
	}

}