package pojo;

import exception.ExceptionBase;
import java.util.Date;
import validator.UserValidator;

public class User {

  private final String firstName;
  private final String lastName;
  private final String cnp;
  private final Date dateOfBirth;
  private String nickName;
  private Car car;
  private Location location;

  private User (UserBuilder userBuilder) {
    this.firstName = userBuilder.firstName;
    this.lastName = userBuilder.lastName;
    this.cnp = userBuilder.cnp;
    this.dateOfBirth = userBuilder.dateOfBirth;
    this.nickName = userBuilder.nickName;
    this.car = userBuilder.car;
    this.location = userBuilder.location;
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

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public Car getCar() {
    return car;
  }

  public void setCar(Car car) {
    this.car = car;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  @Override
  public String toString() {
    return "User{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", cnp='" + cnp + '\'' +
        ", dateOfBirth=" + dateOfBirth +
        ", nickName='" + nickName + '\'' +
        ", car=" + car +
        ", location=" + location +
        '}';
  }

  public static class UserBuilder {
    private final String firstName;
    private final String lastName;
    private final String cnp;
    private final Date dateOfBirth;
    private String nickName;
    private Car car;
    private Location location;

    public UserBuilder(String firstName, String lastName, String cnp, Date date) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.cnp = cnp;
      this.dateOfBirth = date;
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
}
