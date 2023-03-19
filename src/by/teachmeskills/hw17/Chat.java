package by.teachmeskills.hw17;

import by.teachmeskills.hw17.smallChat.ChatService;
import by.teachmeskills.hw17.smallChat.CountOfMessagesExceededException;
import by.teachmeskills.hw17.smallChat.Message;
import by.teachmeskills.hw17.smallChat.User;

import java.util.Scanner;
import java.time.Duration;

public class Chat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChatService service = new ChatService(Duration.ofSeconds(30), 2);
        while (true) {
            System.out.println("""
                    Enter a string in the format:
                    1. "Story"
                    2. "[Nickname of user]: [text of message]"
                    0. "Exit"
                    """);
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("Story")) {
                Message[] messageList = service.getMessageList();
                printAll(messageList);
            } else if (input.matches("\\w+(\\s)*:(\\s)*.+")) {
                String[] partsOfMessage = input.trim().split("\\s*:\\s*", 2);
                try {
                    service.addMessage(new User(partsOfMessage[0]), partsOfMessage[1]);
                    System.out.println("The message created successfully");
                } catch (CountOfMessagesExceededException exception) {
                    System.out.println("Too frequent requests. Try again through " + exception.getLimitedTime().getSeconds() + "s");
                }
            } else if (input.equalsIgnoreCase("Exit")) System.exit(0);
              else System.out.println("Enter a correct command.");
        }
    }

    public static void printAll(Message[] messageList) {
        for (int i = 0; i < messageList.length; i++) {
            System.out.println(messageList[i].toString());
        }
    }
}
