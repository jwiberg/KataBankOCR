package katabankocr;

public class Account {

	private String accountNumber;

	public Account(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public boolean isValid() {
		return countSum(accountNumberToCharArray()) % 11 == 0;
	}

	private int countSum(char[] numbers) {
		int sum = 0;
		for (int i = 1; i <= 9; i++) {
			sum += charToDigit(numbers[numbers.length - i]) * i;
		}
		return sum;
	}

	private char[] accountNumberToCharArray() {
		return this.accountNumber.toCharArray();
	}	
	
	private int charToDigit(char c) {
		return Character.digit(c, 10);
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}	

}
