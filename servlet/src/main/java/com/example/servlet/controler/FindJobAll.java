package com.example.servlet.controler;

import com.example.servlet.entity.*;
import com.example.servlet.repository.JobMessageAll;
import com.example.servlet.repository.LoginRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.List;

@RestController
public class FindJobAll {

    @RequestMapping("find/all/message")
    public JobReturn info() {
        JobReturn jobReturn = new JobReturn();
        jobReturn.setErrmsg("成功");
        jobReturn.setErrno(200);
        InputStream inputStream = FindJobAll.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        JobMessageAll jobMessageAll = sqlSession.getMapper(JobMessageAll.class);
        List<MessageAll> list = jobMessageAll.findAll();

        // List<MessageAll>list=jobMessageAll.findAll();
        // List<JobMessageAll>list=jobMessageAll.findAll();
        System.out.println(list);
        jobReturn.setData(list);
        sqlSession.commit();
        sqlSession.close();
        return jobReturn;
    }

}


