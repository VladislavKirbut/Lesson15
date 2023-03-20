package by.teachmeskills.hw17.smallChat;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class ChatService {
    private final Duration timeInterval;
    private final int countOfMessage;

    private final List<Message> messageList = new ArrayList<>();

    public ChatService(Duration timeInterval, int countOfMessage) {
        if (countOfMessage < 0)
            throw new IllegalArgumentException("Count of message is negative or zero.");

        if (timeInterval.isNegative() || timeInterval.isZero())
            throw new IllegalArgumentException("Time interval is negative or zero.");

        this.timeInterval = timeInterval;
        this.countOfMessage = countOfMessage;
    }

    public List<Message> getMessageList() {
        return Collections.unmodifiableList(messageList);
    }

    public void addMessage(User author, String textMessage) throws CountOfMessagesExceededException {
        Instant createdInstant = Instant.now();
        if (isMessageCreate(author, createdInstant)) {
            Message message = new Message(author, textMessage, createdInstant);
            messageList.add(message);
        }
    }

    private boolean isMessageCreate(User author, Instant createdInstant) throws CountOfMessagesExceededException {
        int countOfMessage = 0;
        Message previousMessage;

        Instant start = createdInstant.minus(timeInterval);

        ListIterator<Message> iterator = messageList.listIterator(messageList.size());
        while (iterator.hasPrevious()) {
            previousMessage = iterator.previous();

            if (previousMessage.getAuthor().equals(author) && previousMessage.getCreatedInstant().isAfter(start))
                countOfMessage++;

            if (previousMessage.getCreatedInstant().isBefore(start))
                return true;

            if (countOfMessage == this.countOfMessage)
                throw new CountOfMessagesExceededException(previousMessage.getCreatedInstant().plus(timeInterval));
        }

        return true;
    }
}
