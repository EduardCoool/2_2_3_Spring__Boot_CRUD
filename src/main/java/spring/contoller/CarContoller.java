package spring.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.model.Car;
import spring.service.CarServiceImp;

import java.util.List;
import java.util.Optional;


@RestController
public class CarContoller {

    @Autowired
    private CarServiceImp carService;

    @RequestMapping(value = "/cars")
    public List<Car> viewCars(@RequestParam(value = "count", required = false)
                              Optional<Integer> count, Model model
            , @RequestParam(value = "sortBy", required = false) String sortBy) {
        return carService.getCars(count.orElse(carService.getFullCar()), sortBy);
    }
}

