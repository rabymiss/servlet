package com.example.servlet.controler;

import com.example.servlet.entity.User;
import com.example.servlet.entity.RespVo;
import com.example.servlet.repository.UserRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;

@RestController
public class UserRegister {

    @RequestMapping("user/register")
    public RespVo login(@RequestBody User user) {
        RespVo respVo = new RespVo();
        respVo.setErrmsg("成功");
        respVo.setErrno(200);
        InputStream inputStream = UserRegister.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
        userRepository.save(user);
        System.out.println(user);
        sqlSession.commit();
        sqlSession.close();
        return respVo;
    }


}
