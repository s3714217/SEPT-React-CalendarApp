package frontEndTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import mockObjects.MockAccount;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Login_Authentication_Tests {

//Account Tests
	//Create Account Tests
	@Test
	void validEmailTest() 
	{
		assertTrue(MockAccount.validEmail("valid@email.com"));
	}
	
	@Test
	void invalidEmailTest()
	{
		assertFalse(MockAccount.validEmail("invalidEmailRegex@@@@"));
	}
	
	@Test
	void fullInputFieldsTest()
	{
		//Fill in all fields
		assertFalse(MockAccount.emptyInputField());
	}

	@Test
	void emptyInputFieldsTest()
	{
		//Leave some fields empty
		assertTrue(MockAccount.emptyInputField());
	}
	
	@Test
	void matchPasswordTest()
	{
		//Set both fields the same
		assertTrue(MockAccount.matchPassword(MockAccount.getPassword(), MockAccount.getConfirmPassword()));
	}
	
	@Test
	void notMatchPasswordTest()
	{
		//Set fields as different
		assertFalse(MockAccount.matchPassword(MockAccount.getPassword(), MockAccount.getConfirmPassword()));
	}
	
	@Test
	void validPasswordLengthTest()
	{
		//Set password field to length >= 6
		assertTrue(MockAccount.checkLength(MockAccount.getPassword(), 6));
	}
	
	@Test
	void invalidPasswordLengthTest()
	{
		//Set password field to length < 6
		assertFalse(MockAccount.checkLength(MockAccount.getPassword(), 6));
	}
	
	@Test
	void validSeccurityQuestion1LengthTest()
	{
		//Set question 1 answer field to length >= 5
		assertTrue(MockAccount.checkLength(MockAccount.getQuestion1Answer(), 5));
	}
	
	@Test
	void invalidSeccurityQuestion1LengthTest()
	{
		//Set question 1 answer field to length < 5
		assertFalse(MockAccount.checkLength(MockAccount.getQuestion1Answer(), 5));
	}
	
	@Test
	void validSeccurityQuestion2LengthTest()
	{
		//Set question 2 answer field to length >= 5
		assertTrue(MockAccount.checkLength(MockAccount.getQuestion2Answer(), 5));
	}
	
	@Test
	void invalidSeccurityQuestion2LengthTest()
	{
		//Set question 2 answer field to length < 5
		assertFalse(MockAccount.checkLength(MockAccount.getQuestion2Answer(), 5));
	}
	
	@Test
	void validSeccurityQuestion3LengthTest()
	{
		//Set question 3 answer field to length >= 5
		assertTrue(MockAccount.checkLength(MockAccount.getQuestion3Answer(), 5));
	}
	
	@Test
	void invalidSeccurityQuestion3LengthTest()
	{
		//Set question 3 answer field to length < 5
		assertFalse(MockAccount.checkLength(MockAccount.getQuestion3Answer(), 5));
	}
	
//Account Tests
	//Login Tests
	@Test
	void correctUserNameTest()
	{	//input is the same as user name
		assertTrue(MockAccount.correctUserName(MockAccount.getInput(), MockAccount.getUsername()));
	}
	
	@Test
	void incorrectUserNameTest()
	{	//input is not the same as user name
		assertFalse(MockAccount.correctUserName(MockAccount.getInput(), MockAccount.getUsername()));
	}
	
	@Test
	void correctPasswordTest()
	{	//input is the same as password
		assertTrue(MockAccount.correctUserName(MockAccount.getInput(), MockAccount.getPassword()));
	}
	
	@Test
	void incorrectPasswordTest()
	{	//input is not the same as password
		assertFalse(MockAccount.correctUserName(MockAccount.getInput(), MockAccount.getPassword()));
	}
	
	@Test
	void validRecoveredPasswordLengthTest()
	{
		//Set password field to length >= 6
		assertTrue(MockAccount.checkLength(MockAccount.getRecoveredPassword(), 6));
	}
	
	@Test
	void invalidRecoveredPasswordLengthTest()
	{
		//Set password field to length < 6
		assertFalse(MockAccount.checkLength(MockAccount.getRecoveredPassword(), 6));
	}
	
	@Test
	void matchRecoveredPasswordTest()
	{
		//Set both fields the same
		assertTrue(MockAccount.matchPassword(MockAccount.getRecoveredPassword(), MockAccount.getConfirmRecoveredPassword()));
	}
	
	@Test
	void notMatchRecoveredPasswordTest()
	{
		//Set fields as different
		assertFalse(MockAccount.matchPassword(MockAccount.getRecoveredPassword(), MockAccount.getConfirmRecoveredPassword()));
	}
}