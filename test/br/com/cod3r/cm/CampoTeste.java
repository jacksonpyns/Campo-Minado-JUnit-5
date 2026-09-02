package br.com.cod3r.cm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import campo_minado.br.com.cod3r.cm.modelo.Campo;

public class CampoTeste {

	private Campo campo;
	
	@BeforeEach // Para cada um dos métodos execute essa função
	void iniciarCampo() {
		campo = new Campo(3, 3);
	}
		
	@Test // Para fazer um teste se está funcional
	void testeVizinhoDistanciaEsquerdo() {
		Campo vizinhoEsquerdo = new Campo(3, 2);
		boolean resultadoEsquerdo = campo.adicionarVizinho(vizinhoEsquerdo);
		assertTrue(resultadoEsquerdo);
	}
	
	@Test
	void testeVizinhoDistanciaDireita() {
		Campo vizinhoDireita = new Campo(3, 4);
		boolean resultadoDireita = campo.adicionarVizinho(vizinhoDireita);
		assertTrue(resultadoDireita);
	}
	
	@Test
	void testeVizinhoDistanciaEmCima() {
		Campo vizinhoEmCima = new Campo(2, 3);
		boolean resultadoEmCima = campo.adicionarVizinho(vizinhoEmCima);
		assertTrue(resultadoEmCima);
	}
		
	@Test
	void testeVizinhoDistanciaEmBaixo() {
		Campo vizinhoEmBaixo = new Campo(4, 3);
		boolean resultadoEmBaixo = campo.adicionarVizinho(vizinhoEmBaixo);
		assertTrue(resultadoEmBaixo);
	}
	
	@Test
	void testeVizinhoDistancia2() {
		Campo vizinho = new Campo(2, 2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeNaoVizinho() {
		Campo vizinho = new Campo(1, 1);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertFalse(resultado);
	}
}
