package IO;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 既可以充当输入流也可以充当输出流
 * 支持从任意位置的读取写入
 */
public class TestRandomAccessFile {

    @Test
    public void test1(){

        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(new File("hello.txt"),"rw");

            raf.seek(4);
//            String str = raf.readLine();
//            raf.seek(4);
//            raf.write("xy".getBytes());
//            raf.write(str.getBytes());
            byte[] b = new byte[10];
            int len;
            StringBuffer sb = new StringBuffer();
            while ((len = raf.read(b)) != -1){
                sb.append(new String(b,0,len));
            }
            raf.seek(4);
            raf.write("xy".getBytes());
            raf.write(sb.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        try {
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    @Test
    public void test(){
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("hello.txt"),"r");
            raf2 = new RandomAccessFile(new File("hello3.txt"),"rw");
            byte[] b = new byte[20];
            int len;
            while ((len = raf1.read(b)) != -1){
                raf2.write(b,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                raf1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                raf2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
