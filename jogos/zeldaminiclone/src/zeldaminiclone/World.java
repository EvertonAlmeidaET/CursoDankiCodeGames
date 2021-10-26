package zeldaminiclone;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class World {
	
	private static List<Blocks> BLOCOS = new ArrayList<>();
	
	public static boolean isFree(int x, int y) {
		for(Blocks blocoAtual : BLOCOS) {
			if(blocoAtual.intersects(new Rectangle(x, y, 32, 32))) {
				return false;
			}
		}
		
		return true;
	}
	
	public World() {
		// EIXO X NA PARTE DE CIMA E BAIXO
		for(int xx = 0; xx < 20; xx++) {
			BLOCOS.add(new Blocks(xx*32, 480-32));
			BLOCOS.add(new Blocks(xx*32, 0));
		}
		
		// EIXO Y DO LADO DIREITO E ESQUERDO
		for(int yy = 0; yy < 15; yy++) {
			BLOCOS.add(new Blocks(640-32, yy*32));
			BLOCOS.add(new Blocks(0, yy*32));
		}
	}
	

	public void render(Graphics g) {
		for(Blocks bloco : BLOCOS) {
			bloco.render(g);
		}
		
	}


	public static List<Blocks> getBlocos() {
		return World.BLOCOS;
	}
}
