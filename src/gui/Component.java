package gui;

import java.awt.Graphics;
import java.util.ArrayList;

public class Component {
	public final void paint(Graphics g) {
		for(Component c : children) {
			c.paint(g);
		}
		
		draw(g);
	}
	
	public void draw(Graphics g) {
		
	}
	
	public void add(Component e) {
		children.add(e);
	}
	
	ArrayList<Component> children = new ArrayList<Component>();
}
