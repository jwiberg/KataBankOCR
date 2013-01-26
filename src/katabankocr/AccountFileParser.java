package katabankocr;

import java.util.ArrayList;
import java.util.List;

public final class AccountFileParser {

    private enum Number {
        ZERO (0," _ " + "| |" + "|_|"),
        ONE(1,"   " + "  |" + "  |"),
        TWO(2," _ " + " _|" + "|_ "),
        THREE(3," _ " + " _|" + " _|"),
        FOUR(4,"   " + "|_|" + "  |"),
        FIVE(5," _ " + "|_ " + " _|"),
        SIX(6," _ " + "|_ " + "|_|"),
        SEVEN(7," _ " + "  |" + "  |"),
        EIGHT(8," _ " + "|_|" + "|_|"),
        NINE(9," _ " + "|_|" + " _|");

        private static final int DIGITAL_CHAR_WIDTH = 3;
        private static final int DIGITAL_CHAR_HEIGHT = 4;

        private final String digital;
        private final Integer decimal;

        private Number(Integer decimal, String digital) {
            this.decimal = decimal;
            this.digital = digital;
        }

        private static Integer getDecimalByDigital(String digital) {
            for(Number number : Number.values()) {
                if(number.digital.equals(digital)) {
                    return number.decimal;
                }
            }
            return -1;
        }
    }

	private final String[] lines;

	public AccountFileParser(String file) {
		this.lines = file.split("\n");
	}

	public List<Account> parse() {
		List<Account> accounts = new ArrayList<>();
		for (int i = 0; i < lines.length; i = i + Number.DIGITAL_CHAR_HEIGHT) {
			String accountNumber = parseAccountNumber(i);
			accounts.add(new Account(accountNumber));
		}
		return accounts;
	}

	private String parseAccountNumber(int fileLineNumber) {
		StringBuilder accountNumber = new StringBuilder();
		for (int characterNumber = 1; characterNumber <= Account.ACCOUNT_NUMBER_LENGHT; characterNumber++) {
			String character = getCharacter(fileLineNumber, characterNumber);
			appendCharacter(accountNumber, character);
		}
		return accountNumber.toString();
	}

	private void appendCharacter(StringBuilder accountNumber, String character) {
		int number = Number.getDecimalByDigital(character);
		if (number < 0) {
			accountNumber.append('?');
		} else {
			accountNumber.append(number);
		}
	}

	private String getCharacter(int fileLineNumber, int characterNumber) {
		String line1 = lines[fileLineNumber];
		String line2 = lines[fileLineNumber + 1];
		String line3 = lines[fileLineNumber + 2];
		int startInx = (characterNumber - 1) * Number.DIGITAL_CHAR_WIDTH;
		int endIndex = startInx + Number.DIGITAL_CHAR_WIDTH;
		return line1.substring(startInx, endIndex)
				+ line2.substring(startInx, endIndex)
				+ line3.substring(startInx, endIndex);
	}
}
