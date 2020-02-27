package choices;

import java.awt.Color;
import java.awt.Graphics;

import main.GameAPI;
import main.MainLoop;

public class Choice {
	int ypos;
	Color texty;
	Color rectanglebro;
	Color otherRectangleBro;
	String text;
	Boolean isChosen;
	Graphics graphics = MainLoop.getWindow().getBuffer();
	public Choice (String choiceText, int y, Color textColor, Color rectangleColor) {
		texty = textColor;
		text = choiceText;
		isChosen = false;
		rectanglebro = rectangleColor;
		ypos = y;
	}
	public void generateSceen () {
		
	}
	public void frameEvent () {
		if (GameAPI.getCursorX() > 100 && GameAPI.getCursorX() < 500 && GameAPI.getCursorY() > ypos && GameAPI.getCursorY() < ypos + 30 && GameAPI.mouseButtonClicked(0)  ) {
			this.generateSceen();
			isChosen = true;
		}
		if (GameAPI.getCursorX() > 100 && GameAPI.getCursorX() < 500 && GameAPI.getCursorY() > ypos && GameAPI.getCursorY() < ypos + 30) {
		otherRectangleBro = rectanglebro.brighter();
		
		} else {
		otherRectangleBro = rectanglebro;
		}
		graphics.setColor(otherRectangleBro);
		graphics.fillRect(100,ypos,400,30);
		graphics.setColor(texty);
		graphics.drawString(text, 250, ypos + 20);
		
	}
	/**
	 * removes the choice from existance
	 */
	public void end (){
		this.graphics.dispose();
	}
	/**
	 * returns wheather or not this option was picked
	 * @return wheater or not the option was picked
	 */
	public boolean wasChosen () {
		return isChosen;
	}
}
