package validator.location;

import exception.ExceptionBase;
import exception.InvalidPriceException;
import exception.InvalidSpaceException;
import pojo.location.Location;

public class ApartmentValidator extends LocationValidator {

    public static final int MIN_PRICE = 50000;
    public static final int MAX_PRICE = 200000;
    public static final int MIN_SPACE = 50;
    public static final int MAX_SPACE = 150;

    @Override
    public void validate(Location location) throws ExceptionBase {
        enforcePositive(location.getPrice(), PRICE);
        enforcePositive(location.getYear(), YEAR);
        enforcePositive(location.getSpace(), SPACE);
        enforceValidYear(location.getYear());
        validatePrice(location.getPrice());
        validateSpace(location.getSpace());
    }

    private void validatePrice(float price) throws InvalidPriceException {
        if (price != 0.0f && (price < MIN_PRICE || price > MAX_PRICE)) {
            throw new InvalidPriceException("The price is invalid! It must be between {0} and {1}!", 5, MIN_PRICE, MAX_PRICE);
        }
    }

    private void validateSpace(int space) throws InvalidSpaceException {
        if (space != 0 && (space < MIN_SPACE || space > MAX_SPACE)) {
            throw new InvalidSpaceException("The space is invalid! It must be between {0} and {1}!", 6, MIN_SPACE, MAX_SPACE);
        }
    }
}
