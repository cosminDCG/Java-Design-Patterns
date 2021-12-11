import exception.BadCnpException;
import exception.ExceptionBase;
import java.sql.Date;
import java.time.Instant;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pojo.Car;
import pojo.User;

public class UserTest {

  @BeforeEach
  void before() {
    System.out.println("before");
  }

  @AfterEach
  void after() {
    System.out.println("after");
  }

  @Test
  void createUser_basicCase_success() throws ExceptionBase {
    User user = new User.UserBuilder("Alex", "Pop", "0123456789123", Date.from(Instant.parse("2021-12-10T01:00:00.00Z")))
                        .build();

    Assertions.assertEquals("Alex", user.getFirstName());
    Assertions.assertEquals("Pop", user.getLastName());
    Assertions.assertEquals("0123456789123", user.getCnp());
    Assertions.assertEquals(Date.from(Instant.parse("2021-12-10T01:00:00.00Z")), user.getDateOfBirth());
  }

  @Test
  void createUser_withNickName_success() throws ExceptionBase {
    User user = new User.UserBuilder("Alex", "Pop", "0123456789123", Date.from(Instant.parse("2021-12-10T01:00:00.00Z")))
                        .withNickName("nick")
                        .build();

    Assertions.assertEquals("Alex", user.getFirstName());
    Assertions.assertEquals("Pop", user.getLastName());
    Assertions.assertEquals("0123456789123", user.getCnp());
    Assertions.assertEquals(Date.from(Instant.parse("2021-12-10T01:00:00.00Z")), user.getDateOfBirth());
    Assertions.assertEquals("nick", user.getNickName());
  }

  @Test
  void createUser_badCnp_failure() {
    Exception exception = Assertions.assertThrows(BadCnpException.class, () -> {
      new User.UserBuilder("Alex", "Pop", "123456789123", Date.from(Instant.parse("2021-12-10T01:00:00.00Z")))
          .build();
    });

    Assertions.assertEquals("The cnp 123456789123 is wrong! The length must be 13!", exception.getMessage());
  }

  /*
  Location test scenarios
  s1: test a valid house
  s2: same for duplex
  s3: same for apartment
  s4...: bad cases for every type
   */
}
