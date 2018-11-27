package IO;

import org.junit.Test;

import java.io.File;
import java.util.Date;

/**
 * java.io.File
 * 1.凡是与输入输出类、接口等都定义在java.io包下
 * 2.File是一个类，可以有构造器创建其对象,此对象对应着一个文件或者文件目录
 * 3.File类对象是与平台无关的
 * 4.File中的方法，仅涉及到如何创建、删除、重命名等，涉及内容的只能用流来处理
 * 5.File类的对象通常作为io流的具体类的构造器的形参。
 */
public class TestFile {

    /**
     * 路径
     *      绝对路径：完整路径包括盘符
     *      相对路径：当前文件夹下路径
     */
    @Test
    public void test1(){
        //文件
        File file = new File("D:/io/wss.txt");
        File file1 = new File("hello.txt");
        //文件目录
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
