package GameShapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;

import javax.swing.JFrame;

public class Paddle {

	private int x;
	private int y;
	public MouseEvent e;
	private int PADDLE_WIDTH = 200;
	private int PADDLE_HEIGHT = 10;
	private Color PADDLE_COLOR = Color.black;
	private long TIME_DELAY = 2;
	private int SCREEN_WIDTH, SCREEN_HEIGHT;
	public boolean mouseMoved;

	public Paddle(int x, int y, JFrame j) {

		// this.x = x;
		this.y = y;
		SCREEN_WIDTH = j.getWidth();
		SCREEN_HEIGHT = j.getHeight();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int position) {
		this.x = position;
	}

	public int getWIDTH() {
		return PADDLE_WIDTH;
	}

	public int getHEIGHT() {
		return PADDLE_HEIGHT;
	}

	public void Paint(Graphics g) {

		Graphics2D gp = (Graphics2D) g;
		gp.setColor(PADDLE_COLOR);
		gp.fillRoundRect((int) x, y, PADDLE_WIDTH, PADDLE_HEIGHT, 10, 10);
	}

	public void movePaddle(JFrame j) {
		j.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				setX(e.getX());
			}
		});

	}
}
