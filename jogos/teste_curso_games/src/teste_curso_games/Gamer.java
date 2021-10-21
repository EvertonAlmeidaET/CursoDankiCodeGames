package teste_curso_games;

import java.util.ArrayList;
import java.util.List;

public class Gamer {
	
	public static void main(String[] args) {
		
		Player player = new Player();
		ElfiInimigo elf = new ElfiInimigo(10);
		List<Inimigo> inimigos = new ArrayList<Inimigo>();
		
		inimigos.add(new ElfiInimigo(100));
		inimigos.add(new ElfiInimigo(100));
		inimigos.add(new ElfiInimigo(100));
		inimigos.add(new ElfiInimigo(100));
		inimigos.add(new ElfiInimigo(100));
		
		inimigos.get(0).tomarDano();
		
		System.out.println(inimigos.get(0).getVida());
		
		for (int i = 0; i < inimigos.size(); i++) {
			Inimigo inimigoLocal = inimigos.get(i);
			if(i == 1) {
				inimigoLocal.tomarDano();
				System.out.println(inimigoLocal.getVida());
			} else {
				System.out.println(inimigoLocal.getVida());
			}
		}
		
		
//		System.out.println(player.getVida());
//		
//		player.perderVida();
//		player.perderVida();
//		
//		player.ganharVida();
//		
//		System.out.println(player.getVida());
//		
//		elf.tomarDano();
//		
//		System.out.println(elf.getVida());
	}
}
