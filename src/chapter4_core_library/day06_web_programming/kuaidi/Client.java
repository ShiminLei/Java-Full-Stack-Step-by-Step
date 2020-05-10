package chapter4_core_library.day06_web_programming.kuaidi;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        Socket socket = new Socket("127.0.0.1", 55565);
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        OutputStream os = socket.getOutputStream();
        PrintStream ps = new PrintStream(os);

        while (true){

            // 收
            System.out.println(br.readLine());

            // 发
            ps.println(sc.nextLine());


        }

    }
}
