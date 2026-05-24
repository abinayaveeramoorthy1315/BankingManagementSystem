class BankController {

    Account[] accounts;
    int count;

    BankController(int size) {

        accounts = new Account[size];
        count = 0;
    }

    void addAccount(int accNo, String name, double balance) {

        accounts[count++] =
                new Account(accNo, name, balance);
    }

    Account[] getAccounts() {
        return accounts;
    }

    int getCount() {
        return count;
    }

    Account findAccount(int accNo) {

        for (int i = 0; i < count; i++) {

            if (accounts[i].accNo == accNo) {

                return accounts[i];
            }
        }

        return null;
    }

    String deposit(int accNo, double amount) {

        Account a = findAccount(accNo);

        if (a == null)
            return "Account Not Found";

        a.balance += amount;

        return "Amount Deposited Successfully";
    }

    String withdraw(int accNo, double amount) {

        Account a = findAccount(accNo);

        if (a == null)
            return "Account Not Found";

        if (a.balance >= amount) {

            a.balance -= amount;

            return "Withdrawal Successful";
        }

        return "Insufficient Balance";
    }
}