package com.example.unidirectional;

import com.example.unidirectional.entity.Role;
import com.example.unidirectional.entity.User;
import com.example.unidirectional.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManyToManyApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ManyToManyApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setFirstName("amitava");
        user.setLastName("chatterjee");
        user.setEmail("cloudsony999@gmail.com");
        user.setPassword("12345");

        Role admin = new Role();
        admin.setName("ROLE_ADMIN");

        Role customer = new Role();
        customer.setName("ROLE_CUSTOMER");

        user.getRoles().add(admin);
        user.getRoles().add(customer);

        userRepository.save(user);
        System.out.println("Roles saved successfully");

        System.out.println("role for a particular user...");

        User user1 = userRepository.findById(1L).get();
        System.out.println(user1.getEmail());
        user1.getRoles().forEach((r) -> {
            System.out.println(r.getName());
        });
    }
}
