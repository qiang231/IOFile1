package IO;

import org.junit.Test;

import java.io.*;


/**
 * IO集：
 * 抽象基类
 * InputStream      FileInputStream
 * OutPutStream     FileOutputStream
 * Reader           FileReader
 * Writer           FileWriter
 */
public class TestInputOutStream {


    public void copyFile(String src, String desc){
            //1.提供文件
            File file = new File(src);
            File file1 = new File(desc);
            FileInputStream fis = null;
            FileOutputStream fos = null;

            try {
                fis = new FileInputStream(file);
                fos = new FileOutputStream(file1);

                //3.实现文件的复制
                byte[] b = new byte[1024];
                int len ;
                //                System.out.println(bytes[len]);
                while ((len = fis.read(b)) != -1){
                    fos.write(b,0,len);
                }


            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        }



    @Test
    public void testFileInputAndOutputStream(){
        //1.提供文件

        File file = new File("D:\\Program Files\\Java\\work\\workspace\\hello\\1.jpg");
        File file1 = new File("2.jpg");
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);

            //3.实现文件的复制
            byte[] b = new byte[100];
            int len ;
            //                System.out.println(bytes[len]);
            while ((len = fis.read(b)) != -1){
                fos.write(b,0,len);
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }



    @Test
    public void testFileOutputStream(){
        //1.创建一个File对象，表明要写入的位置
        File file = new File("hello2.txt");
        //2.创建一个FIleOutputStream的对象，将flie的对象作为形参传递到这个构造器中
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            //3.写入操作
            fos.write(new String("I love world！").getBytes());


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (fos != null) {
                try {
                    //4.关闭输出流
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }












    @Test
    public void test(){
        FileInputStream fis = null;
        try {
            File file = new File("wsss.txt");
            fis = new FileInputStream(file);
            byte[] bytes = new byte[5];     //读取到的数据要写入的数组
            int len;
            while ((len = fis.read(bytes)) != -1){
                for (int i = 0; i < len; i++) {
                    System.out.println((char) bytes[i]);
                }
                String str = new String(bytes,0,len);
                System.out.print(str);
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }





    @Test
    public void testInputStream1() throws IOException {

        //1.创建一个File文件类的对象
        //2.创建一个FileInputStream
        FileInputStream fis = null;
        try {
            File file = new File("wsss.txt");
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //3.调用方法读取
        int b;
        while ((b = fis.read()) != -1){
            System.out.println((char) b);
        }
        //4.关闭相应的流
        fis.close();


    }
    //从硬盘中读取文件内容
    @Test
    public void testInputStream() throws IOException {

        //1.创建一个File文件类的对象
        File file = new File("wsss.txt");
        //2.创建一个FileInputStream
        FileInputStream fis = new FileInputStream(file);
        //3.调用方法读取
//        int b = fis.read();
//        while (b != -1){
//            System.out.println((char) b);
//            b= fis.read();
//        }
        int b;
        while ((b = fis.read()) != -1){
            System.out.println((char) b);
        }
        //4.关闭相应的流
        fis.close();


    }
}
