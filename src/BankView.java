
import java.util.Scanner;

class BankView {

    Scanner sc = new Scanner(System.in);

    int getAccNo() {

        System.out.print(
            "Enter Account Number: ");

        return sc.nextInt();
    }

    String getName() {

        System.out.print(
            "Enter Name: ");

        return sc.next();
    }

    double getBalance() {

        System.out.print(
            "Enter Balance: ");

        return sc.nextDouble();
    }

    int getChoice() {

        System.out.print(
            "Enter Choice: ");

        return sc.nextInt();
    }

    double getAmount(String msg) {

        System.out.print(msg);

        return sc.nextDouble();
    }

    void showMenu() {

        System.out.println(
            "\n1. Display Accounts");
        System.out.println(
            "2. Deposit");
        System.out.println(
            "3. Withdraw");
        System.out.println(
            "4. Exit");
    }
}