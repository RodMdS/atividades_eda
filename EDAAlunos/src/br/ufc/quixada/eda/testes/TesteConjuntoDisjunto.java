package br.ufc.quixada.eda.testes;

import java.io.IOException;

import br.ufc.quixada.eda.algoritmos.ArvoreGeradoraMinima;
import br.ufc.quixada.eda.grafos.Aresta;
import br.ufc.quixada.eda.grafos.Grafo;
import br.ufc.quixada.eda.util.CriarInstancia;
import br.ufc.quixada.eda.util.EDAConstants;
import br.ufc.quixada.eda.util.EDAUtil;

public class TesteConjuntoDisjunto {

	public static void main(String args[]){
		try {
			for (int tamanho : CriarInstancia.tamanhoInstancias) {
				for(int i = 0; i < 4; i++) {
					String arquivo = "tb8ch" + tamanho + "_" + i + ".txt";
					String path = EDAConstants.caminhoPasta + arquivo;
					
					Grafo g = EDAUtil.getGrafo(path);
					
					long tempoInicial = System.currentTimeMillis();				
					ArvoreGeradoraMinima arvore = new ArvoreGeradoraMinima();

					int somaArestas = 0;
					for(Aresta a : arvore.kruskal(g)){
						somaArestas += a.getCusto();
					}

					long tempo = System.currentTimeMillis() - tempoInicial;
					System.out.println(arquivo + " " + somaArestas + " " + tempo);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
