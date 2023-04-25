package spring.comparator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import spring.model.Car;

import java.util.Comparator;

@Component
public class ComparatorCar {
    private String sortBy;
    @Value("${sort.model}")
    private String model;
    @Value("${sort.series}")
    private String series;
    @Value("${sort.price}")
    private String price;

    private Comparator<Car> comparator;


    public Comparator<Car> getComparator() {

        if (sortBy != null) {

            if (sortBy.equals("model")) {
                if (model.equals("true")) {
                    comparator = Comparator.comparing(Car::getModel);
                } else {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST
                            , "Sorting by \"model\" field is disabled");
                }
            }
            if (sortBy.equals("series")) {
                if (series.equals("true")) {
                    comparator = Comparator.comparing(Car::getSeries);
                } else {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST
                            , "Sorting by \"series\" field is disabled");
                }
            }
            if (sortBy.equals("price")) {
                if (price.equals("true")) {
                    comparator = Comparator.comparing(Car::getPrice);
                } else {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST
                            , "Sorting by \"price\" field is disabled");
                }
            }
        } else {
            comparator = Comparator.comparing(Car::getModel);
        }
        return comparator;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }
}
