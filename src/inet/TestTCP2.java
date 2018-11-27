package inet;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP编程实例
 * 客户端发送信息给服务器，服务器返回信息
 */
public class TestTCP2 {
    //客户端
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        InputStream inputStream= null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"),8090);
            os = socket.getOutputStream();
            os.write("我是客户端".getBytes());
            //执行此方法，显示的告诉服务器发送完毕
            socket.shutdownOutput();
            inputStream = socket.getInputStream();
            byte[] bytes = new byte[20];
            int len;
            while ((len = inputStream.read(bytes))!= -1){
                String str = new String(bytes,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    @Test
    public void server(){
        ServerSocket ss = null;
        Socket s = null;
        InputStream is = null;
        OutputStream os = null;
        try {
//            ServerSocket serverSocket = new ServerSocket(8900);
//            Socket socket = serverSocket.accept();
//            InputStream inputStream = socket.getInputStream();
            ss = new ServerSocket(8090);
            s = ss.accept();
            is = s.getInputStream();
            byte[] bytes = new byte[20];
            int len;
            while ((len = is.read(bytes))!= -1){
                String str = new String(bytes,0,len);
                System.out.println(str);
            }
            os = s.getOutputStream();
            os.write("已收到".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

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
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (ss != null) {
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
