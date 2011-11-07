package katabankocr;

import java.util.ArrayList;
import java.util.List;

public class AccountFileParser {

	private String[] lines;

	private static final String ZERO = " _ " + "| |" + "|_|";
	private static final String ONE = "   " + "  |" + "  |";
	private static final String TWO = " _ " + " _|" + "|_ ";
	private static final String THREE = " _ " + " _|" + " _|";
	private static final String FOUR = "   " + "|_|" + "  |";
	private static final String FIVE = " _ " + "|_ " + " _|";
	private static final String SIX = " _ " + "|_ " + "|_|";
	private static final String SEVEN = " _ " + "  |" + "  |";
	private static final String EIGHT = " _ " + "|_|" + "|_|";
	private static final String NINE = " _ " + "|_|" + " _|";

	public AccountFileParser(String file) {
		this.lines = file.split("\n");
	}

	public List<Account> parse() {
		List<Account> accounts = new ArrayList<Account>();

		for (int i = 0; i < lines.length; i = i + 4) {
			String accountNumber = parseAccountNumber(lines, i);
			accounts.add(new Account(accountNumber));
		}

		return accounts;
	}

	private String parseAccountNumber(String[] lines, int fileLineNmber) {
		String accountNumber = "";
		for (int characterNumber = 1; characterNumber < 10; characterNumber++) {
			String character = getCharacter(fileLineNmber, characterNumber);
			int number = fileNumberCharacterToNumber(character);
			accountNumber += number;
		}
		return accountNumber;
	}

	private int fileNumberCharacterToNumber(String character) {
		switch (character) {
		case ZERO:
			return 0;
		case ONE:
			return 1;
		case TWO:
			return 2;
		case THREE:
			return 3;
		case FOUR:
			return 4;
		case FIVE:
			return 5;
		case SIX:
			return 6;
		case SEVEN:
			return 7;
		case EIGHT:
			return 8;
		case NINE:
			return 9;
		default:
			throw new AccountFileParserException("Not parseable character: "
					+ character);
		}
	}

	private String getCharacter(int fileLineNumber, int characterNumber) {
		String line1 = lines[fileLineNumber];
		String line2 = lines[fileLineNumber + 1];
		String line3 = lines[fileLineNumber + 2];
		int startInx = (characterNumber - 1) * 3;
		int endIndex = startInx + 3;
		String character = line1.substring(startInx, endIndex)
				+ line2.substring(startInx, endIndex)
				+ line3.substring(startInx, endIndex);
		return character;
	}

	public class AccountFileParserException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public AccountFileParserException(String message) {
			super(message);
		}
	}
}
