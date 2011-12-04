package katabankocr;

import java.util.ArrayList;
import java.util.List;

public final class AccountFileParser {

	private static final int FILE_CHAR_WIDTH = 3;
	private static final int FILE_CHAR_HEIGHT = 4;

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

	private String[] lines;

	public AccountFileParser(String file) {
		this.lines = file.split("\n");
	}

	public List<Account> parse() {
		List<Account> accounts = new ArrayList<Account>();
		for (int i = 0; i < lines.length; i = i + FILE_CHAR_HEIGHT) {
			String accountNumber = parseAccountNumber(i);
			accounts.add(new Account(accountNumber));
		}
		return accounts;
	}

	private String parseAccountNumber(int fileLineNmber) {
		StringBuilder accountNumber = new StringBuilder();
		for (int characterNumber = 1; characterNumber <= Account.ACCOUNT_NUMBER_LENGHT; characterNumber++) {
			String character = getCharacter(fileLineNmber, characterNumber);
			appendCharacter(accountNumber, character);
		}
		return accountNumber.toString();
	}

	private void appendCharacter(StringBuilder accountNumber, String character) {
		int number = fileNumberCharacterToNumber(character);
		if (number < 0) {
			accountNumber.append("?");
		} else {
			accountNumber.append(number);
		}
	}

	private String getCharacter(int fileLineNumber, int characterNumber) {
		String line1 = lines[fileLineNumber];
		String line2 = lines[fileLineNumber + 1];
		String line3 = lines[fileLineNumber + 2];
		int startInx = (characterNumber - 1) * FILE_CHAR_WIDTH;
		int endIndex = startInx + FILE_CHAR_WIDTH;
		String character = line1.substring(startInx, endIndex)
				+ line2.substring(startInx, endIndex)
				+ line3.substring(startInx, endIndex);
		return character;
	}
	
	// CHECKSTYLE:OFF
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
			return -1;
		}
	}
	// CHECKSTYLE:ON	

}
