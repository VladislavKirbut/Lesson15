package by.teachmeskills.hw17.smallChat;

import java.util.Objects;

public class User {
    private final String nickname;

    public User(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "@%s".formatted(nickname);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        User user = (User) obj;
        return this.nickname.equals(user.nickname);
    }
    @Override
    public int hashCode() {
        return Objects.hash(nickname);
    }
}
