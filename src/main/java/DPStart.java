import exception.ExceptionBase;
import pojo.*;
import pojo.location.Location;
import pojo.location.LocationType;
import service.UserService;

import java.time.Instant;
import java.util.Date;

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

    public static void main(String[] args) throws ExceptionBase {
//        for (int i = 0; i < 1; i++) {
//            UserSimulator userSimulator = new UserSimulator();
//            System.out.println(userSimulator.getUser());
//        }

        Location location = new Location.LocationBuilder("city", "country", LocationType.DUPLEX).withPrice(100000).build();
        Location location1 = new Location.LocationBuilder("city", "country", LocationType.APARTMENT).withPrice(120000).build();
        System.out.println(location);

        User user = new User.UserBuilder("first", "last", "1234567891234", Date.from(Instant.now())).build();
        User user1 = new User.UserBuilder("first", "last", "1234567891234", Date.from(Instant.now())).build();

        updateNickName(user, "nick1");
        updateNickName(user1, "nick2");

        updateLocation(user, location);
        updateLocation(user1, location1);

    }
}
