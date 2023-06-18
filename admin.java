class Account {
    int age;
    int balance;
    String name;
    int account_no;

    public void newacc() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter full name: ");
        name = sc.nextLine();
        System.out.println("Customer age: ");
        age = sc.nextInt();
        System.out.println("Set an account no: ");
        account_no = sc.nextInt();
        System.out.println("Primary balance of customer: ");
        balance = sc.nextInt();
        System.out.println("\tAccount created successfully!");
    }

    public void closeacc() {
        if (balance != 0) {
            System.out.println("\tSorry, your account can't be deleted despite having " + balance + " taka balance.");
        } else {
            System.out.println("\tYour account deleted successfully!");
            age = 0;
            balance = 0;
            name = "";
            account_no = 0;
        }
    }

    public void deposit() {
        Scanner sc = new Scanner(System.in);
        int amount;
        System.out.println("Enter amount to deposit: ");
        amount = sc.nextInt();
        balance = balance + amount;
        System.out.println("\tAvailable balance = " + balance);
    }

    public void withdraw() {
        Scanner sc = new Scanner(System.in);
        int amount;
        System.out.println("Enter amount to withdraw: ");
        amount = sc.nextInt();
        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("\tAvailable balance = " + balance);
        } else {
            System.out.println("\tInsufficient balance!");
        }
    }

    public void checkbalance() {
        System.out.println("\tYour balance is " + balance + " taka");
    }

    public int search(int k) {
        if (k == account_no) {
            return 1;
        } else {
            return 0;
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 100;
        Account b[] = new Account[n];
        int p = 0, acc_num, found;
        String pass;
        System.out.println("Enter admin pass");
        pass = sc.next();
        if (pass.equals("admin")) {
            while (true) {
                int option;
                System.out.println("\n########## Main Menu ########");
                System.out.println("1. Create new account");
                System.out.println("2. Close old account");
                System.out.println("3. Deposit money");
                System.out.println("4. Withdraw money");
                System.out.println("5. Check balance");
                System.out.println("6. Exit\n");
                System.out.print("Enter any between (1-6): ");
                System.out.println("");
                option = sc.nextInt();

                if (option == 6) {
                    break;
                }

                switch (option) {
                    case 1: {
                        if (p < n) {
                            b[p] = new Account();
                            b[p].newacc();
                            p++;
                        } else {
                            System.out.println("Maximum account limit reached!");
                        }
                        break;
                    }
                    case 2:
                        System.out.println("Enter account no");
                        acc_num = sc.nextInt();
                        int flag = 0;
                        for (int i = 0; i < p; i++) {
                            if (b[i] != null) {
                                found = b[i].search(acc_num);
                                if (found != 0) {
                                    b[i].closeacc();
                                    b[i] = null; // Set the element to null to indicate account closure
                                    flag = 1;
                                    break;
                                }
                            }
                        }
                        if (flag == 0) {
                            System.out.println("Invalid account number");
                        }
                        break;

                    case 3:
                        System.out.println("Enter account no");
                        acc_num = sc.nextInt();
                        int depositFlag = 0;
                        for (int i = 0; i < p; i++) {
                            if (b[i] != null) {
                                found = b[i].search(acc_num);
                                if (found != 0) {
                                    b[i].deposit();
                                    depositFlag = 1;
                                    break;
                                }
                            }
                        }
                        if (depositFlag == 0) {
                            System.out.println("Invalid account number");
                        }
                        break;

                    case 4:
                        System.out.println("Enter account no");
                        acc_num = sc.nextInt();
                        int withdrawFlag = 0;
                        for (int i = 0; i < p; i++) {
                            if (b[i] != null) {
                                found = b[i].search(acc_num);
                                if (found != 0) {
                                    b[i].withdraw();
                                    withdrawFlag = 1;
                                    break;
                                }
                            }
                        }
                        if (withdrawFlag == 0) {
                            System.out.println("Invalid account number");
                        }
                        break;

                    case 5:
                        System.out.println("Enter account no");
                        acc_num = sc.nextInt();
                        int balanceFlag = 0;
                        for (int i = 0; i < p; i++) {
                            if (b[i] != null) {
                                found = b[i].search(acc_num);
                                if (found != 0) {
                                    b[i].checkbalance();
                                    balanceFlag = 1;
                                    break;
                                }
                            }
                        }
                        if (balanceFlag == 0) {
                            System.out.println("Invalid account number");
                        }
                        break;
                }
            }
        } else {
            System.out.println("Invalid password");
        }
    }
}
