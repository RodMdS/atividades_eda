package br.ufc.quixada.eda.testes;

import java.io.IOException;
import java.util.List;

import br.ufc.quixada.eda.listaprioridades.LPMaximaNOrdenada;
import br.ufc.quixada.eda.util.CriarInstancia;
import br.ufc.quixada.eda.util.EDAConstants;
import br.ufc.quixada.eda.util.EDAUtil;
import br.ufc.quixada.eda.util.Operacao;

public class TesteListaPrioridadesNOrdenado {
		
	public static void main(String args[]){
		int r = 0;
		long resultados[] = new long[24];
		String nomes[] = new String[24];
		try {
			for (int tamanho : CriarInstancia.tamanhoInstancias) {				
				String path = EDAConstants.caminhoPasta + "tarefa" + tamanho + ".txt";
				List<Integer> entrada = EDAUtil.getDadosIniciais(path);
				
				//PARA ARQUIVO COM MAIOR QUANTIDADE DE INSER��ES
				String arquivoOperacao = "operacoesI_" + tamanho;
				path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
				List<Operacao> operacoes = EDAUtil.getOperacoes(path);
				
				long tempoInicial = System.currentTimeMillis();				
				LPMaximaNOrdenada listaPrioridade = new LPMaximaNOrdenada(2*entrada.size());
				listaPrioridade.contruir(entrada);							
			
				for (Operacao operacao : operacoes) {
					System.out.println(operacao.getId() + " " + operacao.getValor() + " " + operacao.getNovoValor());
				}	
				long tempo = System.currentTimeMillis() - tempoInicial;
				resultados[r] = tempo;
				nomes[r] = arquivoOperacao;
				r++;
				System.out.println(arquivoOperacao + ": " + tempo);
				
				//PARA ARQUIVO COM MAIOR QUANTIDADE DE ALTERA��ES
				arquivoOperacao = "operacoesA_" + tamanho;
				path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
				operacoes = EDAUtil.getOperacoes(path);
				
				tempoInicial = System.currentTimeMillis();				
				listaPrioridade = new LPMaximaNOrdenada(2*entrada.size());
				listaPrioridade.contruir(entrada);							
			
				for (Operacao operacao : operacoes) {
					System.out.println(operacao.getId() + " " + operacao.getValor() + " " + operacao.getNovoValor());
				}	
				tempo = System.currentTimeMillis() - tempoInicial;	
				resultados[r] = tempo;
				nomes[r] = arquivoOperacao;
				r++;
				System.out.println(arquivoOperacao + ": " + tempo);
				
				//PARA ARQUIVO COM MAIOR QUANTIDADE DE REMOÇÕES
				arquivoOperacao = "operacoesR_" + tamanho;
				path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
				operacoes = EDAUtil.getOperacoes(path);
				
				tempoInicial = System.currentTimeMillis();				
				listaPrioridade = new LPMaximaNOrdenada(2*entrada.size());
				listaPrioridade.contruir(entrada);							
			
				for (Operacao operacao : operacoes) {
					System.out.println(operacao.getId() + " " + operacao.getValor() + " " + operacao.getNovoValor());
				}	
				tempo = System.currentTimeMillis() - tempoInicial;		
				resultados[r] = tempo;
				nomes[r] = arquivoOperacao;
				r++;
				System.out.println(arquivoOperacao + ": " + tempo);
				
				//PARA ARQUIVO COM MAIOR QUANTIDADE DE SELEÇÕES
				arquivoOperacao = "operacoesS_" + tamanho;
				path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
				operacoes = EDAUtil.getOperacoes(path);
				
				tempoInicial = System.currentTimeMillis();				
				listaPrioridade = new LPMaximaNOrdenada(2*entrada.size());
				listaPrioridade.contruir(entrada);							
			
				for (Operacao operacao : operacoes) {
					System.out.println(operacao.getId() + " " + operacao.getValor() + " " + operacao.getNovoValor());
				}	
				tempo = System.currentTimeMillis() - tempoInicial;	
				resultados[r] = tempo;
				nomes[r] = arquivoOperacao;
				r++;
				System.out.println(arquivoOperacao + ": " + tempo);
			}
			for(int i = 0; i < 24; i++){
				System.out.println(nomes[i] + " " + resultados[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
