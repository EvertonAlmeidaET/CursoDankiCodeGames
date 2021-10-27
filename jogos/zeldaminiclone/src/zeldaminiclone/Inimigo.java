package zeldaminiclone;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Inimigo extends Rectangle {
	
	private int spd = 4;
	
	private int right = 1, up = 0, down = 0, left = 0;
	
	private int curAnimation = 0;
	private int curFrames = 0;
	private int targetFrame = 15;
	private boolean shoot = false;
	private int dir = 1;
	
	private static List<Bullet> BULLETS = new ArrayList<>();
	
	public Inimigo(int x, int y) {
		super(x, y, 32, 32);
	}
	
	public void tick() {
		boolean move = true;
		if(this.right == 1 && World.isFree(x+spd, y)) {
			x++;
		} 
//		else if(this.left == 0 && World.isFree(x-spd, y)) {
//			x--;
//			move = true;
//			dir = -1;
//		}
		
		if(move) {
			this.curFrames++;
			if(curFrames == targetFrame) {
				curFrames = 0;
				curAnimation++;
				if(curAnimation == Spritesheet.getINIMIGO_FRONT().length) {
					curAnimation = 0;
				}
				
			}
		}
		
		if(this.shoot) {
			shoot = false;
			BULLETS.add(new Bullet(x, y, dir));
		}
		
		for(int i = 0; i < getBULLETS().size(); i++) {
			getBULLETS().get(i).tick();
		}
		
	}
	
	public void render(Graphics g) {

		g.drawImage(Spritesheet.getINIMIGO_FRONT()[this.curAnimation], x, y, 32, 32, null);
		
		for(Bullet bala : BULLETS) {
			bala.render(g);
		}
	}

	public int getSpd() {
		return this.spd;
	}

	public void setSpd(int spd) {
		this.spd = spd;
	}

	public int isRight() {
		return this.right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public int isUp() {
		return this.up;
	}

	public void setUp(int up) {
		this.up = up;
	}

	public int isDown() {
		return this.down;
	}

	public void setDown(int down) {
		this.down = down;
	}

	public int isLeft() {
		return this.left;
	}

	public void setLeft(int left) {
		this.left = left;
	}
	
	public int getCurAnimation() {
		return this.curAnimation;
	}
	
	public void setCurAnimation(int curAnimation) {
		this.curAnimation = curAnimation;
	}

	public int getCurFrames() {
		return this.curFrames;
	}

	public void setCurFrames(int curFrames) {
		this.curFrames = curFrames;
	}

	public int getTargetFrame() {
		return this.targetFrame;
	}

	public void setTargetFrame(int targetFrame) {
		this.targetFrame = targetFrame;
	}

	public boolean getShoot() {
		return this.shoot;
	}

	public void setShoot(boolean shoot) {
		this.shoot = shoot;
	}
	
	public static List<Bullet> getBULLETS() {
		return BULLETS;
	}

}