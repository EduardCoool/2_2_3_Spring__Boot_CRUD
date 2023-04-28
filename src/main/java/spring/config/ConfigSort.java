package spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;


@ConfigurationProperties(prefix = "sort")
public class ConfigSort {
    private List<String> field;

    public List<String> getField() {
        return field;
    }

    public void setField(List<String> field) {
        this.field = field;
    }
}
