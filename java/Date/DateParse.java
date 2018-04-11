
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateParse {

    public static void main(String[] args){
       
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            c.add(Calendar.MONTH, 0);
            c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
            String first = format.format(c.getTime());
            System.out.println(first);

            c.setTime(new Date());
            System.out.println(format.format(c.getTime()));
    }

}    