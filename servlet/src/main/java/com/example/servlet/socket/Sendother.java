package com.example.servlet.socket;

import ch.qos.logback.core.util.CloseUtil;
import com.alibaba.fastjson.JSON;
import com.example.servlet.entity.JobReturn;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class Sendother implements Runnable {

    private DataInputStream dis;
    private DataOutputStream dos;
    private boolean flag = true;

    public Sendother(Socket client) {
        try {
            dis = new DataInputStream(client.getInputStream());
            dos = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private String receive(){
        String str="";
        try {
            str=dis.readUTF();
            //反序列化
          //  JobReturn jobReturn= JSON.parseObject(str,JobReturn.class );
          System.out.println("收到"+str);
        } catch (IOException e) {
          flag=false;
          ChatServer.list.remove(this);
        }
return str;
    }
    private void send(  String str){
        if (str!=null&&str.length()!=0){

            try {
                dos.writeUTF(str);
                 System.out.println(str);
            } catch (IOException e) {
               flag=false;
                ChatServer.list.remove(this);
            }
        }
    }

    @Override
    public void run() {
        while (flag) {
sod();

        }
    }
    private void sod(){
        String str=this.receive();
        List<Sendother>list=ChatServer.list;
        for (Sendother other:list){
            if (other==this){
                continue;
            }
          other.send(str);

        }
    }
}
