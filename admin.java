

import java.util.Scanner;

class Bankacc {

    int age, acc_no;
    double balance;
    String name;
    Scanner scan = new Scanner(System.in);

    public void newAcc() {
        System.out.println("Enter customer full name: ");
        name = scan.nextLine();
        System.out.println("Enter customer age: ");
        age = scan.nextInt();
        System.out.println("Set a unique account number for the customer: ");
        acc_no = scan.nextInt();
        System.out.println("Enter customer primary balance: ");
        balance = scan.nextDouble();
        System.out.println("Account created successfully");
    }

    public int searchAcc(int search) {
        if (acc_no == search) {
            return 1;
        } else {
            return 0;
        }
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Current Balance : " + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Current Balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void closeAccount() {
        if (balance != 0) {
            System.out.println("This account has " + balance + " taka!");
        } else {
            name = "";
            balance = 0;
            age = 0;
            acc_no = 0;
            System.out.println("Account deleted successfully");
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int c = 0;
        Bankacc b[] = new Bankacc[10];
        while (true) {
            try {
                System.out.println("");
                System.out.println("Enter your choice: ");
                System.out.println("1: Open a new account");
                System.out.println("2: Close an existing account");
                System.out.println("3: Deposit Money");
                System.out.println("4: Withdraw Money");
                System.out.println("5: Check Balance");
                System.out.println("6: Search Account");
                System.out.println("7: Exit");

                int choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        b[c] = new Bankacc();
                        b[c].newAcc();
                        c++;
                        break;

                    case 2:
                        System.out.println("Enter account no: ");
                        int search = scan.nextInt();
                        int flag = 0;
                        for (int i = 0; i < c; i++) {
                            flag = b[i].searchAcc(search);
                            if (flag == 1) {
                                b[i].closeAccount();

                                break;
                            }
                        }
                        if (flag == 0) {
                            System.out.println("Invalid Account");
                        }
                        break;
                    case 3:
                        double amount;
                        System.out.println("Enter account no: ");
                        search = scan.nextInt();

                        flag = 0;
                        for (int i = 0; i < c; i++) {
                            flag = b[i].searchAcc(search);
                            if (flag == 1) {
                                System.out.println("Enter amount");
                                amount = scan.nextDouble();
                                b[i].deposit(amount);
                                break;
                            }
                        }
                        if (flag == 0) {
                            System.out.println("Invalid Account");
                        }
                        break;

                    case 4:

                        System.out.println("Enter account no: ");
                        search = scan.nextInt();

                        flag = 0;
                        for (int i = 0; i < c; i++) {
                            flag = b[i].searchAcc(search);
                            if (flag == 1) {
                                System.out.println("Enter amount");
                                amount = scan.nextDouble();
                                b[i].withdraw(amount);
                                break;
                            }
                        }
                        if (flag == 0) {
                            System.out.println("Invalid Account");
                        }
                        break;
                    case 5:
                        System.out.println("Enter account no: ");
                        search = scan.nextInt();
                        flag = 0;
                        for (int i = 0; i < c; i++) {
                            flag = b[i].searchAcc(search);
                            if (flag == 1) {
                                System.out.println("Balance : " + b[i].balance);
                                break;
                            }
                        }
                        if (flag == 0) {
                            System.out.println("Invalid Account");
                        }
                        break;
                    case 6:
                        System.out.println("Enter account no: ");
                        search = scan.nextInt();
                        flag = 0;
                        for (int i = 0; i < c; i++) {
                            if(b[i]!=null){
                                flag = b[i].searchAcc(search);
                            if (flag == 1) {
                                System.out.println("Account found");
                                System.out.println("Name: " + b[i].name);
                                break;
                            }
                            }
                        }
                        if (flag == 0) {
                            System.out.println("Account does not found!");
                        }
                        break;
                    default:
                        System.out.println("Invalid choice: \nTry again please.");
                        break;
                    case 7:
                        return;
                }
            } catch (NullPointerException e) {
                System.out.println("NullPointerException occurred: " + e.getMessage());
            }
        }
    }
}
