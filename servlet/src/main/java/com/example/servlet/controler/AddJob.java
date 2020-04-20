package com.example.servlet.controler;

import com.example.servlet.entity.JobMessage;
import com.example.servlet.entity.JobReturn;
import com.example.servlet.entity.RespVo;
import com.example.servlet.repository.JobRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;

@RestController
public class AddJob {


    @RequestMapping("add/job")
    public JobReturn login(@RequestBody JobMessage jobMessage) {
        JobReturn respVo = new JobReturn();
        respVo.setErrmsg("成功");
        respVo.setErrno(200);
        InputStream inputStream = AddJob.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        JobRepository jobRepository = sqlSession.getMapper(JobRepository.class);

            jobRepository.save(jobMessage);
            System.out.println(jobMessage);
            sqlSession.commit();
            sqlSession.close();



       // jobRepository.save(jobMessage);
      //  System.out.println(jobMessage);

        return respVo;
    }


}
