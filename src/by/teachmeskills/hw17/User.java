package by.teachmeskills.hw17;

public class User {
    private final String nickname;

    public User(String userName) {
        this.nickname = userName;
    }

    public String getNickname() {
        return nickname;
    }

    public String toString() {
        return "@%s".formatted(nickname);
    }

}
