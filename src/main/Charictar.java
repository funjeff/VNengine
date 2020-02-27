package main;

import resources.Sprite;

public class Charictar {
	private Sprite expression;
	private int x;
	private int y;
	private boolean hide;
	public Charictar (String startingExpresion) {
		expression = new Sprite (startingExpresion);
		x = 50;
		y = 0;
		hide = false;
	}
	public Sprite getExpression () {
		return expression;
	}
	public void hide () {
		hide = true;
	}
	public void show () {
		hide = false;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setExpression (String newExpression) {
		expression =new Sprite (newExpression);
	}
	public void setX(int newX) {
		x = newX;
	}
	public void setY(int newY) {
		y = newY;
	}
	public void drawEvent () {
		if (!hide) {
		expression.draw(x,y);
		}
	}
}
