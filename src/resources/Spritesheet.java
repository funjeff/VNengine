package resources;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import main.MainLoop;

public class Spritesheet
{
  private BufferedImage img;
  private int width;
  private int height;
  
  public Spritesheet(String filepath)
  {
    try
    {
      img = javax.imageio.ImageIO.read(new java.io.File(filepath));
    } catch (IOException e) {
      e.printStackTrace();
    }
    width = img.getWidth();
    height = img.getHeight();
  }
  
  public BufferedImage getImage() { return img; }
  
  public void draw(int x, int y) {
    Graphics bufferImage = MainLoop.getWindow().getBuffer();
    if (bufferImage != null)
      bufferImage.drawImage(img, x, y, null); }
  
  public void draw(int x, int y, boolean flipHorizontal, boolean flipVertical) { 
    int x1;
    int x2;
    if (flipHorizontal) {
      x1 = width;
      x2 = 0;
    } else {
      x1 = 0;
      x2 = width; }
    int y2;
    int y1; 
    if (flipVertical) {
      y1 = height;
      y2 = 0;
    } else {
      y1 = 0;
      y2 = height;
    }
    Graphics bufferImage = MainLoop.getWindow().getBuffer();
    if (bufferImage != null)
      bufferImage.drawImage(img, x, y, x + width, y + height, x1, y1, x2, y2, null);
  }
  
  public Sprite[] toSpriteArray(int width, int height) {
    int sheetWidth = getWidth();
    int sheetHeight = getHeight();
    Sprite[] imageArray = new Sprite[(int)(Math.floor(sheetHeight / height) * Math.floor(sheetWidth / width))];
    for (int i = 0; i < Math.floor(sheetHeight / height); i++) {
      for (int c = 0; c < Math.floor(sheetWidth / width); c++) {
        imageArray[(i * (sheetWidth / width) + c)] = new Sprite(getImage().getSubimage(c * width, i * height, width, height));
      }
    }
    return imageArray;
  }
  
  public int getWidth() { return width; }
  
  public int getHeight() {
    return height;
  }
}
