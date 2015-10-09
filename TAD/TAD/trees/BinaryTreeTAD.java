package TAD.trees;

import java.util.Iterator;
import java.util.List;

import javax.naming.OperationNotSupportedException;


/**
 * Interface que descreve o TAD Árvore Binária.
 * @author Michael Mora, Júlio Machado, Isabel Manssour
 */

public interface BinaryTreeTAD<E extends Comparable<E>> {

	/**
	 * Adiciona um novo nodo na árvore.
	 * @param element Novo nodo a ser inserido.	
	 * @param father  Nodo após o qual será inserido o novo nodo, se null então insere na raiz.
	 * @param position NodePosition.LEFT para filho da esquerda ou NodePosition.RIGHT para filho da direita.
	 * @return true se o elemento foi inserido
	 */
	boolean add(E element, E father, NodePosition position);

	/**
	 * Remove o nodo da árvore, juntamente com todos os seus filhos.
	 * @param element Referência para o dado a ser removido.
	 * @return true se a árvore contém o elemento especificado.
	 */
	boolean removeBranch(E element);

	/**
	 * Substitui a primeira ocorrência do elemento indicado por um novo elemento
	 * @param old elemento a ser substituído
	 * @param element novo elemento
	 * @return elemento que foi substituído ou null se o elemento não está na árvore
	 */
	E set(E old, E element);

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
	 * Recupera a quantidade de nodos folha da árvore, através de cálculo recursivo.
	 * @return número de nodos. 
	 */	
	int countLeaves();

	/**
	 * Recupera a quantidade de nodos não-folha da árvore através de cálculo recursivo.
	 * @return número de nodos. 
	 */	
	int countBranches();

	/**
	 * Retorna a altura da árvore.
	 * @return altura. 
	 */	
	int height();
	
	/**
	 * Retorna o nível do do elemente "element".
	 * @param elemento para verificar.
	 * @return nível do elemento.
	 */	
	int level(E element);

	/**
	 * Verifica se árvore está vazia.
	 * @return true se a árvore está vazia, false caso contrário. 
	 */
	boolean isEmpty();
	
	/**
	 * Verifica se o elemento fornecido é o raiz.
	 * @param elemento para verificar.
	 * @return true se o elemento for raiz, false caso contrário. 
	 */
	boolean isRoot(E element);

	/**
	 * Verifica se o elemento fornecido é folha.
	 * @param elemento para verificar.
	 * @return true se o elemento for folha, false caso contrário. 
	 */
	boolean isLeave(E element);

	/**
	 * Verifica se o elemento fornecido não é folha.
	 * @param elemento para verificar.
	 * @return true se o elemento não for folha, false caso contrário. 
	 */
	boolean isBranch(E element);
	
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