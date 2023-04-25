package spring.comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


public class Comparator {
//    @Value("${sort.model}")
    private String model;



    public Comparator getComparator(){
        Comparator comparator = new Comparator();
        System.out.println(model);


        return comparator ;
    }
}
