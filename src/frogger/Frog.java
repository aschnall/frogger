package frogger;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Frog extends Sprite {

	Image frogDown;
	Image frogUp;
	Image frogLeft;
	Image frogRight;
	Image frogSplat;
	public boolean alive;
	int x;
	int y;
	int dx;
	int dy;
	public enum Orientation {
		UP,
		RIGHT,
		DOWN,
		LEFT,
		SPLAT
	}
	Orientation direction;
	
	public Frog() {
		alive = true;
		frogDown = loadImage("frog-down.png");
		frogUp = loadImage("frog-up.png");
		frogLeft = loadImage("frog-left.png");
		frogRight = loadImage("frog-right.png");
		frogSplat = loadImage("splat.gif");
		x = 365;
		y = 575;
		dx = 35;
		dy = 35;
		direction = Orientation.UP;
	}
	
	public void reset() {
		x = 365;
		y = 575;
		direction = Orientation.UP;
		alive = true;
	}
	
	@Override
	void update() {
		switch (direction) {
		case UP: 
			if (y < 20) {
				y = 600;
			} else {
				if (y < 340) {
					dy = 65;
				} else {
					dy = 35;
				}
				y-=dy;	
			}
			break;
		case DOWN:
			if (y <= 560) {
				y+=dy;
			}
			break;
		case RIGHT:
			if (x <= 749) {
				x+=dx;
			}
			break;
		case LEFT:
			if (x >= 45) {
				x-=dx;
			}
			break;
		}
	}
	
	private Image loadImage(String fileName) {
		Image img = null;
		try {
			img = ImageIO.read(new File(fileName));
		} catch (IOException exc) {
			System.out.println("Can't load image");
		} 
		return img;
	}

	@Override
	void draw(Graphics g) {
		switch (direction) {
		case UP: 
			g.drawImage(frogUp, x, y, null);
			break;
		case DOWN:
			g.drawImage(frogDown, x, y, null);
			break;
		case RIGHT:
			g.drawImage(frogRight, x, y, null);
			break;
		case LEFT:
			g.drawImage(frogLeft, x, y, null);
			break;
		case SPLAT:
			g.drawImage(frogSplat, x, y, null);
		}
	}


}
