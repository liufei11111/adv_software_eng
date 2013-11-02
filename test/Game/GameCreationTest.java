package Game;

import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.start;
import managers.GameManager;

import org.junit.Before;
import org.junit.Test;

import play.mvc.Controller;
import constants.ApplicationConstants;

public class GameCreationTest {
	private GameManager gameManager;
	
	@Before
	public void setUp() {
	    start(fakeApplication(inMemoryDatabase()));
	    gameManager = new GameManager();
	}

	@Test
    public void createFixedTimeChallengeGameTest() {
		Controller.session(ApplicationConstants.USER,"sgf2110@columbia.edu");
		boolean isCreated = gameManager.createFixedTimeChallengeGame("Test game", 2);
		assert(isCreated == true);
    }
	
	@Test
    public void createLumpSumGameTest() {
		Controller.session(ApplicationConstants.USER,"sgf2110@columbia.edu");
		boolean isCreated = gameManager.createLumpSumGame("Test game", 500);
		assert(isCreated == true);
    }
	
	@Test
    public void createFixedTimeChallengeGameErrorTest() {
		boolean isCreated = gameManager.createFixedTimeChallengeGame("Test game", 2);
		assert(isCreated == false);
    }
	
	@Test
    public void createLumpSumGameErrorTest() {
		boolean isCreated = gameManager.createLumpSumGame("Test game", 500);
		assert(isCreated == false);
    }

}
