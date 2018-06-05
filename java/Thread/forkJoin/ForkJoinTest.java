import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
	

class ForkJoinTest{
	public static void main(String[] args){
		Long long1 = System.currentTimeMillis();

		ForkJoinPool pool = new ForkJoinPool(2);
		ForkJoinTask<Long> task = new ForkJoinWork(0L,12345L);
		Long invoke = pool.invoke(task);
		Long long2 = System.currentTimeMillis();
		System.out.println(invoke);
		System.out.println(long2-long1);




		Long long3 = System.currentTimeMillis();
		Long sum0=0L;
		for(Long i=0L;i<=12345L;i++){
			sum0+=i;
		}
		Long long4 = System.currentTimeMillis();
		System.out.println(sum0);
		System.out.println(long4-long3);
	}
}