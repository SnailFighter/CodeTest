/**
 * @describe 静态代理  签证代理机构，代理签证业务
 * @auther cht
 * @date 十月 26 2018,10:41
 */
public class ApplyOrganization implements ApplyVsia  {

    private Stuff stuff;

    //接待客户
    public void receive(Stuff stuff){
        System.out.println("你好！");
        this.stuff = stuff;
        System.out.println("业务介绍......");
    }


    @Override
    public String applyVsia(String info) {
        //业务增强
        System.out.println("帮您检查资料，代理服务费500元！");
        return stuff.applyVsia(info);
    }

    @Override
    public void perpare(String info) {
        //业务增强
        System.out.println("帮您资料咨询，代理服务费500元！");
        stuff.perpare(info);
    }
}
