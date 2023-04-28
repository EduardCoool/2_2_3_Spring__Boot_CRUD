package spring.service;

import spring.model.Car;

import java.util.List;

public interface CarService {
    List<Car> getCars(int count, String sortBy);

    void addCar(Car car);
}
