package teste_curso_games;

public class Introducao {
	
	public static void main(String args[]) {
		
		System.out.println("Hello world!");
		
		String nome = "Everton";
		int idade = 28;
		boolean tipo = true;
		double peso = 90.0;
		int contador = 0;
		
		System.out.println(nome);
		System.out.println("A idade �: " + idade);
		System.out.println("O peso �: " + peso);
		
		if(idade < 28) {
			System.out.println("A idade � 28!");
		} else {
			System.out.println("A idade correta � " + idade);
		}
		
		if(nome.equals("Everton")) {
			System.out.println("verdade");
		}
		
		while(contador <= 10) {
			System.out.println("O numero atual �: " + contador);
			contador++;
		}
		
		System.out.println("===================");
		
		for(int i = 2; i <= 10; i+=2) {
			System.out.println("o numero atual de i �: " + i);
		}
	}
	
}
