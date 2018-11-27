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
            //1.����socket�Ķ���
            socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
            os = socket.getOutputStream();
            //2.�ӱ��ػ�ȡһ���ļ����͸������
            fis = new FileInputStream(new File("hello.txt"));
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes))!= -1){
                os.write(bytes,0,len);
            }
            socket.shutdownOutput();
            //3.���������ڷ���˵���Ϣ
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
        //4.�ر����Ͷ���
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
            //1.����һ��ServerSocket�Ķ���
            ss = new ServerSocket(9090);
            //2.����accept����������һ��Socket�Ķ���
            s = ss.accept();
            //3.���ӿͻ��˷���������Ϣ�����ڱ���
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
        //4.���ͻ�ִ��Ϣ
        OutputStream os = null;
        try {
            os = s.getOutputStream();
            os.write("���ճɹ�".getBytes());
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
