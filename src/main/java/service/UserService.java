package service;

import exception.ExceptionBase;
import pojo.car.Car;
import pojo.location.Location;
import pojo.User;
import validator.UserValidator;
import validator.location.LocationValidator;
import validator.location.LocationValidatorFactory;

public final class UserService {

    private static UserService INSTANCE;

    private UserService() {}

    public static UserService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserService();
        }
        return INSTANCE;
    }

    public void addNickName(User user, String nickname) throws ExceptionBase {
        user.setNickName(nickname);
        UserValidator validator = new UserValidator();
        validator.validate(user);
    }

    public void addLocation(User user, Location location) throws ExceptionBase {
        LocationValidator validator = LocationValidatorFactory.getValidator(location.getLocationType());
        validator.validate(location);
        user.setLocation(location);
    }

    public void addCar(User user, Car car) {

    }
}
