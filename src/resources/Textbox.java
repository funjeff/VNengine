package resources;
import java.awt.event.KeyEvent;


import main.GameAPI;
import resources.Sprite;



public class Textbox {
	int timer;
	int amountToDraw = 1;
	boolean isFinished;
	boolean finalCheck = false;
	public boolean isDone = false;
	boolean remember = false;
	int spaceManipulation;
	public Sprite textBoxTop;
	public Sprite textBoxBottum;
	public Sprite textBoxBackground;
	public Sprite textBoxSides;
	public Sprite fontSheet;
	String message;
	private int x;
	private int y;
	int isScrolled = 0;
	String text1;
	int width1;
	int height1;
	boolean renderBox;
	// put filepath of fontsheet to use as the font
	public Textbox (String textToDisplay){
	renderBox = true;
	x = 0;
	y = 400;
	Spritesheet FontSheet;
	Spritesheet borderSheet;
	borderSheet = new Spritesheet ("resources/windowsprites2.png");
	FontSheet = new Spritesheet ("resources/text (yellow).png");
	fontSheet = new Sprite (FontSheet, 8, 8);
	textBoxTop = new Sprite (borderSheet, 0, 0, 8, 8); 
	textBoxBottum = new Sprite (borderSheet, 24, 0, 8, 1);
	textBoxSides = new  Sprite (borderSheet, 16, 0, 1, 8);
	textBoxBackground = new Sprite (borderSheet, 8, 0, 8, 8);
	isFinished = false;
	spaceManipulation = 0;
	text1 = textToDisplay;
	width1 = 200;
	height1 = 100;
	}
	public void setX(int newx) {
		x = newx;
	}
	public void setY(int newy) {
		y = newy;
	}
	public void changeWidth (int newWidth) {
		width1 = newWidth;
	}
	public void changeHeight(int newHeigh) {
		height1 = newHeigh;
	}
	public void changeFont (Spritesheet font) {
		fontSheet = new Sprite (font,8,8);
	}
	public void changeBoxVisability () {
		renderBox = !renderBox;
	}
	public void changeText(String newText) {
		text1 = newText;
		this.resetBox();
	}
	public String getText () {
		return text1;
	}
	public void resetBox () {
		spaceManipulation = 0;
		isFinished = false;
		finalCheck = false;
		isDone = false;
		amountToDraw = 1;
		timer = 0;
		isScrolled = 0;
	}
	// text = the message thats displayed width is the width of the box height is the height of the box 
	//x_orign is the x start point of the box y_orign is the y start point of the box
	
public void drawBox (){
	
	if ((finalCheck && isFinished && (GameAPI.keyPressed(65) || GameAPI.keyPressed (97) || isDone)) || GameAPI.keyPressed (88)){
		isDone = true;
	}
	String text;
	int width;
	int height;
	int x_origin;
	int y_origin;
	text = text1;
	width = width1;
	height = height1;
	x_origin = x;
	y_origin = y;
	int space = 0;
	timer = timer + 1;
	int textLength = text.length();
	width = width/8;
	height = height/8;
	int width_start = width;
	int width_beginning = width;
	int width_basis = width;
	int height_start = height;
	height_start = height_start - 2;
	int x_start = x_origin;
	int x_beginning = x_origin;
	int x_basis = x_origin;
	int y_start = y_origin;
	while (width > 1){
	if (renderBox) {
	textBoxTop.draw(x_start, y_start);
	}
	width = width - 1;
	x_start = x_start + 8;
		}
	while (height > 1){
	if (renderBox) {
	textBoxSides.draw(x_origin, y_origin);
	textBoxSides.draw(x_start, y_origin);
		}
	height = height - 1;
	y_origin = y_origin + 8;
		}
	while (width_start > 1){
		if (renderBox) {
		textBoxBottum.draw(x_origin, y_origin);
		}
		width_start = width_start - 1;
		x_origin = x_origin + 8;
			}
	y_origin = y_start;
	x_origin = x_basis;
	int x = 0;
	while (x < height_start){
		width_beginning = width_basis;
		y_start = y_start + 8;
		x_beginning = x_basis;
		x = x + 1;
		while (width_beginning > 1){
			if (renderBox) {
			textBoxBackground.draw(x_beginning, y_start);
			}
			width_beginning = width_beginning - 1;
			x_beginning = x_beginning + 8;
			space = space + 1;
			}
		}
	x_beginning = x_origin;
	int spaceBasis = space;
	int charictarNumber = 0;
	int spaceManipulationPlusSpace = 0;
	int textLengthAtBeginning = textLength;
	width_beginning = width_basis;
	try {
	if (space < text.substring (spaceManipulation, text.length ()).length ()) {
		message = text.substring(spaceManipulation,spaceManipulation + spaceBasis);
	} else {
		//Here's the fix
		message = text.substring (spaceManipulation, text.length ());
	}
	} catch (StringIndexOutOfBoundsException e) {
		
	}
	y_origin = y_origin + 8;
	if (((GameAPI.keyPressed(65) || GameAPI.keyPressed(97)) && isFinished) || message.length () == 0){
		
		amountToDraw = 0;
		if (spaceManipulation <= textLength - spaceManipulation && isFinished) {
			spaceManipulation = spaceManipulation + spaceBasis;
		}
		isFinished = false;
		spaceManipulationPlusSpace = spaceManipulation + spaceBasis;
		if (spaceManipulationPlusSpace >= textLengthAtBeginning){
			spaceManipulationPlusSpace = textLengthAtBeginning;
			isScrolled = space;
			}
		try {
		if (text.substring (spaceManipulation, text.length () - 1).length () >= 30) {
			spaceBasis = 30;
		} else {
			spaceBasis = text.length () - spaceManipulation;
		}
		message = text.substring(spaceManipulation,spaceManipulationPlusSpace);
		} catch (StringIndexOutOfBoundsException e) {
			
		}
}
		textLength = textLength - isScrolled;
		if (timer == 2 || GameAPI.keyDown (65)) {
			timer = 0;
			amountToDraw = amountToDraw + 1;
		}
		int amountToDrawBasis = amountToDraw;
		if ((spaceManipulation + spaceBasis) >= textLength) {
			finalCheck = true;
			space = message.length() - 1;
		}
	for (int n = 0; n < textLength; textLength = textLength - 1){
		if (width_basis == 1){
			y_origin = y_origin + 16;
			x_beginning = x_origin;
			width_basis = width_beginning;
		}
		if (space <= 0 && amountToDraw >= message.length()) {
			isFinished = true;
		}	
		// translates the charictar in the message to a askii value that is used to specify position on the
		// text sheet run for every for every charitar in the message every frame
		if (amountToDrawBasis > 0) {
			amountToDrawBasis = amountToDrawBasis - 1;
			if (charictarNumber < message.length()){
				char charictarInQuestion = message.charAt(charictarNumber);
				charictarNumber = charictarNumber + 1;
				width_basis = width_basis - 1;
				int charitarCode = KeyEvent.getExtendedKeyCodeForChar(charictarInQuestion);
				if (charitarCode == 32) {
					x_beginning = x_beginning + 8;
					space = space - 1;
				}
		// uses the askii value to draw the charictar in the box
				else{
				fontSheet.setFrame(charitarCode);
				fontSheet.draw(x_beginning, y_origin);
				
				x_beginning = x_beginning + 8;
				space = space - 1;
					}
				}
			}
		}
	}
}