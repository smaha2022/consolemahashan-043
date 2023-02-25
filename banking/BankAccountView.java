package zsgs.bankingapplication.banking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BankAccountView {

    Scanner sc = new Scanner(System.in);
    private BankAccountController bankaccountcontroller;

    public BankAccountView() {
        this.bankaccountcontroller = new BankAccountController(this);
    }

    public static void main(String[] args) {
        BankAccountView bankAccountview = new BankAccountView();
        bankAccountview.displayMainMenu();
    }

    public void displayMainMenu() {
        boolean setup = true;
        do {
            System.out.println(" Welcome to Banking Application  ");
            System.out.println("1. create  account");
            System.out.println("2. View Account Balance");
            System.out.println("3. Deposit Funds");
            System.out.println("4. Withdraw Funds");
            System.out.println("5. View Transaction History");
            System.out.println("6. Exit");
            System.out.println("Enter a number ");
            int number = sc.nextInt();
            switch (number) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    viewAccountBalance();
                    break;
                case 3:
                    depositFunds();
                    break;
                case 4:
                    withdrawFunds();
                    break;
                case 5:
                    transactionHistory();
                    setup = false;
                    break;
                case 6:
                    setup = false;
                    break;
            }
        } while (setup);
    }

    private void transactionHistory() {
		// TODO Auto-generated method stub
		
	}

	private void createAccount() {
        System.out.println("Enter Name");
        String name = sc.next();
        System.out.println("Enter gender");
        String gender = sc.next();
        System.out.println("Enter Address");
        String address = sc.next();
        System.out.println("Enter PhoneNo");
        int phoneNo = sc.nextInt();
        System.out.println("Enter AadharNo");
        long aadharNo = sc.nextLong();
        System.out.println("Enter AccountType ");
        String accountType = sc.next();
        System.out.println("Enter BranchName");
        String branchName = sc.next();
        bankaccountcontroller.newAccount(name, gender, address, phoneNo, aadharNo, accountType, branchName);
    }

    private void viewAccountBalance() {
        System.out.println("Enter AccountNo");
        long accountNo = sc.nextInt();
        bankaccountcontroller.checkBalance(accountNo);
    }

    private void depositFunds() {
        System.out.println("Enter AccountNo");
        long accountNo = sc.nextLong();
        System.out.println("Enter Amount");
        int amount = sc.nextInt();
        System.out.println("Enter BranchName");
        String branchName = sc.next();
        System.out.println("Enter Ifsc code");
        String ifsc = sc.next();
        bankaccountcontroller.checkDeposit(accountNo, amount, branchName, ifsc);
    }

    private void withdrawFunds() {
        System.out.println("Enter AccountNo");
        long accountNo = sc.nextLong();
        System.out.println("Enter Amount");
        int amount = sc.nextInt();
        System.out.println("Enter BranchName");
        String branchName = sc.next();
        System.out.println("Enter date dd-mm-yyyy");
        String dateInput = sc.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date = dateFormat.parse(dateInput);
            bankaccountcontroller.checkWithDrawFund(accountNo, amount, branchName, date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public static void createdSuccessfully() {
        System.out.println("Welcome to zoho bank! ,Account created Succesfully");
    }
}
