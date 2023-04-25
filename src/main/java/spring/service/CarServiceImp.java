package spring.service;


import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import spring.comparator.ComparatorCar;
import spring.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CarServiceImp implements CarService {

    final ComparatorCar comparator;
    private final int maxCar;
    private final List<Car> cars = new ArrayList<>();

    public CarServiceImp(Environment environment, ComparatorCar comparator) {
        this.maxCar = Integer.parseInt(Objects.requireNonNull(environment.getProperty("maxCar")));
        cars.add(new Car("Жигуль", 2107, 777));
        cars.add(new Car("Девятка", 2109, 999));
        cars.add(new Car("Нива", 2131, 1001));
        cars.add(new Car("Калина", 1117, 1002));
        cars.add(new Car("Приора", 2170, 1003));
        cars.add(new Car("Гранта", 2170, 1004));
        cars.add(new Car("Надежда", 2120, 1005));
        cars.add(new Car("Пятярка", 2105, 1006));
        cars.add(new Car("Копейка", 2101, 9999));
        cars.add(new Car("Шестёрка", 2106, 1007));
        this.comparator = comparator;
    }


    @Override
    public List<Car> getCars(int count) {
        if (count > maxCar) {
            count = cars.size();
        }
        return cars.stream().limit(count).sorted(comparator.getComparator()).collect(Collectors.toList());
    }

    @Override
    public void addCar(Car car) {
        cars.add(car);
    }

    public int getFullCar() {
        return cars.size();
    }
}
