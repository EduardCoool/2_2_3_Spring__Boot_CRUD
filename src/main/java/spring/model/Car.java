package spring.model;

public class Car {
    private String model;

    private int series;

    private int price;


    public Car() {
    }

    public Car(String model, int series, int price) {
        this.price = price;
        this.model = model;
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "model = " + model + "\n" + "series = " + series;
    }
}
