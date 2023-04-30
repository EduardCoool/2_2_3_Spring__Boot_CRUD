package spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import spring.model.User;
import spring.service.UserServiceImp;


@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserServiceImp repository) {
        return (args) -> {
            repository.saveUser(new User("Techno Smarter", 20, "info@technomaster.com"));
            repository.saveUser(new User("Rohan", 67, "rohan@example.com"));
            repository.saveUser(new User("Geeta", 19, "geeta@example.com"));
            repository.saveUser(new User("Ram", 34, "ram@gmail.com"));
            repository.saveUser(new User("Mohan", 34, "mohan@gmail.com"));

        };
    }
}
