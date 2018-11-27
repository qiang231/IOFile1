package IO;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestFileReaderAndWriter {

    @Test
    public void tsetReaderAndWriter(){

        FileReader fr = null;
        FileWriter fw = null;

        try {
            File file = new File("hello2.txt");
            File file1 = new File("hello4.txt");
            fr = new FileReader(file);
            fw = new FileWriter(file1);

            int len;
            char[] chars = new char[24];
            while ((len = fr.read(chars)) != -1) {
                fw.write(chars, 0, len);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void testREader(){
        FileReader fr = null;
        try {
            File file = new File("hello2.txt");
            fr = new FileReader(file);

            char[] chars = new char[24];
            int len;
            while ((len = fr.read(chars)) != -1){
                String str = new String(chars,0,len);
                System.out.println(str);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
