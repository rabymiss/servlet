package com.example.servlet.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
//创建集合对象 储存每一个链接进来的客户端
    public static   List<Sendother>list=new ArrayList<>();
    public void start() {
        //创建线程池  依赖
//     //   Exception pool=new ThreadPoolExecutor(8,8,0l, TimeUnit.SECONDS,new LinkedBlockingQueue<>(Runnable));
//        System.out.println("服务器启动");
//      try(   ServerSocket serverSocket = new ServerSocket(8080);) {
//
//
//
//
//
//
//
//
//      }
//       for (;;){
//
//           //获得客服端连接
//           Socket socket=serverSocket.accept();
//           WriteTask writeTask=new WriteTask(socket.getOutputStream(),socket.getInputStream());
//           list.add(writeTask);
//      //     new Thread(new ReadingTask(socket.getInputStream())).start();
//           new Thread(writeTask).start();
//
//       }
//
//
//      }catch (IOException e){
//          e.printStackTrace();
//      }
    }
    public static void main(String[] args) throws IOException {
        System.out.println("。。。。。。。。。。。。线程已启动。。。。。。。。。。。。。。。。。。。。");
        ServerSocket servert=new ServerSocket(8081);

        while (true){
            Socket socket=servert.accept();
            Sendother sendother=new Sendother(socket);
            String address=socket.getInetAddress().getHostAddress();
            System.out.println(address);
            list.add(sendother);
            System.out.println("新用户加入");
            System.out.println("当前在线人数"+list.size());
            new Thread(sendother).start();
        }


      //  new ChatServer().start();

    }

}
