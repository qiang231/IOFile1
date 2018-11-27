package IO;

import org.junit.Test;

import java.io.*;


/**
 * IO����
 * �������
 * InputStream      FileInputStream
 * OutPutStream     FileOutputStream
 * Reader           FileReader
 * Writer           FileWriter
 */
public class TestInputOutStream {


    public void copyFile(String src, String desc){
            //1.�ṩ�ļ�
            File file = new File(src);
            File file1 = new File(desc);
            FileInputStream fis = null;
            FileOutputStream fos = null;

            try {
                fis = new FileInputStream(file);
                fos = new FileOutputStream(file1);

                //3.ʵ���ļ��ĸ���
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
        //1.�ṩ�ļ�

        File file = new File("D:\\Program Files\\Java\\work\\workspace\\hello\\1.jpg");
        File file1 = new File("2.jpg");
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);

            //3.ʵ���ļ��ĸ���
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
        //1.����һ��File���󣬱���Ҫд���λ��
        File file = new File("hello2.txt");
        //2.����һ��FIleOutputStream�Ķ��󣬽�flie�Ķ�����Ϊ�βδ��ݵ������������
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            //3.д�����
            fos.write(new String("I love world��").getBytes());


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (fos != null) {
                try {
                    //4.�ر������
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
            byte[] bytes = new byte[5];     //��ȡ��������Ҫд�������
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

        //1.����һ��File�ļ���Ķ���
        //2.����һ��FileInputStream
        FileInputStream fis = null;
        try {
            File file = new File("wsss.txt");
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //3.���÷�����ȡ
        int b;
        while ((b = fis.read()) != -1){
            System.out.println((char) b);
        }
        //4.�ر���Ӧ����
        fis.close();


    }
    //��Ӳ���ж�ȡ�ļ�����
    @Test
    public void testInputStream() throws IOException {

        //1.����һ��File�ļ���Ķ���
        File file = new File("wsss.txt");
        //2.����һ��FileInputStream
        FileInputStream fis = new FileInputStream(file);
        //3.���÷�����ȡ
//        int b = fis.read();
//        while (b != -1){
//            System.out.println((char) b);
//            b= fis.read();
//        }
        int b;
        while ((b = fis.read()) != -1){
            System.out.println((char) b);
        }
        //4.�ر���Ӧ����
        fis.close();


    }
}
