/**
 * @describe 员工
 * @auther cht
 * @date 十月 26 2018,10:39
 */
public class Stuff implements ApplyVsia,Work {

    private String name;

    public Stuff(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String applyVsia(String info) {
        System.out.println("员工准备递交资料.");
        return info;
    }

    @Override
    public void perpare(String info) {
        System.out.println("员工准备申请资料.");
    }

    @Override
    public int print(int num) {
        System.out.println("今天我"+name+"要印刷"+num+"份杂志！");
        return num;
    }
}
