package inet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress:λ��java.net����
 * 1.�������IP��ַ
 */
public class TestINet {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inet = InetAddress.getByName("www.baidu.com");
        System.out.println(inet.getHostName());
        System.out.println(inet.getHostAddress());
        System.out.println(inet);

        InetAddress inet1 = InetAddress.getLocalHost();
        System.out.println(inet1);
        System.out.println(inet1.getHostAddress());
        System.out.println(inet1.getHostName());
    }
}
