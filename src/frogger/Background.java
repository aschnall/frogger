package frogger;

import java.awt.Color;
import java.awt.Graphics;

public class Background {

	public void draw(Graphics g, int width, int height) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 7*height/12, width, 4*height/12);
		g.setColor(Color.yellow);
		g.drawLine(0, 3*height/4, width, 3*height/4);
		g.setColor(Color.BLUE);
		g.fillRect(0, 1*height/12, width, 4*height/12);
//		g.setColor(new Color(152,103,0));
//		g.fillRect(0, 5*height/12, width, height/15);
//		g.fillRect(0, 7*height/12, width, height/15);
	}
}
