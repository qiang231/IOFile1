package inet;

import java.net.MalformedURLException;
import java.net.URL;

public class TestURL {
    public static void main(String[] args) {
        try {
            URL url = new URL("hello.txt");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }
}
