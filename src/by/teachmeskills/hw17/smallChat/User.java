package by.teachmeskills.hw17.smallChat;

public class User {
    private final String nickname;

    public User(String nickname) {
        this.nickname = nickname;
    }

    public String toString() {
        return "@%s".formatted(nickname);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;

        User user = (User) obj;
        return this.nickname.equals(user.nickname);
    }
}
