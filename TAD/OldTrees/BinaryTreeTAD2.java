package OldTrees;
import java.util.List;

import TAD.trees.NodePosition;

/**
 * Interface que descreve o TAD Á?rvore Binária.
 * @author Michael Mora, Júlio Machado, Isabel Manssour
 */

public interface BinaryTreeTAD2<E> {
	/**
	 * Verifica se árvore está vazia.
	 * @return true se a árvore está vazia, false caso contrário. 
	 */
	boolean isEmpty();
	
	/**
	 * Recupera a quantidade de nodos da árvore.
	 * @return náºmero de nodos. 
	 */
	int size();

	/**
	 * Recupera a quantidade de nodos da árvore atravá©s de cálculo recursivo.
	 * @return náºmero de nodos. 
	 */	
	int count();
	
	/**
	 * Recupera o dado armazenado na raiz da árvore.
	 * @return dado armazenado na raiz da árvore. 
	 * @throws EmptyTreeException se a árvore está vazia.
	 */
	E getRoot();
	
	/**
	 * Altera o dado armazenado na raiz da árvore
	 * @param element dado a ser armazenado na raiz da árvore
	 * @throws EmptyTreeException se a árvore está vazia.
	 */
	void setRoot(E element);
	
	/**
	 * Adiciona um novo nodo na árvore.
	 * @param element Novo nodo a ser inserido.	
	 * @param father  Nodo apá³s o qual será inserido o novo nodo, se null entá£o insere na raiz.
	 * @param position NodePosition.LEFT para filho da esquerda ou NodePosition.RIGHT para filho da direita.
	 * @return true se o elemento foi inserido
	 */
	boolean add(E element, E father, NodePosition position);
	
	/**
	 * Remove o nodo da árvore, juntamente com todos os seus filhos.
	 * @param element Referáªncia para o dado a ser removido.
	 * @return true se a árvore contá©m o elemento especificado.
	 */
	boolean removeBranch(E element);
	
	/**
	 * Recupera o dado armazenado no filho da esquerda do nodo da árvore
	 * @param element Referáªncia para o nodo a ser buscado.
	 * @return dado armazenado na esquerda do nodo informado. 
	 */
	E getLeft(E element);
		
	/**
	 * Recupera o dado armazenado no filho da direita do nodo da árvore
	 * @param element Referáªncia para o nodo a ser buscado.
	 * @return dado armazenado na direita do nodo informado. 
	 */
	E getRight(E element);
			
	/**
	 * Recupera o dado armazenado no pai do nodo da árvore
	 * @param element Referáªncia para o nodo a ser buscado.
	 * @return dado armazenado no pai do nodo informado. 
	 */
	E getFather(E element);
	
    /**
     * Retorna true se a árvore contá©m o elemento especificado
     * @param element o elemento a ser buscado
     * @return true se a árvore contá©m o elemento especificado
     */
    boolean contains(E element); 
	
    /**
     * Substitui a primeira ocorráªncia do elemento indicado por um novo elemento
     * @param old elemento a ser substituá­do
     * @param element novo elemento
     * @return elemento que foi substituá­do ou null se o elemento ná£o está na árvore
     */
    E set(E old, E element);
    
	/**
	 * Percorre a árvore em prá©-ordem, retornando seus elementos. 	
	 * @return Lista com os nodos da árvore em prá©-ordem.
	 */
	List<E> traversalPre();
	
	/**
	 * Percorre a árvore em pá³s-ordem, retornando seus elementos. 	
	 * @return Lista com os nodos da árvore em pá³s-ordem.
	 */
	List<E> traversalPos();
	
	/**
	 * Percorre a árvore em ordem central (ou in-fixa), retornando seus elementos. 	
	 * @return Lista com os nodos da árvore em ordem central.
	 */
	List<E> traversalCentral();
	
	/**
	 * Percorre a árvore em amplitude, retornando seus elementos. 	
	 * @return Lista com os nodos da árvore, ordenados ná©vel a ná­vel, da esquerda para direita. 
	 */
	List<E> traversalWidth();
	
	/**
	 * Percorre a árvore em prá©-ordem, retornando uma string com o conteáºdo dos elementos
	 * da árvore concatenados. 	
	 * @return String com os nodos da árvore concatenados em prá©-ordem.
	 */
	String strTraversalPre();
	
	/**
	 * Percorre a árvore em pá³s-ordem, retornando uma string com o conteáºdo dos elementos
	 * da árvore concatenados. 	
	 * @return String com os nodos da árvore concatenados em pá³s-ordem.
	 */
	String strTraversalPos();
	
	/**
	 * Percorre a árvore em ordem central, retornando uma string com o conteáºdo dos elementos
	 * da árvore concatenados. 	
	 * @return String com os nodos da árvore concatenados em ordem central.
	 */
	String strTraversalCentral();
}