package zeldaminiclone;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends Rectangle{
	
	private int dir = 1;
	private int speed = 8;
	private int frames = 0;
	
	public Bullet(int x, int y, int dir) {
		super(x+16, y+16, 10, 10);
		this.dir = dir;
	}
	
	public void tick() {
		x+=speed*dir;
		this.frames++;
		if(this.frames == 60) {
			if(!Player.getBULLETS().isEmpty()) {
				Player.getBULLETS().remove(this);
				return;
			}
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(x,  y, width, height);
	}

}
