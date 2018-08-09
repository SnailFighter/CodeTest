import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import java.lang.Integer;

import java.util.stream.Collectors;

public class ReturnTest1 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(12,34,56,234,22,4);
        

        /*
         if we write code like the follow,the error will occur when compiling

        list.forEach(i->{
            System.out.println(i);
            return (i>10);
        });
        */

        
        // if we write code like the follow,we can get the result is : 12 34 56 22 4 
        // so we can get all elements that is less than 100
        // the loop can run into next loop rather than the loop stops.
        List<Integer> result = new ArrayList<>();
        list.forEach(i->{
            if (i>100)
                return;
            result.add(i);    
        });

        result.forEach(i->System.out.println(i));

        // the result of the follow code is the same as the above code 

        System.out.println("----------------------------------");
        result.clear();
        List<Integer> result1 = list.stream().filter(i->i<100).collect(Collectors.toList());
        result1.forEach(i->System.out.println(i));

    }

}