package br.com.cod3r.cm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import campo_minado.br.com.cod3r.cm.excecao.ExplosaoException;
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
	@Test
	void testeValorPadraoAtributoMarcado() {
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacao() {
		campo.aternarMarcacao();
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacaoDuasChamadas() {
		campo.aternarMarcacao();
		campo.aternarMarcacao();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAbriNaoMinadoNaoMarcado() {
		assertTrue(campo.abrir());
	}
	
	@Test
	void testeAbriNaoMinadoMarcado() {
		campo.aternarMarcacao();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbriMinadoMarcado() {
		campo.aternarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());
	}
	
	// Esse é o teste que acontece a explosão
	@Test
	void testeAbriMinadoNaoMarcado() {
		campo.minar();
		
		assertThrows(ExplosaoException.class, () -> {
			campo.abrir();
		});
		
	}
	
	@Test
	void testeAbriComVizinhos1() {

		Campo campo11 = new Campo(1, 1);
		Campo campo22 = new Campo(2, 2);
		campo22.adicionarVizinho(campo11);
		
		campo.adicionarVizinho(campo22); 
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isAberto());
	}
	
	@Test
	void testeAbriComVizinhos2() {

		Campo campo11 = new Campo(1, 1);
		Campo campo12 = new Campo(1, 1);
		campo12.minar();
		
		Campo campo22 = new Campo(2, 2);
		campo22.adicionarVizinho(campo11);
		campo22.adicionarVizinho(campo12);
		
		campo.adicionarVizinho(campo22); 
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isFechado());
	}
}
