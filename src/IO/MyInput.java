package IO;

import org.junit.Test;

import java.io.*;

public class MyInput {
    @Test
    public void t(){

        DataInputStream dis = null;
        try {
            dis =new DataInputStream(new FileInputStream(new File("data.txt")));
//            byte[] b = new byte[20];
//            int len;
//            while ((len = dis.read(b) ) != -1){
//                System.out.println(new String(b,0,len));
//            }
            String str = dis.readUTF();
            System.out.println(str);
            Boolean b = dis.readBoolean();
            System.out.println(b);
            char c = dis.readChar();
            System.out.println(c);
            System.out.println(dis.readDouble());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void testData(){
        DataOutputStream dos = null;
        try {

            FileOutputStream fos = new FileOutputStream("data.txt");
            dos = new DataOutputStream(fos);
            dos.writeUTF("萨的客户");
            dos.writeBoolean(true);
            dos.writeChars("sda");
            dos.writeDouble(13.21);


        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                dos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


    public  String nextString(){
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String str = null;
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public int nextInt(){
        return Integer.parseInt(nextString());
    }
    public boolean nextBoolean(){
        return Boolean.parseBoolean(nextString());
    }

    public static void main(String[] args) {
        MyInput m = new MyInput();
        System.out.println("输入一个字符串：");
        String s = m.nextString();
        System.out.println(s);
    }
}
