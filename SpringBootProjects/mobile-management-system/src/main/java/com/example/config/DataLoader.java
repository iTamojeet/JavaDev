package com.example.config;

import com.example.entity.Mobile;
import com.example.repository.MobileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    @Bean
    public CommandLineRunner data(MobileRepository mobileRepository){
        return args -> {
                    mobileRepository.save(Mobile.builder().brand("samsung").model("s24").price(90000.0).stock(1).build());
                    mobileRepository.save(Mobile.builder().brand("lava").model("dhur").price(1000.0).stock(100).build());
                    mobileRepository.save(Mobile.builder().brand("nokia").model("111").price(1500.0).stock(500).build());
        };
    }
}
