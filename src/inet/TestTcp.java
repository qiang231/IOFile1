package inet;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

//TCP编程例题
//客户端给服务端发送信息，服务端输出此信息到控制台上
public class TestTcp {

    @Test
    public void cilent(){
        Socket socket = null;
        OutputStream os = null;
        try {
            //1.创建一个Socket对象，通过构造器指明服务器的IP地址以及端口号
            socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
            //getOutputStream
            os = socket.getOutputStream();
            //具体输出过程
            os.write("我是客户端".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null)
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (socket != null)
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //服务端
    @Test
    public  void server(){
        ServerSocket ss = null;
        Socket s = null;
        InputStream is = null;
        try {
            //1.创建一个ServerSocket的对象，通过构造器指明自身的端口号
            ss = new ServerSocket(9090);
            //调用accept（）方法，返回一个Socket的队形
            s = ss.accept();
            //3.调用Socket的getInputStream（）获取一个从客户端发送过来的输入流
            is = s.getInputStream();
            //4.对获取的输入流进行处理
            byte[] bytes = new byte[20];
            int len;
            while ((len = is.read(bytes)) != -1){
                String str = new String(bytes,0,len);
                System.out.println(str);
            }
            System.out.println("收到来自于"+s.getInetAddress().getHostAddress()+"信息");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
