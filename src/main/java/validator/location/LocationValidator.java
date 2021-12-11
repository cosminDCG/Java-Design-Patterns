package validator.location;

import exception.ExceptionBase;
import exception.InvalidYearException;
import exception.NegativeFieldException;
import java.util.Calendar;
import pojo.Location;
import validator.ValidatorBase;

public class LocationValidator extends ValidatorBase<Location> {

  @Override
  public void validate(Location object) throws ExceptionBase {
    enforcePositive(object.getPrice(), "price");
    enforcePositive(object.getYear(), "year");
    enforcePositive(object.getSpace(), "space");
    enforceValidYear(object.getYear());
  }

  protected void enforcePositive(float field, String fieldName) throws NegativeFieldException {
    if (field < 0) {
      throw new NegativeFieldException("The value for the field {0} must be positive!", 2, fieldName);
    }
  }

  protected void enforceValidYear(int year) throws InvalidYearException {
    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    if (year > currentYear) {
      throw new InvalidYearException("The year {0} is invalid! It must be less than {1}!", 3, year, currentYear);
    }
  }
}
