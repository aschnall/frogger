package frogger;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.Timer;

import frogger.Frog.Orientation;

public class View extends JPanel {
	
	final int PANEL_HEIGHT = 600;
	final int PANEL_WIDTH = 800;
	int score;
	int highScore;
	Background bground;
	Frog frog;
	Cast cast;
	
	public View() {
		this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		setFocusable(true);
		bground = new Background();
		frog = new Frog();
		cast = new Cast();
		int highScore = 0;
	} 
	
	public void checkIntersect() {
		boolean isOnLog = false;
		Rectangle frogRect = new Rectangle(frog.x, frog.y, 30, 23);
		if (frog.y < 255 && frog.y > 5) {
			for (int i = 0; i < cast.logs.size(); i++) {
				Log currLog = cast.logs.get(i);
				Rectangle logRect = new Rectangle(currLog.x, currLog.y, currLog.width, currLog.height);
				if (frogRect.intersects(logRect)) {
					frog.x += currLog.dx;
					isOnLog = true;
				}
			}
			if (!isOnLog) {
				frog.direction = Orientation.SPLAT;
				frog.alive = false;
			}
		}
		for (Car car : cast.cars) {
			Rectangle carRect = new Rectangle(car.x, car.y, 74, 37);
			if (frogRect.intersects(carRect)) {
				frog.direction = Orientation.SPLAT;
				frog.alive = false;
			}
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.white);
		g.setColor(Color.black);
		g.drawString("High Score:" + highScore, PANEL_WIDTH - 185, 30);
		g.drawString("Score:" + score, PANEL_WIDTH - 80, 30);
		bground.draw(g, PANEL_WIDTH, PANEL_HEIGHT);
		cast.updateLogs(g);
		frog.draw(g);
		cast.updateCars(g);
		if (frog.alive == false) {
			g.setColor(Color.black);
			g.drawString("Hit up arrow to play again", PANEL_WIDTH/3+30, 30);
		}
	}

}
