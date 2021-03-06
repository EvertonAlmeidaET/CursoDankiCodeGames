package zeldaminiclone;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Player extends Rectangle {
	
	private int spd = 4;
	
	private boolean right, up, down, left;
	
	private int curAnimation = 0;
	private int curFrames = 0;
	private int targetFrame = 15;
	private boolean shoot = false;
	private int dir = 1;
	
	private static List<Bullet> BULLETS = new ArrayList<>();
	
	public Player(int x, int y) {
		super(x, y, 32, 32);
	}
	
	public void tick() {
		boolean move = false;
		if(this.right && World.isFree(x+spd, y)) {
			x+=this.spd;
			move = true;
			dir = 1;
		} else if(this.left && World.isFree(x-spd, y)) {
			x-=this.spd;
			move = true;
			dir = -1;
		}
		
		if(this.up && World.isFree(x, y-spd)) {
			y-=this.spd;
			move = true;
		} else if(this.down && World.isFree(x, y+spd)) {
			y+=this.spd;
			move = true;
		}
		
		if(move) {
			this.curFrames++;
			if(curFrames == targetFrame) {
				curFrames = 0;
				curAnimation++;
				if(curAnimation == Spritesheet.getPLAYER_FRONT().length) {
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
//		g.setColor(Color.blue);
//		g.fillRect(x, y, width, height);
		g.drawImage(Spritesheet.getPLAYER_FRONT()[this.curAnimation], x, y, 32, 32, null);
		
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
