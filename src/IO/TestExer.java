package IO;

import org.junit.Test;

import java.io.*;

public class TestExer {

    //�ֽ���ʵ���ļ��ĸ���
    @Test
    public void test5(){
        BufferedOutputStream bos = null;
        BufferedInputStream bis = null;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(new File("src/IO/2.png")));
            bis = new BufferedInputStream(new FileInputStream(new File("src/IO/1.png")));

            byte[] bytes = new byte[20];
            int len ;
            while ( ( len = bis.read(bytes)) != -1 ){
                bos.write(bytes,0,len);
                bos.flush();
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


    //�ַ���ʵ���ļ��ĸ���
    @Test
    public void test4(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader("hello.txt"));
            bw = new BufferedWriter(new FileWriter("hello2.txt"));

            char[] c = new char[20];
            int len;
            while ((len = br.read(c) ) != -1){
                bw.write(c,0,len);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //ʹ���ַ���ʵ���ַ��Ķ���
    @Test
    public void test2(){

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("hello.txt"));
            String str ;
            while ((str = br.readLine()) != null){
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }



    //ʹ���ַ���ʵ�����ݵ����
    @Test
    public void test1(){
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("hello1.txt"));
            String str = "Ҫ��|����Ҫ��\n" +
                    "ϰ��ƽ�㶫������Ҫ�����������ҷ���\n" +
                    "ϰ��ƽ�ٸ��㶫����ļ��ء����⡱\n" +
                    "ϰ��ƽ����Ӫ�����ٳԶ����� ��������������⣿\n" +
                    "��ս������ ���ֽ���ʵս���� �¹�����ʦ�����Ϻ�\n" +
                    "������ʳ��Ŭ�����ɰ������ֺ�\n" +
                    "18��Ԫ���ר��ծ��Ԯ����������\n" +
                    "��Ӫ���� ������δ���� �ӱ���5�ط��͵�λ�������\n" +
                    "������Բ��1999����Żع�\n" +
                    "������ǡ��г�ָ�ӹ�����׹���¹ʾ�Ԯ����(ͼ)\n" +
                    "��Ԯ������70���Ҿ�Ԯ����׹��ˮ����ҹ�Ѿ�(��ͼ)\n" +
                    "�г�����ܾ֣����人���������¹ʴ���ƫ��\n" +
                    "����������������500��Ԫ��Ϊɶ��\n" +
                    "�м�ί���ر��������ֳ�զ���ˡ����ھֳ�����(ͼ)";
            bw.write(str);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }




    @Test
    public void test(){
//        FileOutputStream fos = new FileOutputStream(new File("hello.txt"));
//        BufferedOutputStream bos = new BufferedOutputStream(fos);

        BufferedOutputStream bos = null;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(new File("hello.txt")));

            String str = "Ҫ��|����Ҫ��\n" +
                    "ϰ��ƽ�㶫������Ҫ�����������ҷ���\n" +
                    "ϰ��ƽ�ٸ��㶫����ļ��ء����⡱\n" +
                    "ϰ��ƽ����Ӫ�����ٳԶ����� ��������������⣿\n" +
                    "��ս������ ���ֽ���ʵս���� �¹�����ʦ�����Ϻ�\n" +
                    "������ʳ��Ŭ�����ɰ������ֺ�\n" +
                    "18��Ԫ���ר��ծ��Ԯ����������\n" +
                    "��Ӫ���� ������δ���� �ӱ���5�ط��͵�λ�������\n" +
                    "������Բ��1999����Żع�\n" +
                    "������ǡ��г�ָ�ӹ�����׹���¹ʾ�Ԯ����(ͼ)\n" +
                    "��Ԯ������70���Ҿ�Ԯ����׹��ˮ����ҹ�Ѿ�(��ͼ)\n" +
                    "�г�����ܾ֣����人���������¹ʴ���ƫ��\n" +
                    "����������������500��Ԫ��Ϊɶ��\n" +
                    "�м�ί���ر��������ֳ�զ���ˡ����ھֳ�����(ͼ)";

            bos.write(str.getBytes());
            bos.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
