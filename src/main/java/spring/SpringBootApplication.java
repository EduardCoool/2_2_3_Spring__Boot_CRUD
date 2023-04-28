package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.annotation.Bean;
import spring.config.ConfigSort;
import spring.model.Car;
import spring.service.CarService;
import spring.service.CarServiceImp;

@EnableConfigurationProperties(ConfigSort.class)
@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class, args);
    }
    @Bean
    public CommandLineRunner demo(CarServiceImp repository) {
        return (args) -> {
            repository.addCar(new Car("Жигуль", 2107, 777));
            repository.addCar(new Car("Девятка", 2109, 999));
            repository.addCar(new Car("Нива", 2131, 1001));
            repository.addCar(new Car("Калина", 1117, 1002));
            repository.addCar(new Car("Приора", 2170, 1003));
            repository.addCar(new Car("Гранта", 2170, 1004));
            repository.addCar(new Car("Надежда", 2120, 1005));
            repository.addCar(new Car("Пятярка", 2105, 1006));
            repository.addCar(new Car("Копейка", 2101, 9999));
            repository.addCar(new Car("Шестёрка", 2106, 1007));
        };
    }
}
