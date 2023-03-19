package by.teachmeskills.hw17.smallChat;
import java.time.Duration;

public class CountOfMessagesExceededException extends Exception {
    /**
     * limitedTime - time after which you can send messages
     */
    private final Duration limitedTime;

    public CountOfMessagesExceededException(Duration limitedTime) {
        this.limitedTime = limitedTime;
    }

    public Duration getLimitedTime() {
        return limitedTime;
    }
}


