package validator.location;

import pojo.location.LocationType;

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
