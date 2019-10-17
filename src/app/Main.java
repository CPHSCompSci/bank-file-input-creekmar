package app;
import java.io.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException 
	{
		//variables
		Scanner scan = new Scanner(System.in);
		Bank ewbank = new Bank("EwBank");
		int number, menu;
		
		//menu stuff
		System.out.println("Welcome to EwBank!!!");
		do
		{
			System.out.println("Please select an option.");
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Transaction");
			System.out.println("4. Save to File");
			System.out.println("5. Read File");
			System.out.println("6. Create Account");
			System.out.println("7. Delete Account");
			System.out.println("8. Quit");
			menu = scan.nextInt();
			scan.nextLine();
		
			switch (menu)
			{
			//Deposit
			case 1:
				System.out.println("What is your account number?");
				number = scan.nextInt();
				System.out.println("How much money are you depositing?");
				ewbank.deposit(number, scan.nextInt());
				scan.nextLine();
				break;
			
			//Withdraw
			case 2:
				System.out.println("What is your account number?");
				number = scan.nextInt();
				System.out.println("How much money are you withdrawing?");
				ewbank.withdraw(number, scan.nextInt());
				scan.nextLine();
				break;
			
			//Transaction
			case 3:
				System.out.println("What is your account number?");
				int num1 = scan.nextInt();
				System.out.println("How much money are you transacting?");
				int amount = scan.nextInt();
				System.out.println("What account is the transaction going to?");
				int num2 = scan.nextInt();
				ewbank.withdraw(num1, amount);
				ewbank.deposit(num2, amount);
				scan.nextLine();
				break;
			
			//Save to file
			case 4:
				ewbank.saveAccounts("list.txt");
				break;
			//Read file
			case 5:
				ewbank.loadAccounts("list.txt");
				break;
			
			//Create account
			case 6:
				System.out.println("What is your name?");
				number = ewbank.createAccount(scan.nextLine());
				System.out.println("Your account number is " + number);
				break;
			
			//Delete account
			case 7:
				System.out.println("What is your account number?");
				ewbank.closeAccount(scan.nextInt());
				scan.nextLine();
				break;
			
			//wrong number pressed
			case 8:
				System.out.println("Thank you for doing business today!");
				break;
			default:
				System.out.println("You have pressed a number that does not exist in the directory.");
				break;
			}
		
		}while(menu!=8); //end of do while
	}
	
	public static void example1()
	{
		Bank bank = new Bank("Bank of CPHS");
		int ewbankAccountNo = bank.createAccount("Mr. Ewbank");
		int howardAccountNo = bank.createAccount("Mr. Howard");
		
		bank.deposit(ewbankAccountNo, 25);
		bank.deposit(howardAccountNo, 75);

		bank.checkBalance(ewbankAccountNo);
		bank.checkBalance(howardAccountNo);
		
		bank.withdraw(ewbankAccountNo, 10);
		bank.closeAccount(howardAccountNo);
		
		bank.checkBalance(ewbankAccountNo);
		bank.checkBalance(howardAccountNo);
		
	}
}
