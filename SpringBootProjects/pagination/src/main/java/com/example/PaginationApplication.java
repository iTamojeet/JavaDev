package com.example;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootApplication
public class PaginationApplication implements CommandLineRunner {
    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(PaginationApplication.class, args);
    }

    void pagination(){
        int pageNo = 0;
        int pageSize = 5;

        // create pageable object
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        // findAll method and pass pageable instance
        Page<Employee> page = employeeRepository.findAll(pageable);

        List<Employee> products = page.getContent();

        products.forEach(System.out::println);

        // total pages
        int totalPage = page.getTotalPages();
        // total elements
        long totalElements = page.getTotalElements();
        // number of elements
        int numberOfElements = page.getNumberOfElements();
        // size
        int size = page.getSize();

        // last
        boolean isLast = page.isLast();
        // first
        boolean isFirst = page.isFirst();
        System.out.println("total page -> " + totalPage);
        System.out.println("totalElements -> " + totalElements);
        System.out.println("numberOfElements -> " + numberOfElements);
        System.out.println(" size ->" + size);
        System.out.println(" isLast -> " + isLast);
        System.out.println(" isFirst -> " + isFirst);
    }
    void sorting(){
        String sortBy = "ename";
        String sortDir = "asc";

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?
                Sort.by(sortBy).ascending(): Sort.by(sortBy).descending();

        List<Employee> products = employeeRepository.findAll(sort);

        products.forEach((p) ->{
            System.out.println(p);
        });
    }
    void multipleSorting(){
        String sortBy = "ename";
        String sortDir = "asc";
        String sortBySal = "salary";

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?
                Sort.by(sortBy).ascending(): Sort.by(sortBy).descending();

        Sort sortBySalary = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?
                Sort.by(sortBySal).ascending(): Sort.by(sortBy).descending();

        Sort byGroup = sort.and(sortBySalary);
        List<Employee> l = employeeRepository.findAll(byGroup);
        l.forEach((p) ->{
            System.out.println(p);
        });
    }
    void both(){
        String sortBy = "salary";
        String sortDir = "desc";
        int pageNo = 1;
        int pageSize = 5;

        // Sort object
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?
                Sort.by(sortBy).ascending(): Sort.by(sortBy).descending();

        // Pageable object
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Employee> page = employeeRepository.findAll(pageable);

        List<Employee> products = page.getContent();

        products.forEach((e) ->{
            System.out.println(e);
        });

        // total pages
        int totalPage = page.getTotalPages();
        // total elements
        long totalElements = page.getTotalElements();
        // number of elements
        int numberOfElements = page.getNumberOfElements();
        // size
        int size = page.getSize();

        // last
        boolean isLast = page.isLast();
        // first
        boolean isFirst = page.isFirst();
        System.out.println("total page -> " + totalPage);
        System.out.println("totalElements -> " + totalElements);
        System.out.println("numberOfElements -> " + numberOfElements);
        System.out.println(" size ->" + size);
        System.out.println(" isLast -> " + isLast);
        System.out.println(" isFirst -> " + isFirst);
    }
    @Override
    public void run(String... args) throws Exception {
        //employeeRepository.findAll().forEach(System.out::println);

        //both();

    }
}
