package by.teachmeskills.hw17.smallChat;

import javax.swing.*;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class ChatService {
    private final Duration timeInterval;
    private final int countOfMessage;

    private Message[] messageList = new Message[0];

    public ChatService(Duration timeInterval, int countOfMessage) {
        if (countOfMessage < 0)
            throw new IllegalArgumentException("Count of message is negative or zero.");

        if (timeInterval.isNegative() || timeInterval.isZero())
            throw new IllegalArgumentException("Time interval is negative or zero.");

        this.timeInterval = timeInterval;
        this.countOfMessage = countOfMessage;
    }

    public Message[] getMessageList() {
        return Arrays.copyOf(messageList, messageList.length);
    }

    public boolean addMessage(User author, String textMessage) {
        Instant createdInstant = Instant.now();
        if (!isMessageCreate(author, createdInstant))
            return false;

        Message message = new Message(author, textMessage, createdInstant);
        saveMessage(message);
        return true;
    }

    private boolean isMessageCreate(User author, Instant createdInstant) {
        int countOfMessage = 0;

        Instant start = createdInstant.minus(timeInterval);

        for (int i = messageList.length - 1; i >= 0; i--) {
            if (messageList[i].getAuthor().equals(author)
                    && messageList[i].getCreatedInstant().isAfter(start)) {
                countOfMessage++;

                if (messageList[i].getCreatedInstant().isBefore(start))
                    return true;

                if (countOfMessage == this.countOfMessage) return false;
            }
        }

        return true;
    }

    private void saveMessage(Message message) {
        messageList = Arrays.copyOf(messageList, messageList.length + 1);
        messageList[messageList.length - 1] = message;
    }
}
