package String;

import org.junit.Test;

public class TestStringBuffer {

    @Test
    public void test(){

        long statTime = 0;
        long endTime = 0;

        String text = "";
        StringBuffer buffer= new StringBuffer();
        StringBuilder builder = new StringBuilder();

        statTime = System.currentTimeMillis();
        for (int i = 0; i <20000 ; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer用时"+ (endTime-statTime) );

        statTime = System.currentTimeMillis();
        for (int i = 0; i <20000 ; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder用时"+ (endTime-statTime) );

        statTime = System.currentTimeMillis();
        for (int i = 0; i <20000 ; i++) {
            text += i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String用时"+ (endTime-statTime) );

    }


}
