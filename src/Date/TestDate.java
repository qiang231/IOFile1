package Date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate {


    @Test
    public void test5(){
        System.out.println(Math.pow(3,10));
//        String color = null;
//        System.out.println(color[0]);
    }
    @Test
    public void test4(){
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);

        calendar.add(Calendar.DAY_OF_MONTH,-2);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);

        calendar.set(Calendar.DAY_OF_MONTH,23);
        Date date = calendar.getTime();
        System.out.println(date);


    }
    
    public int getDays(String date1, String date2) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        Date d1 = sdf.parse(date1);
        Date d2 = sdf.parse(date2);
        long milliTime = d2.getTime() - d1.getTime();
        return (int) milliTime/1000/60/60/24 + 1 ;

    }
    @Test
    public void test3() throws ParseException {
        String str = "1990-01-01";
        String str1 = "1990-01-04";
        int dates = getDays(str1,str1);
        if (dates % 5 == 0 || dates % 5 == 4){
            System.out.println("晒网");
        }else {
            System.out.println("打鱼");
        }

    }








    @Test
    public void test1(){
        //1.格式化1
        SimpleDateFormat sdf = new SimpleDateFormat();
        String str = sdf.format(new Date());
        System.out.println(str);

        //2格式化
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
        str = sdf2.format(new Date());
        System.out.println(str);

        //3.解析
        try {
            Date date = sdf.parse("2018/11/5 上午10:33");
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }







    @Test
    public void test(){

        Date date = new Date();
        System.out.println(date.toString());
        System.out.println(date.getTime());
        Date date2 = new Date(1541384709599l);
        System.out.println(date2);


        java.sql.Date date1  = new java.sql.Date(1541384709599L);
        System.out.println(date1);

    }
}
