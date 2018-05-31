import java.lang.reflect.*;

public class Test{

	public static void main(String[] args){

		TsinghuaUniversity qinghua = new TsinghuaUniversity();
		CollectionAgent agent = new CollectionAgent(qinghua);
		
		IUniversity proxy = (IUniversity)Proxy.newProxyInstance(IUniversity.class.getClassLoader(),new Class[]{IUniversity.class},agent);
		proxy.collection();
	}
}
