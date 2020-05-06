package chapter4_core_library.day06_web_programming.kuaidi;

import chapter4_core_library.day06_web_programming.kuaidi.main.Main;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        // 创建服务器
        ServerSocket server = new ServerSocket(55565);
        System.out.println("服务器启动完毕");
        // 等待客户端的连接
        while (true){
            Socket socket = server.accept();
            new Thread(){
                @Override
                public void run() {
                    try {
                        InputStream is = socket.getInputStream();
                        OutputStream os = socket.getOutputStream();
//                        Scanner scanner = new Scanner(is);
//                        Main main = new Main();
//                        main.start();

//                        while (true){
                            // 收到客户端发话
                            BufferedReader br = new BufferedReader(new InputStreamReader(is));
                            String text = br.readLine();
                            System.out.println("服务器接到客户端的发话："+text);

                            // 给客户端回话
                            PrintStream ps = new PrintStream(os);
                            ps.println("hello too!");
//                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
            System.out.println("一个客户端连接了");
        }



    }
}
