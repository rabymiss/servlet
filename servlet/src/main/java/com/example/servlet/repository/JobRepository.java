package com.example.servlet.repository;

import com.example.servlet.entity.JobMessage;

public interface JobRepository {

    public int save(JobMessage jobMessage);
}
