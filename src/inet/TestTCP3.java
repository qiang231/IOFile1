package inet;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TestTCP3 {

    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        InputStream is = null;
        try {
            //1.创建socket的对象
            socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
            os = socket.getOutputStream();
            //2.从本地获取一个文件发送给服务端
            fis = new FileInputStream(new File("hello.txt"));
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes))!= -1){
                os.write(bytes,0,len);
            }
            socket.shutdownOutput();
            //3.接收来自于服务端的信息
            is = socket.getInputStream();
            byte[] bytes1 = new byte[1024];
            int len1;
            while ((len1 = is.read(bytes1))!= -1){
                String str = new String(bytes1,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //4.关闭流和对象
        try {
            is.close();
            fis.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void server(){
        ServerSocket ss = null;
        Socket s = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            //1.创建一个ServerSocket的对象
            ss = new ServerSocket(9090);
            //2.调用accept方法，返回一个Socket的对象
            s = ss.accept();
            //3.将从客户端发送来的信息保存在本地
            is = s.getInputStream();
            fos = new FileOutputStream(new File("hello9.txt"));
            byte[] bytes = new byte[1024];
            int len;
            while ((len = is.read(bytes))!= -1){
                fos.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //4.发送回执信息
        OutputStream os = null;
        try {
            os = s.getOutputStream();
            os.write("接收成功".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            os.close();
            fos.close();
            is.close();
            s.close();
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
