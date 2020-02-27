package main;


import java.awt.Color;
import java.io.File;

import javax.sound.sampled.Clip;

import choices.BreakItUp;
import choices.Choice;
import choices.Ignore;
import resources.SoundPlayer;


public class GameCode extends GameAPI {
	private static final String JOHN_CENA = "resources/sprites/testSprites/cena.png";
	private static final String SONIC = "resources/sprites/testSprites/sonic.png";
	
	private static final String OLD_TIME = "resources/backgrounds/testBackgrounds/bruh.png";
	private static final String COWBOY =  "resources/backgrounds/testBackgrounds/yeehaw.png";
	
	private static final String TITAL = "resources/music/testMusic/tital theme.wav";
	private static final String MARSH_ANS = "resources/music/testMusic/marsh-ans theme version 2.wav";
	private static final String EXTRASENSORY = "resources/music/testMusic/extrasensory.wav";
	private static final String GOD = "resources/music/testMusic/thank god for automobiels and the eisenhower hiway sytem attempt 6.wav";
	private static final String ROADS = "resources/music/testMusic/clear the roads (final).wav";
	private static final String BANDITS = "resources/music/testMusic/vs bandits.wav";
	private static final String RAGE = "resources/music/testMusic/ROAD RAGE!.wav";
	private static final String MOBIUS = "resources/music/testMusic/mobius batte.wav";
	private static final String HOOPS = "resources/music/testMusic/jumping through hoops.wav";
	private static final String CLEAR = "resources/music/testMusic/clear the roads (final).wav";
	private static final String BUY = "resources/sounds/testSounds/buy BUY BUY!.wav";
	private static final String EXPLOSION = "resources/sounds/testSounds/explosion.wav";
	private static final String LAZER = "resources/sounds/testSounds/lazer.wav";
	private static final String REV = "resources/sounds/testSounds/rev.wav";
	private static final String CRASH = "resources/sounds/testSounds/crash.wav";

	private static final String CIRCUT = "resources/sounds/testSounds/short circut.wav";
	private static final String BLUE = "resources/text (blue).png";
	private static final String GREEN = "resources/text (lime green).png";
	private static final String LASER_GUY = "resources/sprites/testSprites/cowboy.png";
	
  private GameWindow gameWindow;
  public static  Clip clip;
  private boolean firstRun = true;
  public static float volume;
  private BreakItUp bruh;
  private Ignore ignore;
  public static NovelInterface novel = new NovelInterface();
  static SoundPlayer stuff;
  public void initialize(){
	  bruh = new BreakItUp ("Stop the fight ", 150, new Color (0x17131E), new Color (0x27DF29));
	  ignore = new Ignore ("fight anyway ", 250, new Color (0x17131E), new Color (0x27DF29));
	if (firstRun) {
		this.generateSceen();
      stuff = new SoundPlayer();
      volume = -2.0F;
      stuff.play(TITAL, volume);
      firstRun = false;
  }
    
}
  /**
   * used to set up all comands for the novel interface
   * baseically this is where you write the story in simpler terms
   * the first sceen would go here
   */
  public void generateSceen() {
	  novel.changeBackground(OLD_TIME);
	  novel.changeFont(BLUE);
	  novel.hide(0);
	  novel.hide(1);
	  novel.hide(2);
	  novel.makeText("A LONG TIME AGO IN A COWBOY VILLAGE NOT FAR FROM HERE");
	  novel.playMusic(BANDITS);
	  novel.setCharictarPosition(0, 300, 0);
	  novel.playSound(REV);
	  novel.changeExpression(0, SONIC);
	  novel.show(0);
	  novel.changeBackground(COWBOY);
	  novel.makeText("SONIC - THIS TOWN AINT BIG ENOGH FOR THE TWO OF US SO YOU BETTER RUN QUICK");
	  novel.setCharictarPosition(1, 25, 0);
	  novel.changeExpression(1,JOHN_CENA);
	  novel.show(1);
	  novel.makeText("JOHN CENA - YOU JERK ILL PUNCH YOU SO HARD THE TEXT WILL CHANGE COLOR");
	  novel.playSound(CRASH);
	  novel.changeFont(GREEN);
	  novel.makeText("SONIC - OUCHY");
	  novel.playMusic(MARSH_ANS);
	  novel.playSound(LAZER);
	  novel.makeText("SONIC - OH NO THERES ONLY ONE COWBOY WHO WEILDS A LASER GUN ");
	  novel.changeExpression(2, LASER_GUY);
	  novel.setCharictarPosition(2, 190, 0);
	  novel.show(2);
	  novel.makeText("YALL BETTER STOP FIGTIN NOW ");
	  novel.makeChoice(new Choice [] {bruh,ignore});
  }
  public void gameLoop() {
	  this.initialize();
	  novel.onceAframe();
    }
   
}