package chapter4_core_library.day06_web_programming.kuaidi;

import chapter4_core_library.day06_web_programming.kuaidi.main.Main;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.NoSuchElementException;

public class Server {
    public static void main(String[] args) throws IOException {
        // 创建服务器
        ServerSocket serverSocket = new ServerSocket(55565);
        System.out.println("服务器启动完毕");
        // 等待客户端的连接
        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        Main main = new Main(is, os);
        try {
            main.start();
        } catch (NoSuchElementException e) {
            System.out.println("客户端退出");
            main.getDao().save();
        }
        System.out.println("一个客户端连接了");


    }
}
