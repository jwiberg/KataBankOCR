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
			switch (character) {
			case ZERO:
				accountNumber += 0;
				break;
			case ONE:
				accountNumber += 1;
				break;
			case TWO:
				accountNumber += 2;
				break;
			case THREE:
				accountNumber += 3;
				break;
			case FOUR:
				accountNumber += 4;
				break;
			case FIVE:
				accountNumber += 5;
				break;
			case SIX:
				accountNumber += 6;
				break;
			case SEVEN:
				accountNumber += 7;
				break;
			case EIGHT:
				accountNumber += 8;
				break;
			case NINE:
				accountNumber += 9;
				break;
			default:
				break;
			}
		}
		return accountNumber;
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

}
