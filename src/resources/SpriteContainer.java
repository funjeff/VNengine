package resources;




public class SpriteContainer
{
  private Spritesheet textSheet = new Spritesheet("resources/text.png");
  private Spritesheet blueSheet = new Spritesheet("resources/text (blue).png");
  private Spritesheet redSheet = new Spritesheet("resources/text (red).png");
  private Spritesheet yellowSheet = new Spritesheet("resources/text (yellow).png");
  private Spritesheet wingdingsSheet = new Spritesheet("resources/wingdings.png");
  private Spritesheet chickenScratchSheet = new Spritesheet("resources/bad handwriting (white).png");
  private Spritesheet rainbowSheet = new Spritesheet("resources/text (rainbow).png");
  private Spritesheet greenSheet = new Spritesheet("resources/text (lime green).png");
  
  public Sprite font = new Sprite(textSheet, 8, 8);
  public Sprite greenFont = new Sprite(greenSheet, 8, 8);
  public Sprite blueFont = new Sprite(blueSheet, 8, 8);
  public Sprite redFont = new Sprite(redSheet, 8, 8);
  public Sprite yellowfont = new Sprite(yellowSheet, 8, 8);
  public Sprite wingdings = new Sprite(wingdingsSheet, 8, 8);
  public Sprite chickenScratch = new Sprite(chickenScratchSheet, 8, 8);
  public Sprite rainbowfont = new Sprite(rainbowSheet, 8, 8);
  public Sprite selector = new Sprite("resources/selector.png");
  
  public SpriteContainer() {}
}
