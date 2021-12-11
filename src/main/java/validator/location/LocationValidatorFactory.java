package validator.location;

import pojo.LocationType;

public final class LocationValidatorFactory {

  public static LocationValidator getValidator(LocationType locationType) {
    switch (locationType) {
      case HOUSE:
        return new LocationValidator();
      case APARTMENT:
        return new ApartmentValidator();
      case DUPLEX:
        return new DuplexValidator();
      default:
        return null;
    }
  }
}
