package gui;

import java.awt.Graphics;
import java.util.ArrayList;

public class Component {
	boolean visible = false;
	public final void paint(Graphics g) {
		if(visible) {
			draw(g);
			for(Component c : children) {
				c.paint(g);
			}
		}
	}
	
	public void draw(Graphics g) {
		
	}
	
	public void add(Component e) {
		children.add(e);
	}
	
	public boolean click(int x, int y) {
		for(Component c : children) {
			if(c.click(x,y)) return true;
		}
		
		return false;
	}
	
	public void setVisible(boolean b) {
		visible = b;
		for(Component c : children) {
			c.setVisible(b);
		}
	}
	
	ArrayList<Component> children = new ArrayList<Component>();
}
