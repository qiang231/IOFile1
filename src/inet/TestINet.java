package inet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress:位于java.net包下
 * 1.代表代表IP地址
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
