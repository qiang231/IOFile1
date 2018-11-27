package inet;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

//TCP�������
//�ͻ��˸�����˷�����Ϣ��������������Ϣ������̨��
public class TestTcp {

    @Test
    public void cilent(){
        Socket socket = null;
        OutputStream os = null;
        try {
            //1.����һ��Socket����ͨ��������ָ����������IP��ַ�Լ��˿ں�
            socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
            //getOutputStream
            os = socket.getOutputStream();
            //�����������
            os.write("���ǿͻ���".getBytes());
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


    //�����
    @Test
    public  void server(){
        ServerSocket ss = null;
        Socket s = null;
        InputStream is = null;
        try {
            //1.����һ��ServerSocket�Ķ���ͨ��������ָ������Ķ˿ں�
            ss = new ServerSocket(9090);
            //����accept��������������һ��Socket�Ķ���
            s = ss.accept();
            //3.����Socket��getInputStream������ȡһ���ӿͻ��˷��͹�����������
            is = s.getInputStream();
            //4.�Ի�ȡ�����������д���
            byte[] bytes = new byte[20];
            int len;
            while ((len = is.read(bytes)) != -1){
                String str = new String(bytes,0,len);
                System.out.println(str);
            }
            System.out.println("�յ�������"+s.getInetAddress().getHostAddress()+"��Ϣ");
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
