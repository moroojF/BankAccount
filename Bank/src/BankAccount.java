  import java.util.*;

public class BankAccount {
	private String accountNum;
	private double checkBalance;
	private double saveBalance;
	
	static int accountCount=0;
	static double totalMoney=0;

	private String createAccount() {
	    Random random = new Random();
        for (int i = 0; i < 10; i++) {
            this.accountNum = String.valueOf(random.nextInt(10));
        }
		return accountNum;
	}

	public BankAccount() {
		this.accountNum = createAccount();
		this.checkBalance=0;
		this.saveBalance=0;
		BankAccount.accountCount++;
	}

	public double getCheckBalance() {
		return checkBalance;
	}

	public double getSaveBalance() {
		return saveBalance;
	}
	
	public void depositMoney(double money, String type) {
		if(type.equals("savings")) {
			this.saveBalance += money;
			}
		else if(type.equals("checking")) {
			this.checkBalance += money;
			}
		BankAccount.totalMoney += money;
	}

	public void withdrawMoney(double money, String type) {
		if(type.equals("savings")){
			if(this.saveBalance - money>=0){
				this.saveBalance -= money;
				BankAccount.totalMoney -= money;
			}
		}
		else if(type.equals("checking")){
			if(this.checkBalance-money>=0) {
				this.checkBalance-=money;
				BankAccount.totalMoney-=money;
			}
		}
	}

	public void displayAccountBalance() {
		System.out.println(String.format("Savings: %.2f, Checking: %.2f", this.saveBalance, this.checkBalance));
	}

	public static void main(String[] args) {
		BankAccount a = new BankAccount();
		a.depositMoney(500.18, "checking");
		a.depositMoney(362.9, "savings");
		a.displayAccountBalance();
		System.out.println(String.format("%.3f", BankAccount.totalMoney));
		a.withdrawMoney(73.5, "checking");
		a.withdrawMoney(10.3, "savings");
		a.displayAccountBalance();
		System.out.println(String.format("%.3f", BankAccount.totalMoney));
	}

}
