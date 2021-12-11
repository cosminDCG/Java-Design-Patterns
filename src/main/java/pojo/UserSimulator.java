package pojo;

import exception.ExceptionBase;

import java.time.Instant;
import java.util.Date;

public class UserSimulator {
    //private final SimpleUser user = new SimpleUser();
    private volatile User user;

    public UserSimulator() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //user.setFirstName("f1").setLastName("l1").setCnp("c1").setNickname("n1");
                try {
                    user = new User.UserBuilder("f1", "l1", "c1", Date.from(Instant.now())).withNickName("n1").build();
                } catch (ExceptionBase exceptionBase) {
                    exceptionBase.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //user.setFirstName("f2").setLastName("l2").setCnp("c2").setNickname("n2");
                try {
                    user = new User.UserBuilder("f2", "l2", "c2", Date.from(Instant.now())).withNickName("n2").build();
                } catch (ExceptionBase exceptionBase) {
                    exceptionBase.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }

//    public SimpleUser getSimpleUser() {
//        return user;
//    }

    public User getUser() {
        return user;
    }
}
