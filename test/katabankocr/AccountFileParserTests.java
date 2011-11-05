package katabankocr;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountFileParserTests {

	@Test
	public void parseZeros() {		 
		String file = ZEROS;
		AccountFileParser parser = new AccountFileParser(file);
		List<Account> accounts = parser.parse();
		assertEquals("000000000", accounts.get(0).getAccountNumber());
	}
	
	@Test
	public void parseOnes() {		 
		String file = ONES;
		AccountFileParser parser = new AccountFileParser(file);
		List<Account> accounts = parser.parse();
		assertEquals("111111111", accounts.get(0).getAccountNumber());
	}	
	
	@Test
	public void parseTwos() {
		String file = TWOS;
		AccountFileParser parser = new AccountFileParser(file);
		List<Account> accounts = parser.parse();
		assertEquals("222222222", accounts.get(0).getAccountNumber());		
	}
	
	@Test
	public void parseThrees() {
		String file = THREES;
		AccountFileParser parser = new AccountFileParser(file);
		List<Account> accounts = parser.parse();
		assertEquals("333333333", accounts.get(0).getAccountNumber());		
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
                                         + " _| _| _| _| _| _| _| _| _|\n";
			                            

}