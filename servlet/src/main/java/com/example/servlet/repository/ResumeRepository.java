package com.example.servlet.repository;

import com.example.servlet.entity.JobMessage;
import com.example.servlet.entity.ResumeEntity;

import java.util.List;

public interface ResumeRepository {


    public List<ResumeEntity> findAll();
}
