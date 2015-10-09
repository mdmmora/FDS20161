package OldTrees;

import java.util.List;
/**
 * Interface que descreve o TAD Árvore.
 * @author Michael Mora
 * @param <Dado> Classe dos dados que serão armazenados nos nodos da árvore.
 */

public interface TreeTAD<Dado> {
	/**
	 * Verifica se árvore está vazia.
	 * @return		true se a árvore está vazia, false caso contrário. 
	 */
	public abstract boolean isEmpty();
	
	/**
	 * Recupera a quantidade de nodos da árvore.
	 * @return		número de nodos. 
	 */
	public abstract int size();
	
	/**
	 * Adiciona um novo nodo na árvore.
	 * @param	d		Novo nodo a ser inserido.	
	 * @param	pos		Nodo após o qual será inserido o novo nodo.
	 */
	public abstract void add(Dado d, Dado pos);
	
	/**
	 * Adiciona um novo nodo na árvore, após o nodo marcado como corrente. Nodo corrente é
	 * aquele que acessado na operação mais recente sobre a árvore.
	 * @param	d		Novo nodo a ser inserido.	
	 */
	public abstract void addCurrent(Dado d);
	
	/**
	 * Remove o nodo da árvore que armazena a primeira ocorrência dado referenciado 
	 * pelo parêmetro "d", preservando os filhos deste. Re-organiza a árvore com 
	 * esta finalidade.
	 * @param	d		Referência para o dado a ser removido
	 * @return 			Referência para o dado armazenado na árvore e que está sendo
	 * 					removido. 
	 */
	public abstract Dado removeOcurrence(Dado d);
	
	/**
	 * Remove o nodo da árvore, juntamente com todos os seus filhos, que armazena o dado 
	 * referenciado pelo parêmetro "d".
	 * @param	d		Referência para o dado a ser removido 
	 */
	public abstract void removeBranch(Dado d);
	
	/**
	 * Recupera o dado armazenado nos filhos, indexando os ramos.
	 * @return    Dado armazenado no filho. 
	 */
	public abstract Dado getChild(int index);
	
	/**
	 * Recupera o dado armazenado na raiz da árvore.
	 * @return    Dado armazenado na raiz da árvore. 
	 */
	public abstract Dado getRoot();
	
	
	/**
	 * Recupera o dado armazenado no pai do nodo corrente da árvore.
	 * @return    Dado armazenado no pai do nodo corrente. 
	 */
	public abstract Dado getPai();
	
	
	/**
	 * Recupera o dado armazenado no nodo corrente da árvore.
	 * @return    Dado armazenado no nodo corrente. 
	 */
	public abstract Dado getCurrent();
	
	
	/**
	 * Inicializa uma iterador (interno) na raiz. Permite acessar o nodos, um a um, através
	 * dos métodos getNextXXX().
	 */
	public abstract void initGetNext();
	
	
	/**
	 * Recupera o "próximo nodo" da árvore, seguindo "pré-ordem".
	 */
	public abstract Dado getNextPre();
	
	
	/**
	 * Procura a primeira ocorrência do dado na árvore.
	 * @param	d		Dado sendo procurado.	
	 * @return    referência para o dado da árvore.
	 */
	public abstract Dado search(Dado d);
	
	
	/**
	 * Procura a primeira ocorrência do dado na árvore, inicializando um
	 * iterador que permite buscar as ocorrências seguintes.
	 * @param	d		Dado sendo procurado.	
	 * @return    referência para o dado da árvore.
	 */
	public abstract Dado searchIterFirst(Dado d);
	
	
	/**
	 * Procura a ocorrência seguinte do dado procurado através 
	 * do método "searchIterFirst(Dado) na árvore.	
	 * @return    referência para o dado da árvore.
	 */
	public abstract Dado searchIterNext();
	
	
	/**
	 * Conta a quantidade de nodos da árvore. 	
	 * @return    Número de nodos da árvore
	 */
	public abstract int count();
	
	
	/**
	 * Conta a quantidade de nodos folha da árvore. 	
	 * @return    Número de nodos folha da árvore
	 */
	public abstract int countLeaves();
	
	
	/**
	 * Percorre a árvore em pré-ordem, retornando seus elementos. 	
	 * @return    Lista com os nodos da árvore em pré-ordem.
	 */
	public abstract List<Dado> traversalPre();
	
	
	/**
	 * Percorre a árvore em pós-ordem, retornando seus elementos. 	
	 * @return    Lista com os nodos da árvore em pos-ordem.
	 */
	public abstract List<Dado> traversalPos();
	
	
	/**
	 * Percorre a árvore em amplitude, retornando seus elementos. 	
	 * @return    Lista com os nodos da árvore, ordenados nível à nível, da esquerda para 
	 * 				direita.
	 */
	public abstract List<Dado> traversalWidth();
	
	public String strTraversalPre();
}