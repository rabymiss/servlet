package com.example.servlet.entity;

import lombok.Data;

@Data
public class JobReturn<T> {


    private int errno;
    private String errmsg;
    T Data;

}
