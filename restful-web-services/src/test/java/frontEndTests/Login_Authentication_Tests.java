package frontEndTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import mockObjects.MockAccount;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Login_Authentication_Tests {

	MockAccount account = new MockAccount();
//Account Tests
	//Create Account Tests
	@Test
	void validEmailTest() 
	{
		assertTrue(account.validEmail("valid@email.com"));
	}
	
	@Test
	void invalidEmailTest()
	{
		assertFalse(account.validEmail("invalidEmailRegex@@@@"));
	}
	
	@Test
	void fullInputFieldsTest()
	{
		//Fill in all fields
		assertFalse(account.emptyInputField());
	}

	@Test
	void emptyInputFieldsTest()
	{
		//Leave some fields empty
		assertTrue(account.emptyInputField());
	}
	
	@Test
	void matchPasswordTest()
	{
		//Set both fields the same
		assertTrue(account.matchPassword(account.getPassword(), account.getConfirmPassword()));
	}
	
	@Test
	void notMatchPasswordTest()
	{
		//Set fields as different
		assertFalse(account.matchPassword(account.getPassword(), account.getConfirmPassword()));
	}
	
	@Test
	void validPasswordLengthTest()
	{
		//Set password field to length >= 6
		assertTrue(account.checkLength(account.getPassword(), 6));
	}
	
	@Test
	void invalidPasswordLengthTest()
	{
		//Set password field to length < 6
		assertFalse(account.checkLength(account.getPassword(), 6));
	}
	
	@Test
	void validSeccurityQuestion1LengthTest()
	{
		//Set question 1 answer field to length >= 5
		assertTrue(account.checkLength(account.getQuestion1Answer(), 5));
	}
	
	@Test
	void invalidSeccurityQuestion1LengthTest()
	{
		//Set question 1 answer field to length < 5
		assertFalse(account.checkLength(account.getQuestion1Answer(), 5));
	}
	
	@Test
	void validSeccurityQuestion2LengthTest()
	{
		//Set question 2 answer field to length >= 5
		assertTrue(account.checkLength(account.getQuestion2Answer(), 5));
	}
	
	@Test
	void invalidSeccurityQuestion2LengthTest()
	{
		//Set question 2 answer field to length < 5
		assertFalse(account.checkLength(account.getQuestion2Answer(), 5));
	}
	
	@Test
	void validSeccurityQuestion3LengthTest()
	{
		//Set question 3 answer field to length >= 5
		assertTrue(account.checkLength(account.getQuestion3Answer(), 5));
	}
	
	@Test
	void invalidSeccurityQuestion3LengthTest()
	{
		//Set question 3 answer field to length < 5
		assertFalse(account.checkLength(account.getQuestion3Answer(), 5));
	}
	
//Account Tests
	//Login Tests
	@Test
	void correctUserNameTest()
	{	//input is the same as user name
		assertTrue(account.correctUserName(account.getInput(), account.getUsername()));
	}
	
	@Test
	void incorrectUserNameTest()
	{	//input is not the same as user name
		assertFalse(account.correctUserName(account.getInput(), account.getUsername()));
	}
	
	@Test
	void correctPasswordTest()
	{	//input is the same as password
		assertTrue(account.correctUserName(account.getInput(), account.getPassword()));
	}
	
	@Test
	void incorrectPasswordTest()
	{	//input is not the same as password
		assertFalse(account.correctUserName(account.getInput(), account.getPassword()));
	}
	
	@Test
	void validRecoveredPasswordLengthTest()
	{
		//Set password field to length >= 6
		assertTrue(account.checkLength(account.getRecoveredPassword(), 6));
	}
	
	@Test
	void invalidRecoveredPasswordLengthTest()
	{
		//Set password field to length < 6
		assertFalse(account.checkLength(account.getRecoveredPassword(), 6));
	}
	
	@Test
	void matchRecoveredPasswordTest()
	{
		//Set both fields the same
		assertTrue(account.matchPassword(account.getRecoveredPassword(), account.getConfirmRecoveredPassword()));
	}
	
	@Test
	void notMatchRecoveredPasswordTest()
	{
		//Set fields as different
		assertFalse(account.matchPassword(account.getRecoveredPassword(), account.getConfirmRecoveredPassword()));
	}
}
