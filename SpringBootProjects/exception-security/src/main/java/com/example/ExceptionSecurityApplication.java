package com.example;

import com.example.entity.UserEntity;
import com.example.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
//@AllArgsConstructor
public class ExceptionSecurityApplication {

//    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(ExceptionSecurityApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
//    @PostConstruct
//    public void init(){
//        userRepository.saveAll(
//                List.of(
//                        UserEntity.builder().firstName("a").lastName("b").email("a@x.com").build(),
//                        UserEntity.builder().firstName("c").lastName("d").email("c@x.com").build(),
//                        UserEntity.builder().firstName("e").lastName("f").email("e@x.com").build(),
//                        UserEntity.builder().firstName("g").lastName("h").email("g@x.com").build(),
//                        UserEntity.builder().firstName("i").lastName("j").email("i@x.com").build()
//                )
//        );
//        IO.println("----------Saved----------");
//    }

}
