import java.lang.Object;
import java.util.Objects;

public class Teacher {
    private Long id;

    private String name;

    public Teacher(){}

    public Teacher(Long id,String name){
        this.id = id;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    // only when the value of hashCode() is equal ,the equals() will be involed
    @Override
    public boolean equals(Object o) {
        System.out.println("------------------equals-------------------");
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        Teacher that = (Teacher) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}