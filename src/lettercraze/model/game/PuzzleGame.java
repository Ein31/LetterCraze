package lettercraze.model.game;

import java.util.Random;

import lettercraze.model.Letter;
import lettercraze.model.Level;

/**
 * The PuzzleGame class for making puzzle levels. Since it is a
 * kind of game, it extends the Game abstract class. It overrides
 * all the necessary inherited methods from the superclass.
 * @author Ruthenium
 * @version 1.0
 */
public class PuzzleGame extends Game {
	/**
	 * The PuzzleGame constructor to make a a puzzle level.
	 * @param l The Level
	 * @param id The level number
	 */
	public PuzzleGame(Level l, int id, Random rng) {
		super(l, id, rng);
	}
	
	@Override
	public boolean gameOver() {
		return level.limit != 0 && pastWords.size() >= level.limit;
	}
	
	@Override
	public int scoreWord(String w) {
		int result = 0;
		for (char c : w.toCharArray()) {
			result += Letter.getScore(c);
		}
		result *= (w.length() - 2);
		return result;
	}

	@Override
	public String getInfoString() {
		if (level.limit != 0 ) {
			return "Puzzle | Words left: " + (level.limit - pastWords.size());
		}
		return "Unlimited words";
	}

	@Override
	public Object clone() {
		PuzzleGame result = new PuzzleGame(level, levelID, rng);
		result.score = this.score;
		result.selected = this.selected;
		result.board = this.board;
		result.pastWords = this.pastWords;
		result.pastMoves = this.pastMoves;
		return result;
	}
}
