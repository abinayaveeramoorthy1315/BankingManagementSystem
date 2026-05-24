import java.util.Scanner;

class BankView {

    Scanner sc = new Scanner(System.in);

    void showMenu() {

        System.out.println("\n--- Banking Menu ---");
        System.out.println("1. Display Accounts");
        System.out.println("2. Search Account");
        System.out.println("3. Deposit Money");
        System.out.println("4. Withdraw Money");
        System.out.println("5. Exit");
    }

    int getChoice() {

        System.out.print("Enter choice: ");
        return sc.nextInt();
    }

    int getAccNo() {

        System.out.print("Enter Account Number: ");
        return sc.nextInt();
    }

    String getName() {

        sc.nextLine();

        System.out.print("Enter Account Holder Name: ");
        return sc.nextLine();
    }

    double getBalance() {

        System.out.print("Enter Initial Balance: ");
        return sc.nextDouble();
    }

    double getAmount(String msg) {

        System.out.print(msg);
        return sc.nextDouble();
    }

    void displayAccounts(Account[] accounts, int count) {

        System.out.println("\nAccounts in Bank:");

        for (int i = 0; i < count; i++) {

            System.out.println(
                    accounts[i].accNo + " - " +
                    accounts[i].name + " - Balance: " +
                    accounts[i].balance);
        }
    }

    void showMessage(String msg) {

        System.out.println(msg);
    }
}