package by.teachmeskills.hw17;

public class User {
    private final String userName;

    public User (String userName) {
        if(!isUserNameCorrect(userName))
            throw new IllegalArgumentException("User name is incorrect.");

        this.userName = userName;
    }

    private boolean isUserNameCorrect(String userName) {
        if (userName == null) throw new IllegalArgumentException("Enter correct name.");

        return userName.matches("[A-Za-z]+");
    }
}
