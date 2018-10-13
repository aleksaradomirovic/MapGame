package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends Panel {
	String text;
	final Font basic = new Font("Arial", Font.PLAIN, 10);
	public Button(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(x, y, w-1, h-1);
		g.setFont(basic);
		if(text != null) g.drawString(text, (int) ((x+(w/2))-(text.length()*2.5)), y+(h/2)+3);
	}
	
	public void setText(String t) {
		text = t;
	}
	
	public ActionListener effect;
	
	@Override
	public boolean click(int x, int y) {
		if(x>this.x && y > this.y && y < this.y+h && x < this.x+w) {
			System.out.println("Clicked");
			if(effect != null) effect.actionPerformed(null);
			return true;
		}
		return false;
	}
}
