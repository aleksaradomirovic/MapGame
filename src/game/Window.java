package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import gui.Button;
import gui.Component;
import gui.Panel;

public class Window extends JPanel implements ActionListener {
	JFrame frame = new JFrame();
	Timer drawTimer = new Timer(1,this);
	static Dimension screen = new Dimension(1280,800);
	Input per = new Input(this);
	ArrayList<Component> gui = new ArrayList<Component>();
	
	void start() {
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(screen);
		
		frame.addKeyListener(per);
		frame.addMouseListener(per);
		
		setupWindow(title, title_main);
		
		frame.pack();
		frame.setResizable(false);
		drawTimer.start();
		frame.setVisible(true);
	}
	
	void setupWindow(int mode, int submode) {
		gui.clear();
		if(mode == title) {
			if(submode == title_main) {
				gui.add(new Panel(screen.width/2-100,screen.height/2-200,200,400));
				Button b = new Button(screen.width/2-100,screen.height/2-200,200,50);
				b.setText("Play");
				b.effect = new PlayHandle();
				gui.get(0).add(b);
				gui.get(0).setVisible(true);
			}
			if(submode == title_play) {
				System.out.println("playtitle");
				Panel p = new Panel(100, 100, screen.width-200, screen.height-200);
				Button b = new Button(screen.width-200,screen.height-150,100,50);
				b.setText("Play");
				b.effect = new StartGame();
				p.add(b);
//				p.setColor(Color.BLACK);
				p.setVisible(true);
				gui.add(p);
			}
		}
		if(mode == game) {
			
		}
		this.mode = mode;
		this.titlemode = submode;
	}
	
	void click(int x, int y) {
		for(Component c : gui) {
			if(c.click(x, y)) return;
		}
	}
	
	static int mode = 0, titlemode = 0;
	static final int title = 0, game = 1;
	static final int title_main = 0, title_play = 1;
	
	void draw(Graphics g) {
		for(Component c : gui) {
			c.paint(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		draw(g);
//		System.out.println("drew");
	}
	
	public class PlayHandle implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			setupWindow(title, title_play);
		}
	}
	
	public class StartGame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			setupWindow(game,0);
		}
	}
}
