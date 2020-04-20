package com.example.servlet.client.client1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.servlet.entity.JobReturn;
import com.example.servlet.entity.ResumeEntity;
import com.example.servlet.repository.ResumeRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class WriteTask implements Runnable {

    private Socket socket;
    private OutputStream os = null;

    public WriteTask(OutputStream os, Socket socket) {
        this.os = os;
        this.socket = socket;
    }

    @Override
    public void run() {

        DataOutputStream out = new DataOutputStream(os);
        Scanner scanner = new Scanner(System.in);

//for (;;){
//
//    System.out.println("请输入");
//    try {
//        out.writeUTF(scanner.nextLine());
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//}


        JobReturn jobReturn = new JobReturn();
        jobReturn.setErrmsg("成功");
        jobReturn.setErrno(200);
        InputStream inputStream = WriteTask.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ResumeRepository resumeRepository = sqlSession.getMapper(ResumeRepository.class);
        List<ResumeEntity> list = resumeRepository.findAll();
        for (ResumeEntity resumeEntity : list) {

            ResumeEntity resumeEntity1 = new ResumeEntity();
            resumeEntity1.setEmail(resumeEntity.getEmail());
            resumeEntity1.setAddressWork(resumeEntity.getAddressWork());
            resumeEntity1.setBirthday(resumeEntity.getBirthday());
            resumeEntity1.setIfMary(resumeEntity.getIfMary());
            resumeEntity1.setPhone(resumeEntity.getPhone());
            resumeEntity1.setQwer(resumeEntity.getQwer());
            resumeEntity1.setPolitics(resumeEntity.getPolitics());
            resumeEntity1.setTeached(resumeEntity.getTeached());
            resumeEntity1.setShowbyshelf(resumeEntity.getShowbyshelf());
            resumeEntity1.setWorkming(resumeEntity.getWorkming());
            resumeEntity1.setYouname(resumeEntity.getYouname());
            jobReturn.setData(resumeEntity1);
            System.out.println(jobReturn);
            String resume = JSON.toJSONString(jobReturn);
            try {
                out.writeUTF(resume);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


//        JSONObject jsonObject=new JSONObject();
//        jsonObject.put("sdd","adasdasd");
//
//            String  msg=scanner.nextLine();
//
//
//
//
//        try {
//            try (DataOutputStream out = new DataOutputStream(os); Scanner scanner = new
//                    Scanner(System.in)) {
//                for (; ; ) {
//                    System.out.println("输入:");
//                    String msg = scanner.nextLine();
//                    out.write(msg.getBytes());
//                }
//            }
//        } catch (IOException e) {
//
//
//            e.printStackTrace();
//        }
//    }
    }
}