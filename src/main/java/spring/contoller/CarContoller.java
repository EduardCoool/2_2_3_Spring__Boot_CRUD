package spring.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.service.CarServiceImp;

import java.util.Optional;


@Controller
public class CarContoller {

    @Autowired
    private CarServiceImp carService;

    @RequestMapping(value = "/cars")
    public String viewCars(@RequestParam(value = "count", required = false)
                           Optional<Integer> count, Model model
            , @RequestParam(value = "sortBy", required = false) String sortBy) {
        model.addAttribute("count", carService.getCars(count.orElse(carService.getFullCar()), sortBy));
        return "cars";
    }
}

