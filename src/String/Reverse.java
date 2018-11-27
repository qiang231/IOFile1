package String;

import org.junit.Test;

public class Reverse {

    @Test
    public static String reverse2(String str){

        StringBuffer sb  = new StringBuffer(str);
        for (int i = str.length(); i >=0 ; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }


    @Test
    public static String reverse1(String str){
        StringBuffer sb = new StringBuffer(str);
        StringBuffer sb1 = sb.reverse();
        return sb1.toString();

    }








    @Test
    public static String reverse(String str){
        char[] c = str.toCharArray();
        for (int x = 0, y = c.length-1; x < y; x++, y--) {
            char temp = c[x];
            c[x]= c[y];
            c[y] = temp;
        }
        return new String(c);
    }
}
