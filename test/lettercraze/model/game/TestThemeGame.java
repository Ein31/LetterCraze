package lettercraze.model.game;

import junit.framework.TestCase;

import lettercraze.files.Data;
import lettercraze.model.Model;
import lettercraze.model.board.Board;
import lettercraze.model.board.Point;
import lettercraze.view.LetterCraze;

public class TestThemeGame extends TestCase
{
	Model m;
	LetterCraze app;

	@Override
	public void setUp()
	{
		m = new Model(Data.readScores(), 2);
		app = new LetterCraze(m);

		m.loadLevelByID(2);
		app.update();
	}

	@Override
	public void tearDown()
	{
		app.dispose();
	}
	
	public void testInGame()
	{
		assertTrue(m.isInGame());
	}

	public void testBoardContents()
	{
		// Ensure that the board has no empty squares
		for (int row = 0; row < Board.SIZE; ++row)
		{
			for (int col = 0; col < Board.SIZE; ++col)
			{
				assertFalse(m.getCurrentGame().getBoard().isEmpty(new Point(row, col)));
			}
		}
	}
	
	public void testGameOver(){
		assertFalse(m.getCurrentGame().gameOver());
	}
}
