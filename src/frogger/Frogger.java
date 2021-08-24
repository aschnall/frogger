package frogger;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import frogger.Frog.Orientation;


public class Frogger extends JFrame implements ActionListener, KeyListener {
	
	View view;
	
	Frogger() {
		view = new View();
		this.add(view);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null); //allows frame to appear in middle of computer screen
		view.addKeyListener(this);
		Timer timer = new Timer(100, this);
		timer.start();
		this.setVisible(true);
	}
	
	public static void main (String[] args) {
		new Frogger();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		switch (code) {
		case KeyEvent.VK_UP: 
			if (view.frog.direction == Orientation.UP) {
				view.score += 10;
				if (view.score > view.highScore) {
					view.highScore = view.score;
				}
			} else if (view.frog.direction == Orientation.DOWN) {
				if (view.score > 0) {
					view.score -= 10;
				}
			}
			view.frog.update();
			view.repaint();
			break;
		case KeyEvent.VK_DOWN:
			if (view.frog.direction == Orientation.UP) {
				view.frog.direction = Orientation.DOWN;
			} else if (view.frog.direction == Orientation.DOWN) {
				view.frog.direction = Orientation.UP;
			} else if (view.frog.direction == Orientation.RIGHT) {
				view.frog.direction = Orientation.LEFT;
			} else if (view.frog.direction == Orientation.LEFT) {
				view.frog.direction = Orientation.RIGHT;
			}
			view.repaint();
			break;
		case KeyEvent.VK_RIGHT:
			if (view.frog.direction == Orientation.UP) {
				view.frog.direction = Orientation.RIGHT;
			} else if (view.frog.direction == Orientation.DOWN) {
				view.frog.direction = Orientation.LEFT;
			} else if (view.frog.direction == Orientation.LEFT) {
				view.frog.direction = Orientation.UP;
			} else if (view.frog.direction == Orientation.RIGHT) {
				view.frog.direction = Orientation.DOWN;
			}
			view.repaint();
			break;
		case KeyEvent.VK_LEFT:
			if (view.frog.direction == Orientation.UP) {
				view.frog.direction = Orientation.LEFT;
			} else if (view.frog.direction == Orientation.DOWN) {
				view.frog.direction = Orientation.RIGHT;
			} else if (view.frog.direction == Orientation.RIGHT) {
				view.frog.direction = Orientation.UP;
			} else if (view.frog.direction == Orientation.LEFT) {
				view.frog.direction = Orientation.DOWN;
			}
			view.repaint();
			break;
		}
		if (code == KeyEvent.VK_UP && view.frog.alive == false) {
			view.frog.reset();
			view.score = 0;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		view.checkIntersect();
		double random = Math.random();
		if (random < 0.1) {
			view.cast.addCar();
			view.cast.addLog();
		}
		view.repaint();
	}
}
