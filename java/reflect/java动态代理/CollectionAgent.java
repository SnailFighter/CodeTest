import java.lang.reflect.*;

public class CollectionAgent implements InvocationHandler{
	
	private IUniversity university;
	
	public CollectionAgent(IUniversity university){
		this.university=university;
	}
	
	public Object invoke(Object proxy,Method method,Object[] args) throws Throwable{
		
		if(method.getName().equals("collection")){
			System.out.println("每个学生收1000块代理费。");
              	 	return university.collection();
		}		
		return null;
	}
		

}
