
import java.lang.Long;

public class Student {

    private Long id;
   
    private String name;

    public Student(){

    }

    public Student(Long id,String name){
        this.id = id;
        this.name = name;
    }


    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

}