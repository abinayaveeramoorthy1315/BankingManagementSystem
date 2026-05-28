
public class Main {

    public static void main(String[] args) {

        DBConnection.getConnection();

        BankController controller =
            new BankController();

        BankView view =
            new BankView();

        int accNo =
            view.getAccNo();

        String name =
            view.getName();

        double balance =
            view.getBalance();

        controller.addAccount(
            accNo,
            name,
            balance);

        while(true) {

            view.showMenu();

            int choice =
                view.getChoice();

            switch(choice) {

                case 1:

                    controller.displayAccounts();

                    break;

                case 2:

                    controller.deposit(
                        view.getAccNo(),
                        view.getAmount(
                        "Enter Deposit Amount: "));

                    break;

                case 3:

                    controller.withdraw(
                        view.getAccNo(),
                        view.getAmount(
                        "Enter Withdraw Amount: "));

                    break;

                case 4:

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