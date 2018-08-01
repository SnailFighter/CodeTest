//  to test java8 stream distinct ,of course using set is better

import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DistinctStream {
    public static void main(String[] args){
            Student stu1 = new Student(0L,"Bob");
            Student Stu2 = new Student(1L,"Alise");
            Student stu3 = new Student(2L,"Frank");
            Student stu4 = new Student(0L,"Owen");
            List<Student> list = Arrays.asList(stu1,Stu2,stu3,stu4);
            // distinct by id
            List<Student> dinstinctList 
                = list.stream()
                    .filter(distinctById(p->p.getId()))
                    .collect(Collectors.toList());

            dinstinctList.forEach(p->{
                System.out.println(p.getName());
            });


            System.out.println("count:  "+Stream.of(list).count());
            System.out.println("count:  "+Stream.of("a","b","c").count());

            //----------------------distinct()-------------------------
            List<String> strList = Arrays.asList("A","B","C","A","B");
            List<String> strListDistinct = strList.stream().distinct().collect(Collectors.toList());
            strListDistinct.forEach(
                p->{
                    System.out.println(p);
                }
            );

            
            //-----------------distinct() equal() hashcode()-----------
            Teacher teacher1 = new Teacher(0L,"Teacher Bob");
            Teacher teacher2 = new Teacher(1L,"Teacher Alise");
            Teacher teacher3 = new Teacher(2L,"Teacher Frank");
            Teacher teacher4 = new Teacher(0L,"Teacher Owen");
            Teacher teacher5 = new Teacher(0L,"Teacher Bob");
            Teacher teacher6 = new Teacher(1L,"Teacher Alise");
            List<Teacher> teacherlist = Arrays.asList(teacher1,teacher2,teacher3,teacher4,teacher5,teacher6);
            // distinct by id
            List<Teacher> teacherdisList 
                = teacherlist.stream()
                    .distinct()
                    .collect(Collectors.toList());

            teacherdisList.forEach(p->{
                System.out.println(p.getName());
            });


    }

    // custom the principle
    public static <T> Predicate<T> distinctById(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}