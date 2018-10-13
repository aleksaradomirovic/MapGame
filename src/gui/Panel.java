package gui;

import java.awt.Color;
import java.awt.Graphics;

public class Panel extends Component {
	int x,y,w,h;
	Color background = new Color(100,100,100);
	
	public Panel(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		w = width;
		h = height;
	}
	
	public void setColor(Color e) {
		background = e;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(background);
		g.fillRect(x, y, w, h);
	}
}
