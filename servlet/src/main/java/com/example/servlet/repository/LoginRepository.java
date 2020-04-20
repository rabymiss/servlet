package com.example.servlet.repository;

import com.example.servlet.entity.JobMessage;
import com.example.servlet.entity.JobReturn;

import java.util.List;

public interface LoginRepository {

    public List<JobMessage> findAll();

}
