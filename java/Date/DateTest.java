
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateTest {

    public static List<String> dateFormats = new ArrayList<>();
    static {
        dateFormats.add("yyyy-MM-dd");
        dateFormats.add("yyyy/MM/dd");
        dateFormats.add("yyyy-MM-dd HH:mm:ss");
        dateFormats.add("yyyyMMddHHmmss");
    }

    /**
     *
     * @param date 时间
     * @param format 格式
     * @return
     */
    public static Long parseDateString(String date, String format){
        return Objects.requireNonNull(DateTest.parseDate(date, format)).getTime();
    }

    public static Date parseDate(String date, String format){
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            return simpleDateFormat.parse(date);
        }
        catch (ParseException px){
            return null;
        }
        catch (Exception ex){
            return null;
        }
    }


     public static String getLastDayOfMonth(int year,int month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR,year);
        //设置月份
        cal.set(Calendar.MONTH, month-1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return sdf.format(cal.getTime());
    }




    public static void main(String[] args){
        Date date = DateTest.parseDate("2018-04","yyyy-MM");
        System.out.println(date);

        Date date1 = DateTest.parseDate("2018-4","yyyy-MM");
        System.out.println(date1);

        System.out.println(getLastDayOfMonth(2018,4));
        
    }

}    