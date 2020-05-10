package chapter4_core_library.day06_web_programming;

import java.io.*;
import java.net.Socket;

public class ClientDemo {
    /**
     * 客户端
     */
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 55565);

        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        OutputStream os = socket.getOutputStream();
        PrintStream ps = new PrintStream(os);

        // 2. 收
        System.out.println(br.readLine());
        // 3. 发
        ps.println("2");

        // 6. 收
        System.out.println(br.readLine());
        // 7. 发
        ps.println("4");

        // 10. 收
        System.out.println(br.readLine());
    }
}
