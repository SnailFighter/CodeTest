import java.lang.reflect.Proxy;

/**
 * @describe 公司  公司组织员工出国旅游，通过代理帮员工签证
 * @auther cht
 * @date 十月 26 2018,10:48
 */
public class Company {
    public static void main(String[] args) throws InterruptedException {
        Stuff Bob = new Stuff("Bob");
        Stuff Alice = new Stuff("Alice");

        ApplyOrganization organization = new ApplyOrganization();
        organization.receive(Bob);
        organization.perpare("Bob 资料");
        organization.applyVsia("Bob 资料提交");

        organization.receive(Alice);
        organization.perpare("Alice 资料");
        organization.applyVsia("Alice 资料提交");

        System.out.println("================================================================================");
        //Bob Alice出去旅游啦，招人帮忙替代他们的工作
        Stuff James = new Stuff("James");
        //公司决定找个人力资源外包公司
        ApplyOrganizationHander bobHandler = new ApplyOrganizationHander(Bob);
        ApplyOrganizationHander aliceHandler = new ApplyOrganizationHander(Alice);

        //JDK人力资源内部做了一下其他处理
        Work bobProxy1 = (Work) Proxy.newProxyInstance(bobHandler.getClass().getClassLoader(),
                Bob.getClass().getInterfaces(),bobHandler);
        System.out.println(bobProxy1.print(100));
        Thread.sleep(5*1000);
        Work proxy2 = (Work) Proxy.newProxyInstance(bobHandler.getClass().getClassLoader(),
                Bob.getClass().getInterfaces(),aliceHandler);
        proxy2.print(200);
        Thread.sleep(5*1000);
        //因为Bob的签证上一家代理公司没有搞定，有换了JDK帮忙搞定签证的问题
        ApplyVsia bobProxy2 = (ApplyVsia) Proxy.newProxyInstance(bobHandler.getClass().getClassLoader(),
                Bob.getClass().getInterfaces(),bobHandler);
        bobProxy2.perpare("Bob的资料！");
        bobProxy2.applyVsia("Bob的签证！");
        //stuffBob.print(789);


    }
}
