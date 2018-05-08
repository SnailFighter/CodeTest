import java.util.function.*;

public class QueueUp{
    public static void main(String[] args){
        Man man = new Man(0);
        queue(obj->obj.getSex()==0,obj->obj.setQueueTag("left"),man);
        System.out.println(man.getQueueTag());

        Man man1 = new Man(1);
        queue(obj->obj.getSex()==1,obj->obj.setQueueTag("right"),man1);
        System.out.println(man1.getQueueTag());

        Man man3 = new Man(0);
        queue(obj->obj.getSex()==1,obj->obj.setQueueTag("right"),man3);
        System.out.println(man3.getQueueTag());
        
       
    }

    public static void queue(Predicate<Man> predicate,Consumer<Man> consumer,Man man){
        if(predicate.test(man)){
            consumer.accept(man);
        }
    }


}