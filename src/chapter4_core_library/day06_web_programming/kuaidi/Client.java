package chapter4_core_library.day06_web_programming.kuaidi;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        Socket socket = new Socket("127.0.0.1", 55565);
        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();

//        while (true){

            // 客户端发话
            PrintStream ps = new PrintStream(os);
            ps.println("hello");

            // 客户端收到消息
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String text = br.readLine();
            System.out.println("客户端接到消息："+text);

//        }

    }
}
