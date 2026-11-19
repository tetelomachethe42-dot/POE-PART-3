package poe.part.pkg2;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;

/**
 *
 * @author Student
 */


/**
 * QuickChat: the main application.
 * The user registers, logs in, and can then send messages.
 * Replaces Part2.java as the class that contains main.
 */
public class QuickChat {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Login login = new Login();

        registerUser(scan, login);
        loginUser(scan, login);
         Message message = new Message();

        System.out.println("\nWelcome to QuickChat.");
       
        message.loadStoredMessages();
        message.setMaxMessages(askNumberOfMessages(scan));

        int option = 0;
        while (option != 3) { // application runs until the user selects Quit
            System.out.println("\n===== Menu =====");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.println("4) Stored Messages");
            System.out.print("Choose an option: ");

            option = readNumber(scan);

            switch(option){

    case 1 -> message.sendingMessages();

    case 2 ->System.out.println("Coming Soon.");

    case 3 ->System.out.println( "Goodbye, thank you for using QuickChat.");

    case 4 -> storedMenu(scan, message);

    default ->System.out.println("Invalid option!");
}
            }
        }
    
    /** Keeps asking for details until the registration is accepted. */
    private static void registerUser(Scanner scan, Login login) {
        System.out.println("===== Register =====");
        String result;
        do {
            System.out.print("First name: ");
            String firstName = scan.nextLine().trim();
            System.out.print("Last name: ");
            String lastName = scan.nextLine().trim();
            System.out.print("Username: ");
            String username = scan.nextLine().trim();
            System.out.print("Password: ");
            String password = scan.nextLine();
            System.out.print("Cell number: ");
            String cellNumber = scan.nextLine().trim();

            result = login.registerUser(firstName, lastName, username, password, cellNumber);
            System.out.println(result);
        } while (!result.contains("registered successfully"));
    }

    /** Keeps asking until the login details match. */
    private static void loginUser(Scanner scan, Login login) {
        System.out.println("\n===== Login =====");
        while (!login.returnLoginStatus()) {
            System.out.print("Username: ");
            String username = scan.nextLine().trim();
            System.out.print("Password: ");
            String password = scan.nextLine();

            login.loginUser(username, password);
            System.out.println(login.returnLoginMessage());
        }
    }

    /** The user decides at the start how many messages they will enter. */
    private static int askNumberOfMessages(Scanner scan) {
        int total = 0;
        while (total <= 0) {
            System.out.print("How many messages do you wish to enter? ");
            total = readNumber(scan);
            if (total <= 0) {
                System.out.println("Please enter a whole number greater than 0.");
            }
        }
        return total;
    }

    /** Reads a number; returns 0 if the user typed something that is not a number. */
    private static int readNumber(Scanner scan) {
        try {
            return Integer.parseInt(scan.nextLine().trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
private static void storedMenu(
        Scanner scan,
        Message message){

    int option;

    do{

        System.out.println("\n===== STORED MESSAGES =====");

        System.out.println(
                "1. Display Stored Messages");

        System.out.println(
                "2. Display Longest Message");

        System.out.println(
                "3. Search Message ID");

        System.out.println(
                "4. Search Recipient");

        System.out.println(
                "5. Delete Message");

        System.out.println(
                "6. Display Report");

        System.out.println(
                "7. Back");

        System.out.print("Choose option: ");

        option = Integer.parseInt(
                scan.nextLine());

        switch(option){

            case 1 ->
                    message.displayStoredMessages();

            case 2 ->
                    System.out.println(
                        message.getLongestStoredMessage());

            case 3 -> {

                System.out.print(
                        "Enter Message ID: ");

                String id =
                        scan.nextLine();

                System.out.println(
                        message.searchMessageID(id));
            }

            case 4 -> {

                System.out.print( "Enter Recipient: ");

                String recipient =
                        scan.nextLine();

                System.out.println(
                        message.searchRecipient(
                                recipient));
            }

            
            case 5 -> {

                System.out.print( "Enter Hash: ");

                String hash = scan.nextLine();

                System.out.println(message.deleteMessage(
                                hash));
            }

            case 6 -> message.displayReport();

        }

    }while(option != 7);
}// closes storedMenu
}




