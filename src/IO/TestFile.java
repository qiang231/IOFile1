package IO;

import org.junit.Test;

import java.io.File;
import java.util.Date;

/**
 * java.io.File
 * 1.��������������ࡢ�ӿڵȶ�������java.io����
 * 2.File��һ���࣬�����й��������������,�˶����Ӧ��һ���ļ������ļ�Ŀ¼
 * 3.File���������ƽ̨�޹ص�
 * 4.File�еķ��������漰����δ�����ɾ�����������ȣ��漰���ݵ�ֻ������������
 * 5.File��Ķ���ͨ����Ϊio���ľ�����Ĺ��������βΡ�
 */
public class TestFile {

    /**
     * ·��
     *      ����·��������·�������̷�
     *      ���·������ǰ�ļ�����·��
     */
    @Test
    public void test1(){
        //�ļ�
        File file = new File("D:/io/wss.txt");
        File file1 = new File("hello.txt");
        //�ļ�Ŀ¼
        File file2 = new File("D:/io/io1");

        File file3 = new File("D:/BaiduNetdiskDownload");
        File[] files = file3.listFiles();
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i].getName() + files[i].length());
        }

//        System.out.println(file.exists());
//        System.out.println(file.canRead());
//        System.out.println(file.canWrite());
//        System.out.println(file.canExecute());
//        System.out.println(file.isFile());
//        System.out.println(file.isDirectory());
//        System.out.println(new Date(file.lastModified()));
//        System.out.println(file.length());







//        System.out.println(file.getName());
//        System.out.println(file.getPath());
//        System.out.println(file.getAbsoluteFile());
//        System.out.println(file.getAbsolutePath());
//        System.out.println(file.getParent());
//        file.renameTo(new File("wsss.txt"));
//        System.out.println(file.getName());



    }

}
