package main;

import java.util.ArrayList;

import choices.Choice;
import resources.Sprite;
import resources.Spritesheet;
import resources.Textbox;

public class NovelInterface {
	private Textbox box = new Textbox ("Jeff and jane went for a interesting walk?");
	private Charictar leftCharictar;
	private Charictar middleCharictar;
	private Charictar rightCharictar;
	private Sprite background;
	private ArrayList <String> comands = new ArrayList<String>();
	private Choice [] picks;
	/**
	 * @author Jeffrey
	 */
	public NovelInterface () {
	     box.setY(350);
	      box.setX(20);
	      box.changeWidth(600);
	      background = new Sprite ("resources/text.png");
	      leftCharictar = new Charictar ("resources/text.png");
	      middleCharictar = new Charictar ("resources/text.png");
	      rightCharictar = new Charictar ("resources/text.png");
	}
	public void onceAframe () {

		  background.draw(0, 0);
		  leftCharictar.drawEvent();
		  middleCharictar.drawEvent();
		  rightCharictar.drawEvent();
		  box.drawBox();	
		  this.runActions();
	}
	
	//command zero is setting the position of the left charictar
	//command one is setting the position of the middle charictar
	//command two is setting the position of the right charictar
	//command three is setting text for the box
	// command four changes the background
	// command five is for changeing the expression of the left charictar
	// command six is for changeing the expression of the middle charictar
	// command seven is for changeing the expression of the right charictar 
	// command eight is for hideing the left charictar
	// command nine is for hiding of the middle charictar 
	// command ten is for hiding of the right charictar 
	// command eliven is for makeing the left charictar visable
	// command twelve is for makeing  the middle charictar visable
	// command thirteen is for makeing the right charictar visable
	// command fourteen is for changing the font of the text 	
	// command fifteen is for playing a sound effect
	// command sixteen is for changeing the currently playing song
	// command seventeen is for giveing the player choices
	public void runActions () {
		try {
		boolean readyToMoveOn = false;
		while (!readyToMoveOn) {
		int comandNumber = Integer.parseInt(comands.get(0));
		switch (comandNumber) {
		case 0:
			leftCharictar.setX(Integer.parseInt(comands.get(1)));
			leftCharictar.setY(Integer.parseInt(comands.get(2)));
			comands.remove(0);
			comands.remove(0);
			comands.remove(0);
			break;
		case 1:
			middleCharictar.setX(Integer.parseInt(comands.get(1)));
			middleCharictar.setY(Integer.parseInt(comands.get(2)));
			comands.remove(0);
			comands.remove(0);
			comands.remove(0);
			break;
		
		case 2:
			rightCharictar.setX(Integer.parseInt(comands.get(1)));
			rightCharictar.setY(Integer.parseInt(comands.get(2)));
			comands.remove(0);
			comands.remove(0);
			comands.remove(0);
			break;
		case 3:
			readyToMoveOn = true;
			if (!box.getText().equals(comands.get(1))) {
				box.resetBox();
			box.changeText(comands.get(1));
			} else {
			if (box.isDone) {
			comands.remove(0);
			comands.remove(0);
			box.resetBox();
			}
			}
			break;
		case 4:
			background = new Sprite (comands.get(1));
			comands.remove(0);
			comands.remove(0);
			break;
		case 5:
			leftCharictar.setExpression(comands.get(1));
			comands.remove(0);
			comands.remove(0);
			break;
		case 6:
			middleCharictar.setExpression(comands.get(1));
			comands.remove(0);
			comands.remove(0);
			break;
		case 7:
			rightCharictar.setExpression(comands.get(1));
			comands.remove(0);
			comands.remove(0);
			break;
		case 8:
			leftCharictar.hide();
			comands.remove(0);
			break;
		case 9:
			middleCharictar.hide();
			comands.remove(0);
			break;	
		case 10:
			rightCharictar.hide();
			comands.remove(0);
			break;	
		case 11:
			leftCharictar.show();
			comands.remove(0);
			break;
		case 12:
			middleCharictar.show();
			comands.remove(0);
			break;
		case 13:
			rightCharictar.show();
			comands.remove(0);
			break;
		case 14:
			box.changeFont(new Spritesheet (comands.get(1)));
			comands.remove(0);
			comands.remove(0);
			break;
		case 15:
			GameCode.stuff.playSoundEffect(GameCode.volume, comands.get(1));
			comands.remove(0);
			comands.remove(0);
			break;
		case 16:
		GameCode.clip.stop();
		GameCode.stuff.play(comands.get(1), GameCode.volume);
		comands.remove(0);
		comands.remove(0);
		break;
		case 17:
			readyToMoveOn = true;
		for (int i= 0; i < picks.length; i++) {
			picks[i].frameEvent();
			if (picks[i].wasChosen()) {
				comands.remove(0);
			}
		}
		break;
	}
	}
		} catch (IndexOutOfBoundsException e) {
			
		}
	}
	/**
	 * places one of the charictars wherever you want it 
	 * @param witchCharictar a number corisponding to witch charictar to move zero for the left one one for the middle one and two fro the right one 
	 * @param x the x place to put it
	 * @param y the y place to put it
	 */
	public void setCharictarPosition(int witchCharictar, int x, int y) {	
		comands.add(Integer.toString(witchCharictar));
		comands.add(Integer.toString(x));
		comands.add(Integer.toString(y));
	}
	/**
	 * puts text in the text box and advances when the player reads it
	 * @param message the text to place
	 */
	public void makeText (String message) {
		comands.add("3");
		comands.add(message);
	}
	/**
	 * changes the background to a new background
	 * @param background a filepath to a background image
	 */
	public void changeBackground (String background) {
		comands.add("4");
		comands.add(background);
	}
	/**
	 * places one of the charictars wherever you want it 
	 * @param witchCharictar a number corisponding to witch charictar to move zero for the left one one for the middle one and two for the right one 
	 * @param expression a filepath to an image of the expression you want the charictar to have
	 */
	public void changeExpression (int witchCharictar, String expression) {
		comands.add(Integer.toString(witchCharictar + 5));
		comands.add(expression);
	}
	/**
	 * hides one of the charictars makeing it invisable
	 * (wow Jeffrey objectifying people whats wrong with you?)
	 * @param witchCharictar a number corisponding to witch charictar to move zero for the left one one for the middle one and two for the right one 
	 */
	public void hide (int witchCharictar) {
		comands.add (Integer.toString(witchCharictar + 8));
	}
	/**
	 * makes an invesable charictar visable again
	 * @param witchCharictar a number corisponding to witch charictar to move zero for the left one one for the middle one and two for the right one 
	 */
	public void show (int witchCharictar) {
		comands.add (Integer.toString(witchCharictar + 11));
	}
	/**
	 * changes the font of the text
	 * @param font a filepath to the font image 
	 */
	public void changeFont (String font) {
		comands.add("14");
		comands.add(font);
	}
	/**
	 * plays the requested sound effect
	 * @param sound a filepath for the correct sound effect
	 */
	public void playSound (String sound) {
		comands.add("15");
		comands.add(sound);
	}
	/**
	 * changes the music to requested music
	 * @param song the filepath to the wav song
	 */
	public void playMusic (String song) {
		comands.add("16");
		comands.add(song);
	}
	public void makeChoice (Choice [] choices) {
		comands.add("17");
		picks = choices;
	}
	
	
}
