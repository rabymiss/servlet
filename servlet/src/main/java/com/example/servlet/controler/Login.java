package com.example.servlet.controler;

import com.example.servlet.entity.User;
import com.example.servlet.repository.UserRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;

@RestController
public class Login {

    @RequestMapping("user/login")
    public User login(@RequestBody User user) {
        InputStream inputStream = Login.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
        Long count = userRepository.findUser(user.getUsername(), user.getPassword());
        User user2 = new User(count.toString(), count.toString());
        System.out.println(count);
        System.out.println(user);
        return user2;

    }


}





