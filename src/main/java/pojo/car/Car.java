package pojo.car;

public class Car {

    private final String brand;
    private final String model;
    private final CarType carType;
    private int year;
    private int seats;

    public Car(CarBuilder carBuilder) {
        this.brand = carBuilder.brand;
        this.model = carBuilder.model;
        this.carType = carBuilder.carType;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public CarType getCarType() {
        return carType;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public static class CarBuilder {
        private final String brand;
        private final String model;
        private final CarType carType;
        private int year;
        private int seats;

        public CarBuilder(String brand, String model, CarType carType) {
            this.brand = brand;
            this.model = model;
            this.carType = carType;
        }

        public CarBuilder withYear(int year) {
            this.year = year;
            return this;
        }

        public CarBuilder withSeats(int seats) {
            this.seats = seats;
            return this;
        }

        public Car build() {
            Car car = new Car(this);
            return car;
        }
    }
}
