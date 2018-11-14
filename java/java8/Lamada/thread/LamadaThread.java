/**
    别人问我如何用lamada表达式开启新线程，真的不会。写一下吧
 */

 import java.lang.Thread;

 public class LamadaThread {
     public static void main(String[] args){
         new Thread(()->System.out.println("xxxxxxxxxxxxxxxxxxxxx")).start();

         new Thread (()->{
             int a=0;
             int b=90;
             int c = a*b+12;
             System.out.println(c);
         }).start();
     }
 }