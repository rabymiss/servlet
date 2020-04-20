package com.example.servlet.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ReadingTask  implements Runnable {
    @Override
    public void run() {

    }

//private InputStream is=null;
//
//
//public ReadingTask(InputStream is){
//   this.is=is;
//
//}
//    @Override
//    public void run() {
//        Scanner scanner=new Scanner(System.in);
//
//            try (DataInputStream in=new DataInputStream(is)){
//
//                for (;;){
//               String msg=in.readUTF();
//               System.out.println("对方说:"+msg);
//                }
//
//
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//    }
}
