/**
 * 懒汉式的另一种方式
 */

 public class SingleInstance1 {
    public final static SingleInstance1 instance;
    static {
        instance = new SingleInstance1();
    }

	private SingleInstance(){}

	public static SingleInstance getInstance(){
		return instance;
	}
 }