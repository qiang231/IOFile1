package IO;

import org.junit.Test;

import java.io.*;

public class TestOtherStream {
    public static void main(String[] args) {
        TestOtherStream t = new TestOtherStream();
        t.test2();
    }


    @Test
    public void test2(){

        InputStream is = System.in;
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        System.out.print("请输入字符串：");
        String str;
        while (true){
            try {
                str = br.readLine();
                if (str.equalsIgnoreCase("e") || str.equalsIgnoreCase("exit")){
                    break;
                }
                String str1 = str.toUpperCase();
                System.out.println(str1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Test
    public void test1(){
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            //解码的过程
            File file = new File("hello.txt");
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis,"GBK");
            br = new BufferedReader(isr);

            //编码的过程
            File file1 = new File("hello1.txt");
            FileOutputStream fos = new FileOutputStream(file1);
            OutputStreamWriter osw = new OutputStreamWriter(fos,"GBK");
            bw = new BufferedWriter(osw);
            String str;
            while ((str = br.readLine()) != null){
                bw.write(str);
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }
}
