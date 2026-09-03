package campo_minado.br.com.cod3r.cm.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Tabuleiro {

	private int linhas;
	private int colunas;
	private int minas;
	
	private final List<Campo> campos = new ArrayList<Campo>();
	
	public Tabuleiro(int linhas, int colunas, int minas) {
		this.linhas = linhas;
		this.colunas = colunas;
		this.minas = minas;
		
		// Os dois primeiros serão chamados apenas uma vez, menos o sortear minas
		gerarCampo();
		associarVizinhos();
		sortearMinas(); // sempre que reiniciar o jogo esse será chamado
	}

	// Ele pega todas as linhas e colunas e cria os campos e joga na lista
	private void gerarCampo() {
		for (int linha = 0; linha < linhas; linha++) {
			for (int campo = 0; campo < colunas; campo++) {
				campos.add(new Campo(linha, campo));
			}
		}
	}
	
	// Aqui ele corre a lista para fazer a associação entre os vizinhos
	private void associarVizinhos() {
		for (Campo c1: campos) {
			for (Campo c2: campos) {
				c1.adicionarVizinho(c2);
			}
		}
	}
	
	private void sortearMinas() {
		long minasArmadas = 0;
		Predicate<Campo> minado = c -> c.isMinado();
		
		do {
			minasArmadas = campos.stream().filter(minado).count();
			int aleatorio = (int) (Math.random() * campos.size());
			campos.get(aleatorio).minar();
		} while(minasArmadas < minas);
	} // Esse (int) é um cache para transformar o número aleatório em int
	
	public boolean objetivoAlcancado() {
		return campos.stream().allMatch(c -> c.objetivoAlcancado());
	}
	
	// Reiniciar o jogo
	public void reiniciar() {
		campos.stream().forEach(c -> c.reiniciar());
		sortearMinas();
	}
	
	
}
