package pojo;

import java.util.Objects;

public class SimpleUser {

    private String firstName;
    private String lastName;
    private String cnp;
    private String nickname;

    public String getFirstName() {
        return firstName;
    }

    public SimpleUser setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public SimpleUser setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getCnp() {
        return cnp;
    }

    public SimpleUser setCnp(String cnp) {
        this.cnp = cnp;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public SimpleUser setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    @Override
    public String toString() {
        return "SimpleUser{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cnp='" + cnp + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleUser that = (SimpleUser) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(cnp, that.cnp) && Objects.equals(nickname, that.nickname);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(firstName, lastName, cnp, nickname);
//    }
}
