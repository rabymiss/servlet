package com.example.servlet.repository;

import com.example.servlet.entity.MessageAll;

import java.util.List;

public interface JobMessageAll {

    //  public int save(JobMessageAll jobMessageAll);
    public List<MessageAll> findAll();

    public int sava(MessageAll messageAll);

}
