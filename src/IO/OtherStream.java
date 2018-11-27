package IO;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class OtherStream {

    @Test
    public void  printStreamWriter(){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File("hello.txt"));
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        PrintStream ps = new PrintStream(fos,true);
        if (ps != null){
            System.setOut(ps);
        }

        for (int i = 0; i < 255; i++) {
            System.out.println((char) i);
            if (i % 100 == 0){
                System.out.println();
            }
        }

        ps.close();

    }
}
