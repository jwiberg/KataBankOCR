package katabankocr;

public final class Account {
	
	public static final int ACCOUNT_NUMBER_LENGHT = 9;

	private String accountNumber;

	public Account(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public boolean isValid() {
		//CHECKSTYLE:OFF
		if(hasIllegalCharacters()) {
			return false;
		}
		return countSum(accountNumberToCharArray()) % 11 == 0;
		//CHECKSTYLE:ON
	}

	public boolean hasIllegalCharacters() {
		return accountNumber.indexOf("?") > -1;
	}

	private int countSum(char[] numbers) {
		int sum = 0;
		for (int i = 1; i <= ACCOUNT_NUMBER_LENGHT; i++) {
			sum += charToDigit(numbers[numbers.length - i]) * i;
		}
		return sum;
	}

	private char[] accountNumberToCharArray() {
		return this.accountNumber.toCharArray();
	}	
	
	private int charToDigit(char c) {
		//CHECKSTYLE:OFF
		return Character.digit(c, 10);
		//CHECKSTYLE:ON
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}	

}
