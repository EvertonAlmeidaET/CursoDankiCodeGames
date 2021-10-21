package zeldaminiclone;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Rectangle {
	
	private int spd = 4;
	
	private boolean right, up, down, left;
	
	public Player(int x, int y) {
		super(x, y, 32, 32);
	}
	
	public void tick() {
		if(this.right) {
			x+=this.spd;
		} else if(this.left) {
			x-=this.spd;
		}
		
		if(this.up) {
			y-=this.spd;
		} else if(this.down) {
			y+=this.spd;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);
	}

	public int getSpd() {
		return this.spd;
	}

	public void setSpd(int spd) {
		this.spd = spd;
	}

	public boolean isRight() {
		return this.right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isUp() {
		return this.up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return this.down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isLeft() {
		return this.left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}
	
	

}
