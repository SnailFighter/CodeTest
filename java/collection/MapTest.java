import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTest {

    public static void main(String[] args){
        Map<String,String> map = new HashMap<String,String>();
        for(Integer i=0;i<20;i++){
            map.put(i.toString(),i.toString());
        }
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()){
            System.out.println(it.next());
            it.remove();
        }
        if(map.isEmpty()){
            System.out.print("map is empty");
        }else {
            System.out.print("map is not empty");
        }




    }


}
