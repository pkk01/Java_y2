class Account {
	public int balance = 1000;
	
	// method that need to be treated as Synchronized method
	
	public synchronized void withdraw (int amount) {
		if (balance >= amount) {

			System.out.println ("Withdrew amount: "+amount);
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			balance = balance - amount;
			System.out.println ("Balance Remaining: "+balance);
		}
		else {
			System.out.println ("Insufficient Balance : "+amount);
		}
	}
}

class SelfHolder extends Thread {
	Account account;
	
	public SelfHolder (Account account) {
		this.account = account;
		
	} 
	
	@Override
	public void run () {
		System.out.println("Self");
		account.withdraw(700);
		
	}
}
class FamilyHolder extends Thread {
	Account account;
	
	public FamilyHolder (Account account) {
		this.account = account;
		
	} 
	
	@Override
	public void run () {
		System.out.println("Parent");
		account.withdraw(300);
		
	}
}
class FriendHolder extends Thread {
	Account account;
	
	public FriendHolder (Account account) {
		this.account = account;
		
	} 
	
	@Override
	public void run () {
		System.out.println("Friend");
		account.withdraw(300);
		
	}
}

public class AccountMain {
	public static void main (String pk[]) {
		Account account = new Account();
		SelfHolder selfHolder = new SelfHolder(account);
		FamilyHolder familyHolder = new FamilyHolder(account);
		FriendHolder friendHolder = new FriendHolder(account);
		
		selfHolder.start();
		familyHolder.start();
		friendHolder.start();
		
		try {
			System.out.println("Self");
			selfHolder.join();
			System.out.println("family");
			familyHolder.join();
			System.out.println("friend");
			friendHolder.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}