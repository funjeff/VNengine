package main;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * A class containing useful IO methods
 * @author nathan
 * (modified by Jeffrey to fit the needs of this engine)
 */
public abstract class GameAPI {
	
	
	/**
	 * Makes a deep copy of the given LinkedList of characters.
	 * @param keys The list to copy
	 * @return A copy of the original list
	 */
	private static LinkedList<Character> cloneKeyList (LinkedList<Character> keys) {
		LinkedList<Character> copy = new LinkedList<Character> ();
		Iterator<Character> iter = keys.iterator ();
		while (iter.hasNext ()) {
			copy.add (new Character (iter.next ()));
		}
		return copy;
	}

	/**
	 * Returns true if the key with the given character code was pressed down since the last call to resetKeyBuffers().
	 * @param charCode The character code to check for
	 * @return Whether the given key was pressed
	 */
	public static boolean keyPressed (int charCode) {
		return MainLoop.getManager ().keyPressed (charCode);
	}
	
	/**
	 * Returns true if the key with the given character code was released since the last call to resetKeyBuffers().
	 * @param charCode The character code to check for
	 * @return Whether the given key was released
	 */
	public static boolean keyReleased (int charCode) {
		return MainLoop.getManager ().keyReleased (charCode);
	}
	
	/**
	 * Returns true if the key with the given character code is currently being pressed down.
	 * @param charCode The character code to check for
	 * @return Whether the given key is pressed down
	 */
	public static boolean keyDown (int charCode) {
		return MainLoop.getManager ().keyDown (charCode);
	}
	
	/**
	 * Gets a list of the keys currently pressed down, sorted from lowest to highest character code.
	 * @return A char[] representing all the keys currently pressed down
	 */
	public static char[] getKeysDown () {
		return MainLoop.getManager ().getKeysDown ();
	}
	
	/**
	 * Gets a list of all the keys events fired since the last call to resetKeyBuffers() in the order they were pressed.
	 * @return A LinkedList representing all of the key events
	 */
	public static LinkedList<KeyEvent> getKeyEvents () {
		return MainLoop.getManager ().getKeyEvents ();
	}
	
	/**
	 * Gets a list of the text typed since the last call to resetKeyBuffers(); responds to key combinations.
	 * @return The text typed since calling resetKeyBuffers
	 */
	public static String getTyped () {
		return MainLoop.getManager ().getTyped ();
	}
	
	/**
	 * Returns true if the given mouse button was clicked.
	 * @param button The mouse button to check
	 * @return Whether the button is clicked
	 */
	public static boolean mouseButtonClicked (int button) {
		return MainLoop.getManager ().mouseButtonClicked (button);
	}
	public static boolean mouseButtonPressed(int button) {
		return MainLoop.getManager().mouseButtonPressed(button);
	}
	/**
	 * Returns true if the given mouse button was released.
	 * @param button The mouse button to check
	 * @return Whether the button was released
	 */
	public static boolean mouseButtonReleased (int button) {
		return MainLoop.getManager ().mouseButtonReleased (button);
	}
	
	/**
	 * Returns true if the given mouse button is held down.
	 * @param button The mouse button to check
	 * @return Whether the button is held down
	 */
	public static boolean mouseButtonDown (int button) {
		return MainLoop.getManager ().mouseButtonDown (button);
	}
	
	/**
	 * Gets the current x-coordinate of the mouse cursor.
	 * @return The cursor x-coordinate
	 */
	public static int getCursorX () {
		return (int) (MainLoop.getManager ().getCursorX () * MainLoop.getWindow().getResolution () [0]);
	}
	
	/**
	 * Gets the current y-coordinate of the mouse cursor.
	 * @return The cursor y-coordinate
	 */
	public static int getCursorY () {
		return (int) (MainLoop.getManager ().getCursorY () * MainLoop.getWindow().getResolution () [1]);
	}
	
	/**
	 * Gets a list of all the mosue events fired since the last call to resetKeyBuffers() in the order they were pressed.
	 * @return A LinkedList representing all of the recent mouse events
	 */
	public static LinkedList<MouseEvent> getMouseEvents () {
		return MainLoop.getManager ().getMouseEvents ();
	}
	
	/**
	 * Gets the game's window
	 * @return The GameWindow object for displaying the game
	 */
	public static GameWindow getWindow () {
		return MainLoop.getWindow();
	}
}
