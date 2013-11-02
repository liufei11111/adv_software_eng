package registration;

import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.start;
import model.forms.RegisterForm;

import org.junit.Before;
import org.junit.Test;

import constants.ApplicationConstants;

public class RegistrationTest {
	@Before
	public void setUp() {
	    start(fakeApplication(inMemoryDatabase()));
	}

	
	@Test
    public void passwordMismatch() {
		RegisterForm registerForm = new RegisterForm();
		registerForm.email="susan.g.fung@gmail.com";
		registerForm.firstName="Susan";
		registerForm.lastName="Fung";
		registerForm.password="abc";
		registerForm.password2="abcd";
		String message = registerForm.validate();
		assert(message.equals(ApplicationConstants.PASSWORD_MISMATCH));
    }
	
	@Test
    public void userAlreadyRegistered() {
		RegisterForm registerForm = new RegisterForm();
		registerForm.email="sgf2110@columbia.edu";
		registerForm.firstName="Susan";
		registerForm.lastName="Fung";
		registerForm.password="abc";
		registerForm.password2="abc";
		registerForm.isEnabled=1;
//		registerForm.accountType=AccountTypeEnum.PLAYER.toString();
		String message = registerForm.validate();
		assert(message.equals(ApplicationConstants.USER_ALREADY_REGISTERED));
    }
	
	
//	//not sure why it changes evolution when running unit tests
//	@Test
//    public void successRegistration() {
//		RegisterForm registerForm = new RegisterForm();
//		registerForm.email="susan.fung@gmail.com";
//		registerForm.firstName="Susan";
//		registerForm.lastName="Fung";
//		registerForm.password="abc";
//		registerForm.password2="abc";
//		registerForm.isEnabled=1;
//		registerForm.accountType=AccountTypeEnum.PLAYER.toString();
//		String message = registerForm.validate();
//		assert(message.equals(null));
//    }
	  
}
