//CHECKSTYLE:OFF
package katabankocr;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Test;

public class AccountFileParserTests {

	@Test
	public final void parseZeros() {		 
		String file = ZEROS;
		List<Account> accounts = parseFile(file);
		assertEquals("000000000", accounts.get(0).getAccountNumber());
	}
	
	@Test
	public final void parseOnes() {		 
		String file = ONES;
		List<Account> accounts = parseFile(file);
		assertEquals("111111111", accounts.get(0).getAccountNumber());
	}	
	
	@Test
	public final void parseTwos() {
		String file = TWOS;
		List<Account> accounts = parseFile(file);
		assertEquals("222222222", accounts.get(0).getAccountNumber());		
	}
	
	@Test
	public final void parseThrees() {
		String file = THREES;
		List<Account> accounts = parseFile(file);
		assertEquals("333333333", accounts.get(0).getAccountNumber());		
	}
	
	@Test
	public final void parseFours() {
		String file = FOURS;
		List<Account> accounts = parseFile(file);
		assertEquals("444444444", accounts.get(0).getAccountNumber());		
	}
	
	@Test
	public final void parseFives() {
		String file = FIVES;
		List<Account> accounts = parseFile(file);
		assertEquals("555555555", accounts.get(0).getAccountNumber());		
	}
	
	@Test
	public final void parseSixs() {
		String file = SIXS;
		List<Account> accounts = parseFile(file);
		assertEquals("666666666", accounts.get(0).getAccountNumber());		
	}	
	
	@Test
	public final void parseSevens() {
		String file = SEVENS;
		List<Account> accounts = parseFile(file);
		assertEquals("777777777", accounts.get(0).getAccountNumber());		
	}
	
	@Test
	public final void parseEights() {
		String file = EIGHTS;
		List<Account> accounts = parseFile(file);
		assertEquals("888888888", accounts.get(0).getAccountNumber());		
	}
	
	@Test
	public final void parseNines() {
		String file = NINES;
		List<Account> accounts = parseFile(file);
		assertEquals("999999999", accounts.get(0).getAccountNumber());		
	}		
	
	@Test
	public final void parseOnesAndZeros() {
		String file = ONES_AND_ZEROS;
		List<Account> accounts = parseFile(file);
		assertEquals("101010101", accounts.get(0).getAccountNumber());		
	}	
	
	@Test
	public final void parseAllNumbers() {
		String file = ALL_NUMBERS;
		List<Account> accounts = parseFile(file);
		assertEquals("123456789", accounts.get(0).getAccountNumber());
	}
	
	@Test
	public final void parseTwoLines() {
		String file = ONES_AND_ZEROS + ALL_NUMBERS;
		List<Account> accounts = parseFile(file);
		assertEquals("101010101", accounts.get(0).getAccountNumber());
		assertEquals("123456789", accounts.get(1).getAccountNumber());
	}

	private List<Account> parseFile(final String file) {
		AccountFileParser parser = new AccountFileParser(file);
		List<Account> accounts = parser.parse();
		return accounts;
	}			
	
	private static final String ZEROS =   " _  _  _  _  _  _  _  _  _ \n"
									    + "| || || || || || || || || |\n"
									    + "|_||_||_||_||_||_||_||_||_|\n"
							            + "                           \n";
	
	private static final String ONES =    "                           \n"
									    + "  |  |  |  |  |  |  |  |  |\n"
									    + "  |  |  |  |  |  |  |  |  |\n"
							            + "                           \n";	
	
	private static final String TWOS =    " _  _  _  _  _  _  _  _  _ \n"
										+ " _| _| _| _| _| _| _| _| _|\n"
										+ "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n"
										+ "                           \n";
	
	private static final String THREES =   " _  _  _  _  _  _  _  _  _ \n"
										 + " _| _| _| _| _| _| _| _| _|\n"
                                         + " _| _| _| _| _| _| _| _| _|\n"
										 + "                           \n";
			                            
	private static final String FOURS =    "                           \n"
										 + "|_||_||_||_||_||_||_||_||_|\n"
							             + "  |  |  |  |  |  |  |  |  |\n"
									     + "                           \n";

	private static final String FIVES =    " _  _  _  _  _  _  _  _  _ \n"
										 + "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n"
								         + " _| _| _| _| _| _| _| _| _|\n"
								         + "                           \n";

	private static final String SIXS =     " _  _  _  _  _  _  _  _  _ \n"
										 + "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n"
								         + "|_||_||_||_||_||_||_||_||_|\n"
										 + "                           \n";

	private static final String SEVENS =   " _  _  _  _  _  _  _  _  _ \n"
										 + "  |  |  |  |  |  |  |  |  |\n"
								         + "  |  |  |  |  |  |  |  |  |\n"
			                             + "                           \n";

	private static final String EIGHTS =   " _  _  _  _  _  _  _  _  _ \n"
										 + "|_||_||_||_||_||_||_||_||_|\n"
								         + "|_||_||_||_||_||_||_||_||_|\n"
										 + "                           \n";

	private static final String NINES =    " _  _  _  _  _  _  _  _  _ \n"
										 + "|_||_||_||_||_||_||_||_||_|\n"
								         + " _| _| _| _| _| _| _| _| _|\n"
										 + "                           \n";	
	
	private static final String ONES_AND_ZEROS =   "    _     _     _     _    \n"
											     + "  || |  || |  || |  || |  |\n"
											     + "  ||_|  ||_|  ||_|  ||_|  |\n"
												 + "                           \n";
	
	private static final String ALL_NUMBERS = "    _  _     _  _  _  _  _ \n"
											+ "  | _| _||_||_ |_   ||_||_|\n"
											+ "  ||_  _|  | _||_|  ||_| _|\n"
											+ "                           \n";
//CHECSTYLE:ON
}
