 
/**
* 饿汉式：在类加载时即完成初始化，即使多个线程同时请求，也返回同一个实例。
*
*/
public class SingleInstance {
	public final static SingleInstance instance =  new SingleInstance();

	private SingleInstance(){}

	public static SingleInstance getInstance(){
		return instance;
	}

}

