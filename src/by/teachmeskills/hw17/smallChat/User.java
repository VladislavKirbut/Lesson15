package by.teachmeskills.hw17.smallChat;

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

    public boolean equals(User user) {
        return this.nickname.equals(user.nickname);
    }

}
