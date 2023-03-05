package by.teachmeskills.hw17;
import java.time.Instant;

public class MessageInfo {

    private final User author;
    private final String textMessage;
    private final Instant createdInstant;

    public MessageInfo(User author, String textMessage, Instant createdInstant) {
        this.author = author;
        this.textMessage = textMessage;
        this.createdInstant = createdInstant;
    }
}
