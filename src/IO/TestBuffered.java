package IO;

import org.junit.Test;

import java.io.*;

public class TestBuffered {
    @Test
    public void testBufferedInputAndOutputStream(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        long start = System.currentTimeMillis();
        try {

            File file = new File("D:\\Ѹ������\\�Ż���.1996-2001.����˫���CMCT��ɽʯ\\�Ż���1.mkv");
            File file1 = new File("D:\\Ѹ������\\�Ż���.1996-2001.����˫���CMCT��ɽʯ\\�Ż���2.mkv");

            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(file1);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] b = new byte[1024];
            int len;
            while ((len = bis.read(b)) != -1){
                bos.write(b,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bos.close();
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        long end = System.currentTimeMillis();
        System.out.println("�����õ�ʱ���ǣ�" + (end - start));
    }

}
