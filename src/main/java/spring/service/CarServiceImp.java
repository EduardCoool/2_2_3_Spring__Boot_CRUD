package spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import spring.config.ConfigSort;
import spring.dao.CarRepository;
import spring.model.Car;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImp implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ConfigSort configSort;

    @Value("${maxCar}")
    private int maxCar;

    public CarServiceImp() {
    }

    @Override
    public List<Car> getCars(int count, String sortBy) {
        if (count > maxCar) {
            count = getFullCar();
        }
        if (configSort.getField().contains(sortBy)) {
            return carRepository.findAll(Sort.by(sortBy)).stream().limit(count)
                    .collect(Collectors.toList());

        }
        if (sortBy == null) {
            return carRepository.findAll().stream().limit(count)
                    .collect(Collectors.toList());
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Sorting by " + sortBy + " field is disabled");
        }
    }

    @Override
    public void addCar(Car car) {
        carRepository.save(car);
    }


    public int getFullCar() {
        return carRepository.findAll().size();
    }
}
