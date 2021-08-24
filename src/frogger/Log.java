package frogger;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;


public class Log extends Sprite {
	
	int x;
	int y;
	int width;
	int height;
	int dx;
	
	String size;
	
	
	public Log(String size) {
		this.size = size;
		switch (size) {
		case "small":
			dx = 5;
			y = 195;
			x = -80;
			width = 75;
			height = 30;
			break;
		case "medium":
			dx = 7;
			y = 70;
			x = -115;
			width = 115;
			height = 30;
			break;
		case "large":
			dx = -10;
			y = 130;
			x = 810;
			width = 200;
			height = 30;
			break;
		}
	}
	
	@Override
	public void update() {
		x += dx;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(new Color(102, 51, 0));
		switch (size) {
		case "small":
			g.fillRect(x, y, width, height);
			break;
		case "medium":
			g.fillRect(x, y, width, height);
			break;
		case "large":
			g.fillRect(x, y, width, height);
			break;
		}
	}

}
