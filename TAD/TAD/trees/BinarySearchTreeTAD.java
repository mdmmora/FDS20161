package TAD.trees;

import java.util.Iterator;
import java.util.List;

/**
 * Interface que descreve o TAD Árvore Binária de Pesquisa.
 * @author Michael Mora, Júlio Machado, Isabel Manssour
 */

public interface BinarySearchTreeTAD<E extends Comparable<E>> {
	/**
	 * Verifica se árvore está vazia.
	 * @return true se a árvore está vazia, false caso contrário. 
	 */
	boolean isEmpty();
	
	/**
	 * Recupera a quantidade de nodos da árvore.
	 * @return número de nodos. 
	 */
	int size();

	/**
	 * Recupera a quantidade de nodos da árvore através de cálculo recursivo.
	 * @return número de nodos. 
	 */	
	int count();
	
	/**
	 * Recupera o dado armazenado na raiz da árvore.
	 * @return dado armazenado na raiz da árvore. 
	 * @throws EmptyTreeException se a árvore está vazia.
	 */
	E getRoot();
	
	/**
	 * Adiciona um novo nodo na árvore.
	 * @param element Novo nodo a ser inserido.	
	 */
	void addRec(E element);
	
	/**
	 * Remove o nodo da árvore.
	 * @param element Referência para o dado a ser removido.
	 * @return o elemento removido da árvore.
	 */
	E remove(E element);
	
	/**
	 * Remove o nodo da árvore, juntamente com todos os seus filhos.
	 * @param element Referência para o dado a ser removido.
	 * @return true se a árvore contém o elemento especificado.
	 */
	boolean removeBranch(E element);
	
	/**
	 * Recupera o dado armazenado no filho da esquerda do nodo da árvore
	 * @param element Referência para o nodo a ser buscado.
	 * @return dado armazenado na esquerda do nodo informado. 
	 */
	E getLeft(E element);
		
	/**
	 * Recupera o dado armazenado no filho da direita do nodo da árvore
	 * @param element Referência para o nodo a ser buscado.
	 * @return dado armazenado na direita do nodo informado. 
	 */
	E getRight(E element);
			
	/**
	 * Recupera o dado armazenado no pai do nodo da árvore
	 * @param element Referência para o nodo a ser buscado.
	 * @return dado armazenado no pai do nodo informado. 
	 */
	E getFather(E element);
	
    /**
     * Retorna true se a árvore contém o elemento especificado
     * @param element o elemento a ser buscado
     * @return true se a árvore contém o elemento especificado
     */
    boolean contains(E element); 

    /**
     * Retorna uma referência para o item armazenado na árvore
     * que comparável ao elemento especificado
     * @param element objeto com o elemento a ser buscado
     * @return referência para o objeto armazenado na árvore, se a árvore contém o elemento especificado
     */
    E search(E element); 

    
    /**
     * Substitui a primeira ocorrência do elemento indicado por um novo elemento
     * @param old elemento a ser substituído
     * @param element novo elemento
     * @return elemento que foi substituído ou null se o elemento não está na árvore
     */
    E set(E old, E element);
    
    /**
	 * Instancia o navegador  para a árvore binária.
	 * @return Navigator para a árvore. 
	 */
	NavigatorBinTree<E> navigator();
	
	/**
	 * Instancia o iterador "default" para a árvore binária.
	 * @return iterador para a árvore. 
	 */
	Iterator<E> iterator();

	/**
	 * Instancia um iterador para a árvore binária.
	 * @param tipo do iterador desejado: WIDTH, POST, PRE ou CENTRAL
	 * @return iterador para a árvore.  
	 */
	Iterator<E> iterator(IteratorTreeType t);
	
    
	/**
	 * Percorre a árvore em pré-ordem, retornando seus elementos. 	
	 * @return Lista com os nodos da árvore em pré-ordem.
	 */
	List<E> traversalPre();
	
	/**
	 * Percorre a árvore em pós-ordem, retornando seus elementos. 	
	 * @return Lista com os nodos da árvore em pós-ordem.
	 */
	List<E> traversalPos();
	
	/**
	 * Percorre a árvore em ordem central (ou in-fixa), retornando seus elementos. 	
	 * @return Lista com os nodos da árvore em ordem central.
	 */
	List<E> traversalCentral();
	
	/**
	 * Percorre a árvore em amplitude, retornando seus elementos. 	
	 * @return Lista com os nodos da árvore, ordenados nével a nível, da esquerda para direita. 
	 */
	List<E> traversalWidth();
	
	/**
	 * Percorre a árvore em pré-ordem, retornando uma string com o conteúdo dos elementos
	 * da árvore concatenados. 	
	 * @return String com os nodos da árvore concatenados em pré-ordem.
	 */
	String strTraversalPre();
	
	/**
	 * Percorre a árvore em pós-ordem, retornando uma string com o conteúdo dos elementos
	 * da árvore concatenados. 	
	 * @return String com os nodos da árvore concatenados em pós-ordem.
	 */
	String strTraversalPos();
	
	/**
	 * Percorre a árvore em ordem central, retornando uma string com o conteúdo dos elementos
	 * da árvore concatenados. 	
	 * @return String com os nodos da árvore concatenados em ordem central.
	 */
	String strTraversalCentral();
}
