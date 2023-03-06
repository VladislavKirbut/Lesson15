package by.teachmeskills.hw17.smallChat;

import java.time.Instant;

public class Message {

    private final User author;
    private final String textMessage;
    private final Instant createdInstant;

    public Message(User author, String textMessage) {
        this.author = author;
        this.textMessage = textMessage;
        this.createdInstant = Instant.now();
    }

    public Instant getCreatedInstant() {
        return createdInstant;
    }

    public User getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "%-4s - %s\n%s".formatted(author, createdInstant, textMessage);
    }
}
