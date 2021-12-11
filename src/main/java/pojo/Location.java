package pojo;

import exception.ExceptionBase;
import validator.location.LocationValidator;
import validator.location.LocationValidatorFactory;

public class Location {

  private String address;
  private String city;
  private String country;
  private LocationType locationType;
  private int space;
  private int year;
  private float price;

  private Location(LocationBuilder locationBuilder) {
    this.address = locationBuilder.address;
    this.city = locationBuilder.city;
    this.country = locationBuilder.country;
    this.locationType = locationBuilder.locationType;
    this.space = locationBuilder.space;
    this.year = locationBuilder.year;
    this.price = locationBuilder.price;
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

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public LocationType getLocationType() {
    return locationType;
  }

  public void setLocationType(LocationType locationType) {
    this.locationType = locationType;
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

  public static class LocationBuilder {
    private String address;
    private String city;
    private String country;
    private LocationType locationType;
    private int space;
    private int year;
    private float price;

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
        ", locationType=" + locationType +
        ", space=" + space +
        ", year=" + year +
        ", price=" + price +
        '}';
  }
}
