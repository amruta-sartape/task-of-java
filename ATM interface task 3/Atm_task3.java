import java.util.*;

class Atm_task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Welcome to the ATM =====");

        // Show examples of username and PIN format
        System.out.println("Please enter your credentials to continue.");
        System.out.println("Example Username: User1234");
        System.out.println("Example PIN: 1234 (any 4-digit number)\n");

        // Ask for username and PIN but do NOT validate strictly
        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter 4-digit PIN: ");
        String pin = sc.nextLine();

        // Just print a success message and proceed
        System.out.println("\nLogin Successful! Welcome, " + username + "\n");

        int balance = 0;
        ArrayList<String> history = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("--- ATM Menu ---");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("\n--- Transaction History ---");
                    if (history.isEmpty()) {
                        System.out.println("No transactions yet.");
                    } else {
                        for (String record : history) {
                            System.out.println(record);
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    int withdrawAmount = sc.nextInt();
                    if (withdrawAmount <= 0) {
                        System.out.println("Invalid amount.");
                    } else if (withdrawAmount > balance) {
                        System.out.println("Insufficient balance.");
                    } else {
                        balance -= withdrawAmount;
                        history.add("Withdrawn: Rs. " + withdrawAmount);
                        System.out.println("Withdrawal successful. New balance: Rs. " + balance);
                    }
                    break;

                case 3:
                    System.out.print("Enter deposit amount: ");
                    int depositAmount = sc.nextInt();
                    if (depositAmount <= 0) {
                        System.out.println("Invalid amount.");
                    } else {
                        balance += depositAmount;
                        history.add("Deposited: Rs. " + depositAmount);
                        System.out.println("Deposit successful. New balance: Rs. " + balance);
                    }
                    break;

                case 4:
                    System.out.print("Enter recipient's username: ");
                    String recipient = sc.nextLine();
                    System.out.print("Enter amount to transfer: ");
                    int transferAmount = sc.nextInt();

                    if (transferAmount <= 0) {
                        System.out.println("Invalid amount.");
                    } else if (transferAmount > balance) {
                        System.out.println("Insufficient balance.");
                    } else {
                        balance -= transferAmount;
                        history.add("Transferred: Rs. " + transferAmount + " to " + recipient);
                        System.out.println("Transferred Rs. " + transferAmount + " to " + recipient);
                        System.out.println("New balance: Rs. " + balance);
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please choose between 1 to 5.");
            }
        }

        sc.close();
    }
}
