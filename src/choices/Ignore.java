package choices;

import java.awt.Color;

import main.GameCode;

public class Ignore extends Choice {
	private static final String SUPER_SONIC = "resources/sprites/testSprites/Super_Sonic.png";
	private static final String SPACE =  "resources/backgrounds/testBackgrounds/space.png";
	public Ignore(String choiceText, int y, Color textColor, Color rectangleColor) {
		super(choiceText, y, textColor, rectangleColor);
	}
	/**
	 * all of the code dictating the events that would occur after selecting this choice would go here
	 * there will be one of these classes for every posible choice in the game (probably)
	 */
	@Override 
	public void generateSceen () {
		GameCode.novel.changeExpression(0, SUPER_SONIC);
		GameCode.novel.makeText("NO YOUVE YEED YOUR LAST HAW CENA");
		GameCode.novel.changeBackground(SPACE);
		GameCode.novel.hide(0);
		GameCode.novel.hide(2);
		GameCode.novel.makeText("NO SONIC HIT ME SO HARD I GOT SENT TO SPACE AND NOW IM SCREWED FOREVER");
		GameCode.novel.makeText("THE END");
	}

}
