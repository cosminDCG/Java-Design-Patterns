import exception.BadCnpException;
import exception.ExceptionBase;
import exception.MinLengthException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pojo.SimpleUser;
import pojo.User;

import java.time.Instant;
import java.util.Date;

public class UserTest {

    public static final String FIRST_NAME = "first";
    public static final String LAST_NAME = "last";
    public static final String CNP = "1234567891234";
    public static final Date DATE_OF_BIRTH = Date.from(Instant.parse("2021-12-10T01:00:00.00Z"));
    public static final String NICKNAME = "nickname";

    @Test
    void createUser_success() throws ExceptionBase {
        User user = new User.UserBuilder(FIRST_NAME, LAST_NAME, CNP, DATE_OF_BIRTH)
                            .withNickName(NICKNAME)
                            .build();

        Assertions.assertEquals("first", user.getFirstName());
        Assertions.assertEquals("last", user.getLastName());
        Assertions.assertEquals("1234567891234", user.getCnp());
        Assertions.assertEquals(Date.from(Instant.parse("2021-12-10T01:00:00.00Z")), user.getDateOfBirth());
        Assertions.assertEquals("nickname", user.getNickName());
    }

    @Test
    void createUser_badFirstName_failure() {
        Exception exception = Assertions.assertThrows(MinLengthException.class, () ->
                                new User.UserBuilder("a", LAST_NAME, CNP, DATE_OF_BIRTH)
                                        .withNickName(NICKNAME)
                                        .build());
        Assertions.assertEquals("The value a for the field firstName is too short! It should be minimum 3!", exception.getMessage());
    }

    @Test
    void createUser_badLastName_failure() {
        Exception exception = Assertions.assertThrows(MinLengthException.class, () ->
                new User.UserBuilder(FIRST_NAME, "a", CNP, DATE_OF_BIRTH)
                        .withNickName(NICKNAME)
                        .build());
        Assertions.assertEquals("The value a for the field lastName is too short! It should be minimum 3!", exception.getMessage());
    }

    @Test
    void createUser_badCnp_failure() {
        Exception exception = Assertions.assertThrows(BadCnpException.class, () ->
                new User.UserBuilder(FIRST_NAME, LAST_NAME, "a", DATE_OF_BIRTH)
                        .withNickName(NICKNAME)
                        .build());
        Assertions.assertEquals("The cnp a is wrong! The length must be 13!", exception.getMessage());
    }

    @Test
    void createUser_badNickName_failure() {
        Exception exception = Assertions.assertThrows(MinLengthException.class, () ->
                new User.UserBuilder(FIRST_NAME, LAST_NAME, CNP, DATE_OF_BIRTH)
                        .withNickName("a")
                        .build());
        Assertions.assertEquals("The value a for the field nickName is too short! It should be minimum 3!", exception.getMessage());
    }

    @Test
    void test() {
        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);

        //Assertions.assertTrue(i1 == i2);

        SimpleUser simpleUser = new SimpleUser();
        SimpleUser simpleUser1 = new SimpleUser();
         simpleUser.setFirstName("aa");
         simpleUser1.setFirstName("aa");
         simpleUser.setLastName("bb");
         simpleUser1.setLastName("bb");
         simpleUser.setCnp("123");
         simpleUser1.setCnp("123");

         Assertions.assertTrue(simpleUser.equals(simpleUser1));
    }
}
