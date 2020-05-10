package chapter4_core_library.day06_web_programming;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo {
    /**
     * 服务器
     */
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
                        BufferedReader br = new BufferedReader(new InputStreamReader(is));

                        OutputStream os = socket.getOutputStream();
                        PrintStream ps = new PrintStream(os);

                        // 1. 发
                        ps.println("1");

                        // 4. 收
                        System.out.println(br.readLine());
                        // 5. 发
                        ps.println("3");

                        // 8. 收
                        System.out.println(br.readLine());
                        // 9. 发
                        ps.println("5");

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
            System.out.println("一个客户端连接了");
        }



    }
}
