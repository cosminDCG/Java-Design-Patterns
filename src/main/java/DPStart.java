import exception.ExceptionBase;
import java.io.FileReader;
import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import pojo.Car;
import pojo.ImmutableExample;
import pojo.Location;
import pojo.LocationType;
import pojo.User;
import service.LocationService;
import service.UserService;

public class DPStart {

  public static void updateNickName(User user, String nickName) throws ExceptionBase {
    UserService userService = UserService.getInstance();
    userService.addNickName(user, nickName);
    System.out.println(userService);
  }

  public static void updateLocation(User user, Location location) throws ExceptionBase {
    UserService userService = UserService.getInstance();
    userService.addLocation(user, location);
    System.out.println(userService);
  }

  public static void updateSpace(Location location, int space) throws ExceptionBase {
    LocationService locationService = LocationService.getInstance();
    locationService.addSpace(location, space);
    System.out.println(locationService);
  }

  public static void updatePrice(Location location, float price) throws ExceptionBase {
    LocationService locationService = LocationService.getInstance();
    locationService.addPrice(location, price);
    System.out.println(locationService);
  }

  public static void main(String[] args) throws ExceptionBase {

    Car car = new Car();
    Location location = new Location.LocationBuilder("Bucuresti", "Romania", LocationType.APARTMENT).build();
    User user = new User.UserBuilder("Alex", "Pop", "0123456789123", Date.from(Instant.now()))
                        .withNickName("Nickname")
                        .withCar(new Car())
                        .build();

    Location location1 = new Location.LocationBuilder("Bucuresti", "Romania", LocationType.DUPLEX)
                                    .withSpace(170)
                                    .withYear(2010)
                                    .withPrice(150000)
                                    .build();

    updateNickName(user, "new-nickname");
    updateLocation(user, location);

    updatePrice(location1, 175000);
    updateSpace(location1, 155);
    System.out.println(user);

    List<String> courses = new ArrayList<>();
    courses.add("course1");
    courses.add("course2");
    courses.add("course3");
    ImmutableExample instance = new ImmutableExample("name", "type", courses);
    instance.getCourses().add("course4");
    System.out.println(instance);

  }
}
