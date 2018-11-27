package String;

import org.junit.Test;

public class Shift {




    @Test
    public void test4(){
        String str = "1231";
        int i = Integer.parseInt(str);
        System.out.println(i);
        String str1 = String.valueOf(i);
        System.out.println(str1);

        byte[] bytes = str.getBytes();
        for (int j = 0; j < bytes.length; j++) {
            System.out.println((char) bytes[j]);
        }
        System.out.println((char)bytes[1]);

        String str2 = new String(bytes);
        System.out.println(str2);

    }
}
