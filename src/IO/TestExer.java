package IO;

import org.junit.Test;

import java.io.*;

public class TestExer {

    //字节流实现文件的复制
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


    //字符流实现文件的复制
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


    //使用字符流实现字符的读入
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



    //使用字符流实现内容的输出
    @Test
    public void test1(){
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("hello1.txt"));
            String str = "要闻|湖北要闻\n" +
                    "习近平广东考察重要讲话引发热烈反响\n" +
                    "习近平再赴广东考察的几重“心意”\n" +
                    "习近平给民营经济再吃定心丸 民企当体会怎样深意？\n" +
                    "备战进博会 青浦进入实战演练 德国建筑师点赞上海\n" +
                    "北京航食：努力做成百年老字号\n" +
                    "18亿元纾困专项债增援民企流动性\n" +
                    "民营航天 加油向未来！ 河北等5地方和单位整改情况\n" +
                    "世纪梦圆：1999年澳门回归\n" +
                    "重庆书记、市长指挥公交车坠江事故救援工作(图)\n" +
                    "救援持续！70多艘救援船在坠江水域连夜搜救(组图)\n" +
                    "市场监管总局：对武汉生物疫苗事故处罚偏轻\n" +
                    "海关总署主动清退500万元，为啥？\n" +
                    "中纪委机关报：公安局长咋成了“护黑局长”？(图)";
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

            String str = "要闻|湖北要闻\n" +
                    "习近平广东考察重要讲话引发热烈反响\n" +
                    "习近平再赴广东考察的几重“心意”\n" +
                    "习近平给民营经济再吃定心丸 民企当体会怎样深意？\n" +
                    "备战进博会 青浦进入实战演练 德国建筑师点赞上海\n" +
                    "北京航食：努力做成百年老字号\n" +
                    "18亿元纾困专项债增援民企流动性\n" +
                    "民营航天 加油向未来！ 河北等5地方和单位整改情况\n" +
                    "世纪梦圆：1999年澳门回归\n" +
                    "重庆书记、市长指挥公交车坠江事故救援工作(图)\n" +
                    "救援持续！70多艘救援船在坠江水域连夜搜救(组图)\n" +
                    "市场监管总局：对武汉生物疫苗事故处罚偏轻\n" +
                    "海关总署主动清退500万元，为啥？\n" +
                    "中纪委机关报：公安局长咋成了“护黑局长”？(图)";

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
