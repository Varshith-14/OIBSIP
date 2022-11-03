import java.util.Objects;
import java.util.Scanner;
public class atm_interface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("------------WELCOME------------");
        float balance;
        balance = 50000f;
        int withdraw, deposit;
        int amt_transfer;
        int transaction=0;
        String transaction_history=" ";
        String t;
        String name, password,uname="varshith",pw = "varshith1433";
        System.out.println("Enter your name:");
        name = sc.nextLine();
        System.out.println("Enter your ATM password: ");
        password = sc.nextLine();
        if(Objects.equals(name,uname) && Objects.equals(password,pw)){

            do {
                System.out.println("\nChoose an option to proceed");
                System.out.println("1.Withdraw");
                System.out.println("2.Deposit");
                System.out.println("3.Transfer");
                System.out.println("4.Check balance");
                System.out.println("5.Transaction history");
                System.out.println("6.Exit");

                int n = sc.nextInt();
                switch (n) {
                    case 1:
                        System.out.println("\nEnter amount to be withdrawn: ");
                        withdraw = sc.nextInt();
                        if (balance >= withdraw) {
                            transaction++;
                            balance -= withdraw;
                            System.out.println("The amount has been withdrawn");
                            System.out.println("Withdrawn amount: "+withdraw);
                            t="\nAn amount of "+withdraw+" withdrawn";
                            transaction_history=transaction_history.concat(t);
                        } else {
                            System.out.println("\nThe amount cannot be withdrawn");
                            System.out.println("Insufficient balance");
                        }
                        break;
                    case 2:
                        System.out.println("\nEnter amount to be deposited: ");
                        deposit = sc.nextInt();
                        balance += deposit;
                        System.out.println("The amount has been deposited successfully");
                        System.out.println("Deposited amount: "+deposit);
                        transaction++;
                        t="\nAn amount of "+deposit+" has been deposited";
                        transaction_history=transaction_history.concat(t);
                        break;
                    case 3:
                        System.out.println("Enter the account number of the recipient: ");
                        int acc_num= sc.nextInt();
                        System.out.println("\nEnter the amount to be transferred: ");
                        amt_transfer = sc.nextInt();
                        if (balance >= amt_transfer) {
                            transaction++;
                            balance = balance - amt_transfer;
                            System.out.println("The amount has been transferred");
                            System.out.println("Transferred amount: "+amt_transfer);
                            t="\nAn amount of "+amt_transfer+" has been transferred to "+acc_num;
                            transaction_history=transaction_history.concat(t);

                        } else {
                            System.out.println("\nThe amount cannot be transferred");
                            System.out.println("Insufficient balance");
                        }
                        break;
                    case 4:
                        System.out.println("\nThe available balance: " + balance);
                        break;
                    case 5:
                        System.out.println("\nNumber of transactions: "+transaction);
                        System.out.println(transaction_history);
                        break;
                    case 6:
                        System.exit(0);
                    default:
                        throw new IllegalStateException("Unexpected value: " + n);
                }
            } while (true);
        }
        else{
            System.out.println("Invalid username or password");
        }
    }
}