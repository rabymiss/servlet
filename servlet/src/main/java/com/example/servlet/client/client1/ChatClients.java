package com.example.servlet.client.client1;

  //import sun.rmi.rmic.IndentingWriter;

import java.io.*;
import java.net.Socket;

public class ChatClients {
    public static Socket socket;

    public static OutputStream os;
    public static boolean connection_state=false;
    public static void connect(){

    try{

        connection_state=true;
        socket=new Socket("172.20.10.3",8081);
        os=socket.getOutputStream() ;
        new Thread(new ReadingTask(socket.getInputStream())).start();
        new Thread(new WriteTask(os,socket)).start();
    } catch (IOException e){
        e.printStackTrace();
        connection_state=false;
    }
}



   // 重新连接
//    public static void reconnect(){
//
//        while (!connection_state){
//
//            System.out.println("正在尝试重新连接");
//            connect();
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
    public static void main(String[] args){

//        while (!connection_state){
//
//
//            connect();
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }
//connect();
new ChatClients().connect();
    }
}
