package zeldaminiclone;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;


public class Game extends Canvas implements Runnable, KeyListener{
	
	public static int WIDTH = 640, HEIGHT = 480;
	public static int SCALE = 3;
	
	Player player;
	World world;
	
	public List<Inimigo> inimigos = new ArrayList<>();
	
	public Game() {
		this.addKeyListener(this);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		new Spritesheet();
		this.player = new Player(32, 32);
		world = new World();
		inimigos.add(new Inimigo(32, 32));
		
	}
	
	public void tick(){
		player.tick();
		
		for (int i = 0; i < inimigos.size(); i++) {
			inimigos.get(i).tick();
		}
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(new Color(0, 135, 13));
		g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
		
		
		player.render(g);
		
		for (int i = 0; i < inimigos.size(); i++) {
			inimigos.get(i).render(g);
		}
		
		world.render(g);
		
		bs.show();
		
		
		
	}
	
	public static void main(String[] args) {
		Game gameInicio = new Game();
		JFrame frame = new JFrame();
		frame.add(gameInicio);
		frame.setTitle("Mini Zelda");
		frame.setLocationRelativeTo(null);
		frame.pack();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		
		new Thread(gameInicio).start();
		
	}
	
	@Override
	public void run() {
		
		while(true) {
			System.out.println("chamando game looping!");
			tick();
			render();
			try {
				Thread.sleep(1000/60);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if ((e.getKeyCode() == KeyEvent.VK_RIGHT) || (e.getKeyCode() == KeyEvent.VK_D)) {
			player.setRight(true);
		} else if((e.getKeyCode() == KeyEvent.VK_LEFT) || (e.getKeyCode() == KeyEvent.VK_A)) {
			player.setLeft(true);
		}
		
		if ((e.getKeyCode() == KeyEvent.VK_UP) || (e.getKeyCode() == KeyEvent.VK_W)) {
			player.setUp(true);
		} else if((e.getKeyCode() == KeyEvent.VK_DOWN) || (e.getKeyCode() == KeyEvent.VK_S)) {
			player.setDown(true);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_Z) {
			player.setShoot(true);
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		if ((e.getKeyCode() == KeyEvent.VK_RIGHT) || (e.getKeyCode() == KeyEvent.VK_D)) {
			player.setRight(false);
		} else if((e.getKeyCode() == KeyEvent.VK_LEFT) || (e.getKeyCode() == KeyEvent.VK_A)) {
			player.setLeft(false);
		}
		
		if ((e.getKeyCode() == KeyEvent.VK_UP) || (e.getKeyCode() == KeyEvent.VK_W)) {
			player.setUp(false);
		} else if((e.getKeyCode() == KeyEvent.VK_DOWN) || (e.getKeyCode() == KeyEvent.VK_S)) {
			player.setDown(false);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_Z) {
			player.setShoot(true);
		}
		
	}
	
}
