package service;

import exception.ExceptionBase;
import pojo.Location;
import validator.location.LocationValidator;
import validator.location.LocationValidatorFactory;

public class LocationService {

  private static LocationService INSTANCE;

  private LocationService(){}

  public static LocationService getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new LocationService();
    }

    return INSTANCE;
  }

  public void addPrice(Location location, float price) throws ExceptionBase {
    location.setPrice(price);
    LocationValidator validator = LocationValidatorFactory.getValidator(location.getLocationType());
    validator.validate(location);
  }

  public void addSpace(Location location, int space) throws ExceptionBase {
    location.setSpace(space);
    LocationValidator validator = LocationValidatorFactory.getValidator(location.getLocationType());
    validator.validate(location);
  }
}
