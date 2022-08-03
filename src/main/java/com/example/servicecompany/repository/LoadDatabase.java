package com.example.servicecompany.repository;
import com.example.servicecompany.model.User;
import com.example.servicecompany.model.CompanyOwner;
import com.example.servicecompany.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository) {

        return args -> {
            userRepository.save(new Employee("john", 20000));
            userRepository.save(new Employee("mak", 55000));
            userRepository.save(new Employee("ciao", 2222222));
            userRepository.save(new CompanyOwner("bancasella"));
            userRepository.save(new CompanyOwner("ferrari"));

            userRepository.findAll().forEach(user -> log.info("Preloaded" + user));


            };

        };
    }
