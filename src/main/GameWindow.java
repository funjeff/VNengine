package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class GameWindow extends JFrame
{
  boolean[] keysPressed;
  boolean[] keysPressedOnFrame;
  boolean[] keysReleasedOnFrame;
  BufferedImage bufferImage;
  BufferedImage consoleImage;
  Graphics bufferGraphics;
  Insets insets;
  int numtest = 0;
  int[] resolution = { 640, 480 };
  int[] mouseCoords = null;
  private static InputManager manager;
  public GameWindow() {
    bufferImage = new BufferedImage(640, 480, 2);
    manager = new InputManager (this,this.getContentPane());
    consoleImage = new BufferedImage(640, 480, 1);
    keysPressed = new boolean[256]; //Array for tracking which keys are down
	keysPressedOnFrame = new boolean[256]; //Array for tracking which keys have just been pressed
	keysReleasedOnFrame = new boolean[256]; //Array for tracking which keys have just been released
    bufferGraphics = bufferImage.getGraphics();
    
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    pack();
    insets = getInsets();
    this.getContentPane().setSize(640 + insets.left + insets.right, 480 + insets.top + insets.bottom);
    setSize(640 + insets.left + insets.right, 480 + insets.top + insets.bottom);
    setVisible(true);
    
    KeyboardFocusManager keyboardFocusManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
    keyboardFocusManager.addKeyEventDispatcher(new KeyEventDispatcher()
    {
      public boolean dispatchKeyEvent(KeyEvent e) {
        if ((e.getID() == 401) && 
          (e.getKeyCode() <= 255)) {
          keysPressed[e.getKeyCode()] = true;
          keysPressedOnFrame[e.getKeyCode()] = true;
        }
        
        if (e.getID() == 402) {
          keysPressed[e.getKeyCode()] = false;
          keysReleasedOnFrame[e.getKeyCode()] = true;
        }
        return false;
      }
    });
  }
  
  public void doPaint() {
    Graphics g = getGraphics();
    if ((bufferImage != null) && 
      (bufferGraphics != null)) {
      g.drawImage(bufferImage, insets.left, insets.top, getContentPane().getWidth(), getContentPane().getHeight(), null);
    }
    
    int[] usedResolution = getResolution();
    bufferGraphics.setColor(new Color(0));
    
    bufferGraphics.fillRect(0, 0, bufferImage.getWidth() - 1, bufferImage.getHeight() - 1);
  }
  
	public InputManager getManager () {
		return manager;
		
	}

  public void clearKeyArrays()
  {
    for (int i = 0; i < 256; i++) {
      keysPressedOnFrame[i] = false;
      keysReleasedOnFrame[i] = false;
    }
  }
  
  public boolean keyCheck(int keyCode) { if ((keyCode > 0) && (keyCode <= 255)) {
      return keysPressed[keyCode];
    }
    return false;
  }
  
  public boolean keyPressed(int keyCode) {
    if ((keyCode > 0) && (keyCode <= 255)) {
      return keysPressedOnFrame[keyCode];
    }
    return false;
  }
  
  public boolean keyReleased(int keyCode) {
    if ((keyCode > 0) && (keyCode <= 255)) {
      return keysReleasedOnFrame[keyCode];
    }
    return false;
  }
  
  public boolean[] KeysPressed() {
    return keysPressed;
  }
  
  public Graphics getBuffer() { return bufferGraphics; }
  

  public int[] getResolution() { return resolution; }
  
  public void setResolution(int width, int height) {
    int[] usedResolution = { width, height };
    resolution = usedResolution;
    bufferImage = new BufferedImage(width, height, 2);
  }
  public void resetInputBuffers () {
		manager.resetKeyBuffers ();
		manager.resetMouseBuffers ();
	}
}
