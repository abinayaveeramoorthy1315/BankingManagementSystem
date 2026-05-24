import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of accounts: ");

        int n = sc.nextInt();

        BankController controller =
                new BankController(n);

        BankView view = new BankView();

        // User Input

        for (int i = 0; i < n; i++) {

            System.out.println(
                    "\nEnter Account Details");

            int accNo = view.getAccNo();

            String name = view.getName();

            double balance =
                    view.getBalance();

            controller.addAccount(
                    accNo, name, balance);
        }

        while (true) {

            view.showMenu();

            int choice = view.getChoice();

            switch (choice) {

                case 1:

                    view.displayAccounts(
                            controller.getAccounts(),
                            controller.getCount());

                    break;

                case 2:

                    int searchAcc =
                            view.getAccNo();

                    if (controller.findAccount(
                            searchAcc) != null)

                        view.showMessage(
                                "Account Found");

                    else

                        view.showMessage(
                                "Account Not Found");

                    break;

                case 3:

                    int depAcc =
                            view.getAccNo();

                    double depAmt =
                            view.getAmount(
                            "Enter Deposit Amount: ");

                    view.showMessage(
                            controller.deposit(
                                    depAcc, depAmt));

                    break;

                case 4:

                    int withAcc =
                            view.getAccNo();

                    double withAmt =
                            view.getAmount(
                            "Enter Withdraw Amount: ");

                    view.showMessage(
                            controller.withdraw(
                                    withAcc, withAmt));

                    break;

                case 5:

                    System.out.println(
                            "Exiting...");

                    return;

                default:

                    System.out.println(
                            "Invalid Choice");
            }
        }
    }
}