package inet;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TestTCP1 {
    @Test
    public void client(){
        //1.
        Socket socket = null;
        OutputStream os = null;
        Scanner in = null;
        InputStream is = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);

            //2.
            os = socket.getOutputStream();
            //3.向服务器发送数据
//        os.write("abc".getBytes());
            System.out.print("请输入多个字符：");
            in = new Scanner(System.in);
            String str = in.next();
            os.write(str.getBytes());
            socket.shutdownOutput();
            //4.接收来自于服务器的数据
            is = socket.getInputStream();
            byte[] b = new byte[10];
            int len;
            while ((len = is.read(b))!=-1){
                String str1 = new String(b,0,len);
                System.out.println(str1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            in.close();
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //5.


    }

    @Test
    public void server(){
        //1.
        ServerSocket ss = null;
        Socket s = null;
        InputStream is = null;
        OutputStream os = null;
        try {
            ss = new ServerSocket(9090);
            //2.
            s = ss.accept();
            //3.接收来自客户端的信息
            is = s.getInputStream();
            byte[] b  = new  byte[10];
            int len;
            String str = new String();
            while ((len = is.read(b))!= -1){
                String str1 = new String(b,0,len);
                str += str1;
            }
            String strUpper = str.toUpperCase();
            //4.返回给客户端
            os = s.getOutputStream();
            os.write(strUpper.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //5.
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


}
