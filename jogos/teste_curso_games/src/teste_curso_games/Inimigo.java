package teste_curso_games;

public class Inimigo {
	
	private int vida = 0;
	private String inimigoTipo = "tipo1";
	private int ataqueDano = 10;
	
	public Inimigo(int vida) {
		this.vida = vida;
	}
	
	
	public int getVida() {
		return this.vida;
	}
	
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public void tomarDano() {
		this.vida--;
	}
	
	
	

}
