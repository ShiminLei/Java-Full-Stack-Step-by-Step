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
        String text = br.readLine();
        System.out.println("客户端接到消息："+text);

        // 回话
        OutputStream os = socket.getOutputStream();
        PrintStream ps = new PrintStream(os);
        ps.println("welcome!too");
    }
}
