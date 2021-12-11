package validator.location;

import exception.ExceptionBase;
import exception.InvalidYearException;
import exception.NegativeFieldException;
import pojo.location.Location;
import validator.ValidatorBase;

import java.util.Calendar;

public class LocationValidator extends ValidatorBase<Location> {

    public static final String PRICE = "price";
    public static final String YEAR = "year";
    public static final String SPACE = "space";

    @Override
    public void validate(Location entity) throws ExceptionBase {
        enforcePositive(entity.getPrice(), PRICE);
        enforcePositive(entity.getYear(), YEAR);
        enforcePositive(entity.getSpace(), SPACE);
        enforceValidYear(entity.getYear());
    }

    protected void enforceValidYear(int year) throws InvalidYearException {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (year > currentYear) {
            throw new InvalidYearException("The year {0} is invalid! It must be less than {1}!", 4, year, currentYear);
        }
    }

    protected void enforcePositive(float field, String fieldName) throws NegativeFieldException {
        if (field < 0) {
            throw new NegativeFieldException("The value for the field {0} must be positive!", 3, fieldName);
        }
    }
}
