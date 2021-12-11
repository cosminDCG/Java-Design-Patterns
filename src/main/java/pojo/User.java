package pojo;

import exception.ExceptionBase;
import pojo.car.Car;
import pojo.location.Location;
import validator.UserValidator;

import java.util.Date;

public class User {

    private final String firstName;
    private final String lastName;
    private final String cnp;
    private final Date dateOfBirth;
    private String nickName;
    private Car car;
    private Location location;

    private User(UserBuilder userBuilder) {
        this.firstName = userBuilder.firstName;
        this.lastName = userBuilder.lastName;
        this.cnp = userBuilder.cnp;
        this.dateOfBirth = userBuilder.dateOfBirth;
        this.nickName = userBuilder.nickName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCnp() {
        return cnp;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getNickName() {
        return nickName;
    }

    public Car getCar() {
        return car;
    }

    public Location getLocation() {
        return location;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public static class UserBuilder {
        private final String firstName;
        private final String lastName;
        private final String cnp;
        private final Date dateOfBirth;
        private String nickName;
        private Car car;
        private Location location;

        public UserBuilder(String firstName, String lastName, String cnp, Date dateOfBirth) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.cnp = cnp;
            this.dateOfBirth = dateOfBirth;
        }

        public UserBuilder withNickName(String nickName) {
            this.nickName = nickName;
            return this;
        }

        public UserBuilder withCar(Car car) {
            this.car = car;
            return this;
        }

        public UserBuilder withLocation(Location location) {
            this.location = location;
            return this;
        }

        public User build() throws ExceptionBase {
            User user = new User(this);
            UserValidator validator = new UserValidator();
            validator.validate(user);
            return user;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cnp='" + cnp + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
