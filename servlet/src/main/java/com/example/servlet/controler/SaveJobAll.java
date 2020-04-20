package com.example.servlet.controler;

import com.example.servlet.entity.MessageAll;
import com.example.servlet.entity.RespVo;
import com.example.servlet.repository.JobMessageAll;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;

@RestController
public class SaveJobAll {

    @RequestMapping("add/job/message")
    public RespVo login(@RequestBody MessageAll messageAll) {

        RespVo respVo = new RespVo();
        respVo.setErrmsg("chenggong ");
        respVo.setErrno(200);
        InputStream inputStream = SaveJobAll.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        JobMessageAll jobMessageAll = sqlSession.getMapper(JobMessageAll.class);
        jobMessageAll.sava(messageAll);
        System.out.println(messageAll);
        sqlSession.commit();
        sqlSession.close();
        return respVo;
    }


}
