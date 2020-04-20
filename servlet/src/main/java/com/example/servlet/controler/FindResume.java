package com.example.servlet.controler;

import com.example.servlet.entity.JobMessage;
import com.example.servlet.entity.JobReturn;
import com.example.servlet.entity.MessageAll;
import com.example.servlet.entity.ResumeEntity;
import com.example.servlet.repository.JobMessageAll;
import com.example.servlet.repository.JobRepository;
import com.example.servlet.repository.ResumeRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.List;

@RestController
public class FindResume {
    @RequestMapping("find/all/mesume")
    public JobReturn info() {
        JobReturn jobReturn = new JobReturn();
        jobReturn.setErrmsg("成功");
        jobReturn.setErrno(200);
        InputStream inputStream = FindResume.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ResumeRepository resumeRepository =sqlSession.getMapper(ResumeRepository.class);
        List<ResumeEntity> list = resumeRepository.findAll();
        System.out.println(list);
        jobReturn.setData(list);
        sqlSession.commit();
        sqlSession.close();
        return jobReturn;
    }


}
