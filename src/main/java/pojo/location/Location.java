package pojo.location;

import exception.ExceptionBase;
import validator.location.LocationValidator;
import validator.location.LocationValidatorFactory;

public class Location {

    private String address;
    private final String city;
    private final String country;
    private int space;
    private int year;
    private float price;
    private final LocationType locationType;

    private Location(LocationBuilder locationBuilder) {
        this.address = locationBuilder.address;
        this.city = locationBuilder.city;
        this.country = locationBuilder.country;
        this.space = locationBuilder.space;
        this.year = locationBuilder.year;
        this.price = locationBuilder.price;
        this.locationType = locationBuilder.locationType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public static class LocationBuilder {
        private String address;
        private final String city;
        private final String country;
        private int space;
        private int year;
        private float price;
        private final LocationType locationType;

        public LocationBuilder(String city, String country, LocationType locationType) {
            this.city = city;
            this.country = country;
            this.locationType = locationType;
        }

        public LocationBuilder withAddress(String address) {
            this.address = address;
            return this;
        }

        public LocationBuilder withSpace(int space) {
            this.space = space;
            return this;
        }

        public LocationBuilder withYear(int year) {
            this.year = year;
            return this;
        }

        public LocationBuilder withPrice(float price) {
            this.price = price;
            return this;
        }

        public Location build() throws ExceptionBase {
            Location location = new Location(this);
            LocationValidator validator = LocationValidatorFactory.getValidator(location.getLocationType());
            validator.validate(location);
            return location;
        }
    }

    @Override
    public String toString() {
        return "Location{" +
                "address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", space=" + space +
                ", year=" + year +
                ", price=" + price +
                ", locationType=" + locationType +
                '}';
    }
}
