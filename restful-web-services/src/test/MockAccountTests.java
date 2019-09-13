package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import MockClasses.MockAccount;

class MockAccountTests {
	
	public static MockAccount account;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {}

	@AfterAll
	static void tearDownAfterClass() throws Exception {}

	@BeforeEach
	void setUp() throws Exception 
	{
		account = new MockAccount("user", "pass");
	}

	@AfterEach
	void tearDown() throws Exception {}
	
	@Test
	public void validUserNameTest()
	{
		assertTrue(account.validUsername("Homy"));
	}
	
	@Test
	public void invalidUserNameTest()
	{
		assertFalse(account.validUsername("Homy15Th3Be$T"));
	}
	
	@Test
	public void validPasswordTest()
	{
		assertTrue(account.validPassword("bgui%vejkf"));
	}
	
	@Test
	public void invalidPasswordTest()
	{
		assertFalse(account.validPassword("bguivejkf"));
	}
}
