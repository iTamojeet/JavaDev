package com.example.service;

import com.example.entity.Emp;

import java.util.List;

public interface EmpService {
    public List<Emp> getAllByPage();
    public List<Emp> getAll();
}
