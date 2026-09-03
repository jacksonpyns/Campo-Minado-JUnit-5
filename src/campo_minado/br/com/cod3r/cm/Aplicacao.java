package campo_minado.br.com.cod3r.cm;

import campo_minado.br.com.cod3r.cm.modelo.Tabuleiro;
import campo_minado.br.com.cod3r.cm.visao.TabuleiroConsole;

public class Aplicacao {

	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
		new TabuleiroConsole(tabuleiro);
		
	}
}
