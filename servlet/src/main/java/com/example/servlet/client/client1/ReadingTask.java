package com.example.servlet.client.client1;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ReadingTask  implements Runnable {

  private InputStream is=null;


    public ReadingTask(InputStream inputStream){
        this.is=inputStream;

    }
    @Override
    public void run() {
        Scanner scanner=new Scanner(System.in);

        try (DataInputStream in=new DataInputStream(is)){

            for (;;){
                String msg=in.readUTF();
                System.out.println(msg);
            }



        } catch (IOException e) {

            e.printStackTrace();
        }

    }
}
