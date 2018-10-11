package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Window extends JPanel implements ActionListener {
	JFrame frame = new JFrame();
	Timer drawTimer = new Timer(1000/60,this);
	static Dimension screen = new Dimension(800,600);
	Input per = new Input();
	
	void start() {
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(screen);
		
		frame.addKeyListener(per);
		frame.addMouseListener(per);
		
		mode = 0;
		titlemode = 0;
		
		frame.pack();
		frame.setVisible(true);
	}
	
	void setupWindow(int mode, int submode) {
		
	}
	
	void click(int x, int y) {
		if(mode == title && titlemode == title_main) {
			
		}
	}
	
	static int mode = 0, titlemode = 0;
	static final int title = 0, game = 1;
	static final int title_main = 0;
	
	void draw(Graphics g) {
		screen = frame.getSize();
		if(mode == title) {
			g.setColor(Color.GRAY);
			g.fillRect(screen.width/2-100, screen.height/2-200, 200, 400);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		draw(g);
	}
}
