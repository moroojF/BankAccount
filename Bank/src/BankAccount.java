  import java.util.*;

public class BankAccount {
	private String accountNum;
	private double checkBalance;
	private double saveBalance;
	static int accountCount;
	static int totalMoney;

	private String createAccount() {
	    Random random = new Random();
        for (int i = 0; i < 10; i++) {
            this.accountNum = String.valueOf(random.nextInt(10));
        }
		return accountNum;
	}

	public BankAccount() {
		this.accountNum = createAccount();
		BankAccount.accountCount++;
	}

	public double getCheckBalance() {
		return checkBalance;
	}

	public double getSaveBalance() {
		return saveBalance;
	}

}
