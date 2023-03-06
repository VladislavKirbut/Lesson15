package by.teachmeskills.hw17;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class ChatService {
    private final Duration timeInterval;
    private final int countOfMessage;

    private Message[] messageList = new Message[0];

    public ChatService(Duration timeInterval, int countOfMessage) {
        if (!isCountOfMessageCorrect(countOfMessage))
            throw new IllegalArgumentException("Count of message is negative or zero.");

        this.timeInterval = timeInterval;
        this.countOfMessage = countOfMessage;
    }

    private boolean isCountOfMessageCorrect(int countOfMessage) {
        return countOfMessage > 0;
    }

    public Message[] getMessageList() {
        return Arrays.copyOf(messageList, messageList.length);
    }

    public boolean addMessage(User author, String textMessage) {
        if (!isMessageCreate(author))
            return false;

        Message message = new Message(author, textMessage);
        saveMessage(message);
        return true;
    }

    private boolean isMessageCreate(User author) {
        int countOfMessage = 0;

        Instant finish = Instant.now();
        Instant start = finish.minus(timeInterval);

        for (int i = messageList.length - 1; i >= 0; i--) {
            if (messageList[i].getAuthor().equals(author)
                    && messageList[i].getCreatedInstant().isAfter(start)) {
                countOfMessage++;

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
