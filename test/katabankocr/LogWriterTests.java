package katabankocr;

//CHECKSTYLE:OFF
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public final class LogWriterTests {

	private static final String VALID_ACCOUNT_NUMBER_457508000 = "457508000";
	private static final String INVALID_ACCOUNT_NUMBER_664371495 = "664371495";
	private static final String ILLEGALCHARACTER_ACCOUNT_NUMBER_66XX71495 = "66??71495";

	private LogWriter logFileWriter;
	private FileWriter fileWriter;

	@Before
	public void init() {
		this.logFileWriter = new LogWriter();
		this.fileWriter = mock(FileWriter.class);
		this.logFileWriter.setFileWriter(this.fileWriter);
	}

	@Test
	public void logValidAccount() throws Exception {
		List<Account> accounts = new ArrayList<>();
		accounts.add(new Account(VALID_ACCOUNT_NUMBER_457508000));
		this.logFileWriter.write(accounts);
		verify(this.fileWriter, times(1)).write(
				VALID_ACCOUNT_NUMBER_457508000 + "\n");
	}

	@Test
	public void logInvalidAccout() throws Exception {
		List<Account> accounts = new ArrayList<>();
		accounts.add(new Account(INVALID_ACCOUNT_NUMBER_664371495));
		this.logFileWriter.write(accounts);
		verify(this.fileWriter, times(1)).write(
				INVALID_ACCOUNT_NUMBER_664371495 + " ERR\n");
	}

	@Test
	public void logAccountWithIllegalCharacters() throws Exception {
		List<Account> accounts = new ArrayList<>();
		accounts.add(new Account(ILLEGALCHARACTER_ACCOUNT_NUMBER_66XX71495));
		this.logFileWriter.write(accounts);
		verify(this.fileWriter, times(1)).write(
				ILLEGALCHARACTER_ACCOUNT_NUMBER_66XX71495 + " ILL\n");
	}
		
}
