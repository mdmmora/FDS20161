package TAD.trees;

import java.util.List;

/**
 * Interface que descreve o TAD ¡rvore Geral.
 * @author Michael Mora, J˙lio Machado, Isabel Manssour
 */

public interface GeneralTreeTAD<E extends Comparable<E>> {
	/**
	 * Verifica se ¡rvore est· vazia.
	 * @return true se a ¡rvore est· vazia, false caso contr·rio. 
	 */
	boolean isEmpty();
	
	/**
	 * Recupera a quantidade de nodos da ·rvore atravÈs de c·lculo recursivo.
	 * @return n˙mero de nodos. 
	 */	
	int count();
	
	/**
	 * Recupera o dado armazenado na raiz da ·rvore.
	 * @return dado armazenado na raiz da ·rvore. 
	 * @throws EmptyTreeException se a ·rvore est· vazia.
	 */
	E getRoot();
	
	/**
	 * Altera o dado armazenado na raiz da ·rvore
	 * @param element dado a ser armazenado na raiz da ·rvore
	 * @throws EmptyTreeException se a ·rvore est· vazia.
	 */
	void setRoot(E element);
	
	/**
	 * Adiciona um novo nodo na ·rvore como filho de um nodo pai.
	 * @param element Novo nodo a ser inserido.	
	 * @param father  Nodo ap√≥s o qual ser· inserido o novo nodo, se null ent√£o insere na raiz.
	 * @return true se o elemento foi inserido
	 */
	boolean add(E element, E father);
	
	/**
	 * Remove o nodo da ·rvore, juntamente com todos os seus filhos.
	 * @param element Refer√™ncia para o dado a ser removido.
	 * @return true se a ·rvore cont√©m o elemento especificado.
	 */
	boolean removeBranch(E element);
	
	/**
	 * Recupera o dado armazenado no i-esimo filho do nodo da ·rvore
	 * @param element elemento do nodo pai.
	 * @return dado armazenado no i-esimo filho do nodo informado. 
	 */
	E get(E element, int i);
		
	/**
	 * Recupera o dado armazenado no pai do nodo da ·rvore
	 * @param element Refer√™ncia para o nodo a ser buscado.
	 * @return dado armazenado no pai do nodo informado. 
	 */
	E getFather(E element);
	
    /**
     * Retorna true se a ·rvore cont√©m o elemento especificado
     * @param element o elemento a ser buscado
     * @return true se a ·rvore cont√©m o elemento especificado
     */
    boolean contains(E element); 
	
    /**
     * Substitui a primeira ocorr√™ncia do elemento indicado por um novo elemento
     * @param old elemento a ser substitu√≠do
     * @param element novo elemento
     * @return elemento que foi substitu√≠do ou null se o elemento n√£o est· na ·rvore
     */
    E set(E old, E element);
    
	/**
	 * Percorre a ·rvore em pr√©-ordem, retornando seus elementos. 	
	 * @return Lista com os nodos da ·rvore em pr√©-ordem.
	 */
	List<E> traversalPre();
	
	/**
	 * Percorre a ·rvore em p√≥s-ordem, retornando seus elementos. 	
	 * @return Lista com os nodos da ·rvore em p√≥s-ordem.
	 */
	List<E> traversalPos();
		
	/**
	 * Percorre a ·rvore em amplitude, retornando seus elementos. 	
	 * @return Lista com os nodos da ·rvore, ordenados n√©vel a n√≠vel, da esquerda para direita. 
	 */
	List<E> traversalWidth();	
}