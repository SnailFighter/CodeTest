import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class MapTest {
    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(1,2,3,4,8,0,2,3,5,90,32,33,17,98,29);

        List<String> listb = Arrays.asList("a","b","c","d","E","F","G");
        Test test = new Test(1L,"aaa",1);
        List<Test> listc = new ArrayList(){{
            add(test);
            add(new Test(2L,"BBB",2));
            add(new Test(3L,"ccc",32));
        }};

        List<Integer> lista_1 = lista.stream().map(Integer::intValue).collect(Collectors.toList());
        List<Integer> lista_2 = lista.stream().map(x->x*2).collect(Collectors.toList());
        List<String> listb_b = listb.stream().map(String::toUpperCase).collect(Collectors.toList());
        List<String> listc_1 = listc.stream().map(Test::getInfo).collect(Collectors.toList());
        List<String> listc_2 = listc.stream().map(x->x.getInfo()).collect(Collectors.toList());

        System.out.println(lista_1);
        System.out.println(lista_2);
        System.out.println(listb_b);
        System.out.println(listc_1);
        System.out.println(listc_2);

        /*
        [1, 2, 3, 4, 8, 0, 2, 3, 5, 90, 32, 33, 17, 98, 29]
        [2, 4, 6, 8, 16, 0, 4, 6, 10, 180, 64, 66, 34, 196, 58]
        [A, B, C, D, E, F, G]
        [aaa  1, BBB  2, ccc  32]
        [aaa  1, BBB  2, ccc  32]
        */

    }

    
}

class Test {
        private Long id;

        private String name;

        private int level;

        public Test(){}

        public Test(Long id,String name,int level){
            this.id = id;
            this.name = name;
            this.level = level;
        }

        public String getInfo(){
            return name+"  "+level;
        }
    }