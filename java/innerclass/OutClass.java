public class OutClass {

    private int a;

    public int b;


    public OutClass(int a,int b){
        this.a = a;
        this.b = b;
    }


    private int getA (){
        return a;
    }

    public int getB (){
        return b;
    }

    class InnerClass {
        private int c;

        public int d;

        public InnerClass(int c,int d) {
            this.c = c;
            this.d = d;
        }

        public int sum(){
            return a+b;
        }

        private int sum1(){
            return c+d;
        }

        //inner class calls out class's private mehtod
        public int getOutA() {
            return getA();
        }

        //inner class calls out class's public method
        public int getOutB() {
            return getB();
        }
    }

    //static inner class 
    static class InnerClass1 {
        private static int a=10;

        private static void printA(){
            System.out.println(a);
        }
    }

    public static void main(String[] args){
        OutClass outClass = new OutClass(50,20);
        InnerClass innerClass = outClass.new InnerClass(100,20);
        System.out.println(innerClass.sum());  //70 
        System.out.println(innerClass.sum1()); // 120

        System.out.println(innerClass.getOutA()); // 50
        System.out.println(innerClass.getOutB()); // 20

        
        OutClass.InnerClass1.printA(); //10

    }


}