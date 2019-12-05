import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @describe jdk动态代理 名字为JDK的代理公司,可以代理一些指定业务
 * @auther cht
 * @date 十月 26 2018,10:55
 */
public class ApplyOrganizationHander implements InvocationHandler {

    private Object obj;

    public ApplyOrganizationHander(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //业务增处理，
        Stuff stuff = obj==null?null:(Stuff)obj;
        if(null==stuff){
            return null;
        }
        else if(stuff.getName().equals("Bob")){
            //特定对像的业务
            System.out.println("嗨，Bob，我们决定给你8折优惠！");
        }
        else {
            System.out.println("大众优惠啦，9.5折了！");
        }
        System.out.println(method.getName()+ "  hello! "+stuff.getName()+"    JDK公司收服务费100元！");
        Object result  =  method.invoke(obj,args);
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<  result"+result);
        return result;
    }
}
