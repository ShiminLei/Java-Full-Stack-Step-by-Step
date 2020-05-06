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
                        OutputStream os = socket.getOutputStream();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
            System.out.println("一个客户端连接了");
        }


//        OutputStream os = socket.getOutputStream();
//        PrintStream ps = new PrintStream(os);
//        ps.println("welcome!");
//
//        InputStream is = socket.getInputStream();
//        BufferedReader br = new BufferedReader(new InputStreamReader(is));
//        String text = br.readLine();
//        System.out.println("服务器接到客户端的回复："+text);



//        System.out.println("服务器程序执行结束");

    }
}
