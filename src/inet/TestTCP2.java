package inet;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP���ʵ��
 * �ͻ��˷�����Ϣ����������������������Ϣ
 */
public class TestTCP2 {
    //�ͻ���
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        InputStream inputStream= null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"),8090);
            os = socket.getOutputStream();
            os.write("���ǿͻ���".getBytes());
            //ִ�д˷�������ʾ�ĸ��߷������������
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
            os.write("���յ�".getBytes());
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
