package catch_try;

import java.util.Scanner;

class InsuffientBalanceException extends Exception {
	public InsuffientBalanceException(String message) {
		super(message);
	}
}



public class Bankapp {
	private double balance;
	private String accountholder;
	
	
	public Bankapp(double balance , String accountholder) {
		this.accountholder = accountholder;
		this.balance = balance;
	}
	
	public void deposit(double amount) {
		if(amount<=0) {
			System.out.println("enter the valid amomunt !!");
			return;
		}
		
		balance += amount;
		System.out.println("the deposited amounts iis : " + amount + "the balance is : " + balance);
	}
	
	public void withdraw(double amount) throws InsuffientBalanceException{
		if(amount <=0) {
			throw new InsuffientBalanceException("invalid withdrawal amount !!");
		}
		if(amount>balance) {
			throw new InsuffientBalanceException("insufficent funds!!");
			
		}
		balance -= amount;
		System.out.println("the withdraw amounts iis sucessfull : " + balance);

	}
	
	public  void checkbalance() {
		System.out.println("the balance for the user : " + accountholder + "is :" + balance);
	}
	
	public static void main(String[]args) {
		Scanner sc = new  Scanner(System.in);
		Bankapp account = new Bankapp(5000,"jash");
		
		try {
			boolean exit = false;
			while(!exit) {
				System.out.println("---banking system---");
				System.out.println("1 . Deposit");
				System.out.println("2 . withdraw");
				System.out.println("3 . Check balance");
				System.out.println("4 . exit");
				
				System.out.println("choose an option");
				
				
				
				int choice = sc.nextInt();
				
				
				switch(choice) {
				case 1 : 
					System.out.println("enter the deposit amount!!");
					double depositamount = sc.nextDouble();
					account.deposit(depositamount);
					break;
				case 2 :
					System.out.println("enter hte withdraw amount !!");
					double withdrawamount = sc.nextDouble();
					try {
						account.withdraw(withdrawamount);
					}catch (InsuffientBalanceException e) {
						System.out.println("transaction failed : " + e.getMessage());
					}
					break;
				case 3:
					account.checkbalance();
					break;
				case 4:
					exit = true;
					break;
					default : 
						System.out.println("enter an valid choice!!");
				}
				
			}
		}catch(Exception e) {
			System.out.println("unexpected error !!" + e.getMessage());
		}finally {
			System.out.println("thank you for banking with us!!");
			sc.close();
			
		}
		
	}
	
}
