package gui;

import java.awt.Graphics;
import java.util.ArrayList;

public class Component {
	void draw(Graphics g) {
		for(Component c : children) {
			c.draw(g);
		}
	}
	
	void add(Component e) {
		children.add(e);
	}
	
	ArrayList<Component> children = new ArrayList<Component>();
}
