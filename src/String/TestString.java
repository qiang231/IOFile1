package String;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestString {
    public static void main(String[] args) {
        String str1 = "abcdegfsdsferfre";
        String str2 = reverseString(str1,3,5);
        System.out.println(str2);
        String str3 = reverseStrings(str1,3,5);
        System.out.println(str3);
        int i = getTimes("abkasdhewiabufkuabdewkuasdadadkadhiauewdadhlIHFWILFEWab","ab");
        System.out.println("出现的次数"+ i);

    }








    @Test
    public static List<String> getMaxSameSubString(String str1, String str2){
        String maxStr = (str1.length() > str2.length()? str1 : str2);
        String minStr = (str1.length() < str2.length()? str1 : str2);
        int len = minStr.length();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int x = 0 , y = len - i;y <= len; x++, y++) {
                String str = minStr.substring(x,y);
                if (maxStr.contains(str)){
                    list.add(str);
                }
            }
            if (list.size() != 0){
                return list;
            }

        }

        return null;
    }




    @Test
    public static int getTimes(String str1 ,String str2){
        int count = 0;
        int len;
        while (( len = str1.indexOf(str2)) != -1){
            count++;
            str1 = str1.substring(len + str2.length());
        }
        return count;
    }




    @Test
    public void test(){
        String str1 = "abccdefgbcc";
        String str2 = "bcc";

        System.out.println(str1.length());
        System.out.println(str1.charAt(1));
        System.out.println(str1.indexOf(str2,4));
        System.out.println(str1.lastIndexOf(str2));

    }

    @Test
    public static String reverseStrings(String str , int start, int end){
        String str1 = str.substring(0,start);
        for (int i = end; i >= start; i--) {
            char c = str.charAt(i);
            str1 += c;
        }
        str1 += str.substring(end + 1);
        return str1;

    }


    @Test
    public static String reverseString(String str, int start, int end){
        char[] c = str.toCharArray();
        return reverseArray( c,start,end);
    }

    public static String reverseArray(char[] chars, int start, int end){
        for (int i = start, j = end; i < j; i++,j--) {
            char temp = chars[i];
            chars[i]= chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }

    /**
     * 模拟trim去除首尾两端的空格
     * @param str
     * @return
     */
    @Test
    public static String myTrim(String str){
        int start = 0;
        int end = str.length();
        while (start < end && str.charAt(start) == ' '){
            start ++;
        }
        while (start < end && str.charAt(end) == ' '){
            end --;
        }
        return str.substring(start, end + 1);

    }
}
