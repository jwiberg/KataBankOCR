package katabankocr;

import java.io.File;
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
	public void writeSimpleFile() throws Exception{
		try(FileWriter fr = new FileWriter(TEST_FILE_NAME)) {
			Account account = new Account("123456789");
			List<Account> accounts = new ArrayList<Account>();
			accounts.add(account);
			LogWriter logWriter = new LogWriter();
			logWriter.setFileWriter(fr);
			logWriter.write(accounts);					
		}
		
		File file = new File(TEST_FILE_NAME);
		assert(file.exists());
	}
}
