package choices;

import java.awt.Color;

import main.GameCode;

public class BreakItUp extends Choice {
	private static final String SHOTGUN = "resources/sounds/testSounds/shotgun.wav";
	private static final String SANDERS = "resources/sprites/testSprites/sanders.png";
	private static final String NAGITO = "resources/sprites/testSprites/my_boi.png";
	private static final String RANCH = "resources/backgrounds/testBackgrounds/ram ranch.png";
	public BreakItUp(String choiceText, int y, Color textColor, Color rectangleColor) {
		super(choiceText, y, textColor, rectangleColor);
	}
	/**
	 * all of the code dictating the events that would occur after selecting this choice would go here
	 * there will be one of these classes for every posible choice in the game (probably)
	 */
	@Override 
	public void generateSceen () {
		GameCode.novel.hide(0);
		GameCode.novel.hide(1);
		GameCode.novel.hide(2);
		GameCode.novel.makeText("THE GROUP MADE UP AND WENT TO A NEW PLACE TO CELBRATE");
		GameCode.novel.show(0);
		GameCode.novel.changeBackground(RANCH);
		GameCode.novel.makeText("SONIC - RAM RANCH?");
		GameCode.novel.playSound(SHOTGUN);
		GameCode.novel.changeExpression(1, SANDERS);
		GameCode.novel.show(1);
		GameCode.novel.makeText("DARNED KIDS GET OFF MY PROPERTY");
		GameCode.novel.hide(0);
		GameCode.novel.makeText("AND THEN CORNEL SANDERS SHOT THEM ALL WITH HIS SHOTGUN AND EVERYONE DIED THE END");
		GameCode.novel.changeExpression(0, NAGITO);
		GameCode.novel.show(0);
		GameCode.novel.makeText("WOW HAJIME YOU WENT TO RAM RANCH AND YOU DIDENT EVEN INVITE ME WHAT THE FUCK IS WRONG WITH YOU HAJME?");
	}
}
