public class StaticValueWhenCreateInstance {

	
	public static void main(String[] args){
		CounterObject obj = new CounterObject();
		System.out.println(obj.toString());

		CounterObject obj1 = new CounterObject();
		System.out.println(obj1.toString());
	}

	/**
	结果为
	0
	1
	**/

} 
