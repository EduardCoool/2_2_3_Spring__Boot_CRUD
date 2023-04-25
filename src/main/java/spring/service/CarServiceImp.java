package spring.service;


import org.springframework.stereotype.Service;
import spring.dao.CarDao;
import spring.model.Car;


import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private CarDao carDao;


    @Override
    public List<Car> getCars(int count) {
        return carDao.getCars(int count);
    }
}
