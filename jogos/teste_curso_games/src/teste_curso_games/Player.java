package teste_curso_games;

public class Player {
	
	private int vida = 10;
	private String nome = "Everton";
	
	public void perderVida() {
		vida--;
	}
	
	public void ganharVida() {
		vida++;
	}
	
	public int getVida() {
		return this.vida;
	}
	
	public void setVida(int vida) {
		this.vida = vida;
	}
	

}
