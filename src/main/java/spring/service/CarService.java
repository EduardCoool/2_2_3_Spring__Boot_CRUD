package spring.service;

import spring.model.Car;

import java.util.List;

public interface UserService {
    List<Car> getCars(int count);

}
