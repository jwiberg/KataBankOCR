package katabankocr;

import static org.junit.Assert.*;
import org.junit.Test;

public class AccountTests {
	
	@Test
	public void shouldBeValid() {
		Account account = new Account("345882865");
		assertTrue(account.isValid());
	}
	
	@Test
	public void shouldBeInvalid() {
		Account account = new Account("111111111");
		assertTrue(!account.isValid());		
	}
	
}
