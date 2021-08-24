package frogger;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Car extends Sprite {
	
	Image aquaLeft;
	Image aquaRight;
	Image blueLeft;
	Image blueRight;
	Image greenLeft;
	Image greenRight;
	Image redLeft;
	Image redRight;
	int x;
	int y;
	int dx;
	public enum Orientation {
		RIGHT,
		LEFT
	}
	public enum Color {
		AQUA,
		BLUE,
		RED,
		GREEN
	}
	Orientation direction;
	Color color;
	
	public Car() {
		aquaLeft = loadImage("aqua-car-left.png");
		aquaRight = loadImage("aqua-car-right.png");
		greenLeft = loadImage("green-car-left.png");
		greenRight = loadImage("green-car-right.png");
		redLeft = loadImage("red-car-left.png");
		redRight = loadImage("red-car-right.png");
		blueLeft = loadImage("blue-car-left.png");
		blueRight = loadImage("blue-car-right.png");
		double random = Math.random();
		if (random < 0.5) {
			direction = Orientation.RIGHT;
			x = 10;
			y = 405;
			dx = 20;
		} else {
			direction = Orientation.LEFT;
			x = 720;
			y = 495;
			dx = -20;
		}
		if (random < 0.25) {
			color = Color.AQUA;
		} else if (random < 0.5 && random >= 0.25) {
			color = Color.BLUE;
		} else if (random < 0.75 && random >= 0.5) {
			color = Color.RED;
		} else if (random >= 0.75) {
			color = Color.GREEN;
		}
		
	}
	
	@Override
	void update() {
		x += dx;
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
		switch (color) {
		case AQUA: 
			if (direction == Orientation.RIGHT) {
				g.drawImage(aquaRight, x, y, null);
			} else {
				g.drawImage(aquaLeft, x, y, null);
			}
			break;
		case BLUE:
			if (direction == Orientation.RIGHT) {
				g.drawImage(blueRight, x, y, null);
			} else {
				g.drawImage(blueLeft, x, y, null);
			}
			break;
		case GREEN:
			if (direction == Orientation.RIGHT) {
				g.drawImage(greenRight, x, y, null);
			} else {
				g.drawImage(greenLeft, x, y, null);
			}
			break;
		case RED:
			if (direction == Orientation.RIGHT) {
				g.drawImage(redRight, x, y, null);
			} else {
				g.drawImage(redLeft, x, y, null);
			}
			break;
		}
		
	}

}
