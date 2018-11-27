package reflect;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TestUDP {

    @Test
    public void send(){

        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket();
            byte[] bytes = "我是要发送的信息".getBytes();
            DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length, InetAddress.getByName("127.0.0.1"),9090);

            ds.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            ds.close();
        }
    }
    //接收端
    @Test
    public void receive(){
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(9090);
            byte[] bytes = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length);
            ds.receive(packet);

            String str = new String(packet.getData(),0,packet.getLength());
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            ds.close();
        }
    }
}
