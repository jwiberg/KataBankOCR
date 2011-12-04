package katabankocr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Test;

public class LogFileWriterTests {

	private static final String TEST_FILE_NAME = "accounts.dat";

	@After
	public void clean() {
		File file = new File(TEST_FILE_NAME);
		file.delete();
	}

	@Test
	public void writeSimpleFile() throws Exception {
		try (FileWriter fr = new FileWriter(TEST_FILE_NAME)) {
			Account account = new Account("123456789");
			List<Account> accounts = new ArrayList<Account>();
			accounts.add(account);
			LogWriter logWriter = new LogWriter();
			logWriter.setFileWriter(fr);
			logWriter.write(accounts);
		}

		File file = new File(TEST_FILE_NAME);
		assertTrue(file.exists());
	}

	@Test
	public void write3AccountsToFile() throws Exception {
		try (FileWriter fr = new FileWriter(TEST_FILE_NAME)) {
			Account accountValid = new Account("123456789");
			Account accountInvalid = new Account("132453455");
			Account accountIllegalCharaters = new Account("13??53455");
			List<Account> accounts = new ArrayList<Account>();
			accounts.add(accountValid);
			accounts.add(accountInvalid);
			accounts.add(accountIllegalCharaters);
			LogWriter logWriter = new LogWriter();
			logWriter.setFileWriter(fr);
			logWriter.write(accounts);
		}

		BufferedReader reader = new BufferedReader(new FileReader(
				TEST_FILE_NAME));
			
		assertEquals("123456789", reader.readLine());
		assertEquals("132453455 ERR", reader.readLine());
		assertEquals("13??53455 ILL", reader.readLine());
		
		reader.close();
	}
}
