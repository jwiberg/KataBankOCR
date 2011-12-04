package katabankocr;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public final class LogWriter {

	private Writer writer;

	public void setFileWriter(FileWriter fileWriter) {
		this.writer = fileWriter;
	}

	public void write(List<Account> accounts) {
		try {
			writeAccountsToFile(accounts);
		} catch (Exception e) {
			throw new LogFileWriterException(e);
		} 
	}

	private void writeAccountsToFile(List<Account> accounts) throws IOException {
		for (Account account : accounts) {
			if (account.hasIllegalCharacters()) {
				this.writer
						.write(account.getAccountNumber() + " ILL\n");
			} else if (!account.isValid()) {
				this.writer
						.write(account.getAccountNumber() + " ERR\n");
			} else {
				this.writer.write(account.getAccountNumber() + "\n");
			}
		}
	}

	private class LogFileWriterException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public LogFileWriterException(Exception e) {
			super(e);
		}
	}

}
