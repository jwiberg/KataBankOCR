package katabankocr;

import java.util.ArrayList;
import java.util.List;

public class AccountFileParser {

	private String file;

	private static final String ZERO = " _ " + "| |" + "|_|";
	private static final String ONE = "   " + "  |" + "  |";
	private static final String TWO = " _ " + " _|" + "|_ ";
	private static final String THREE = " _ " + " _|" + " _|";

	public AccountFileParser(String file) {
		this.file = file;
	}

	public List<Account> parse() {
		List<Account> accounts = new ArrayList<Account>();
		String[] lines = file.split("\n");

		for (int i = 0; i < lines.length; i = i + 4) {			
			String accountNumber = parseAccountNumber(lines, i);			 
			accounts.add(new Account(accountNumber));
		}

		return accounts;
	}

	private String parseAccountNumber(String[] lines, int i) {
		String accountNumber = "";
		for(int j = 1; j < 10; j++) {
			String character = getCharacter(lines, i, 1);
			
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
			default:
				break;
			}				
		}
		return accountNumber;
	}

	private String getCharacter(String[] lines, int fileLineNumber,
			int characterNumber) {
		String line1 = lines[fileLineNumber];
		String line2 = lines[fileLineNumber + 1];
		String line3 = lines[fileLineNumber + 2];
		String character = line1.substring((characterNumber - 1) * 4,
				(characterNumber - 1) * 4 + 3)
				+ line2.substring((characterNumber - 1) * 4,
						(characterNumber - 1) * 4 + 3)
				+ line3.substring((characterNumber - 1) * 4,
						(characterNumber - 1) * 4 + 3);
		return character;
	}

}
