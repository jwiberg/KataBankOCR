package katabankocr;

import java.io.FileWriter;

import org.junit.Test;

public class LogFileWriterTests {
	
	
	
	@Test
	public void writeSimpleFile() throws Exception{
		FileWriter fr = new FileWriter("accounts.dat");
	}
}
