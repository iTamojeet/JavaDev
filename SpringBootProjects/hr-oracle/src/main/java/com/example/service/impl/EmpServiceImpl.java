package com.example.service.impl;

import com.example.entity.Emp;
import com.example.repository.EmpRepository;
import com.example.service.EmpService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EmpServiceImpl implements EmpService {

    private final EmpRepository empRepository;

    @Override
    public List<Emp> getAllByPage() {
        int pageNo=0;
        int pageSize=15;

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Emp> page = empRepository.findAll(pageable);
        List<Emp> lemp=page.getContent();

        return lemp;
    }

    @Override
    public List<Emp> getAll() {
        return empRepository.findAll();
    }
}
