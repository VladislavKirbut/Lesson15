package by.teachmeskills.hw17.smallChat;
import java.time.Instant;

public class CountOfMessagesExceededException extends Exception {
    /**
     * limitedTime - time after which you can send messages
     */
    private final Instant limitedTime;

    public CountOfMessagesExceededException(Instant limitedTime) {
        this.limitedTime = limitedTime;
    }

    public Instant getLimitedTime() {
        return limitedTime;
    }
}


