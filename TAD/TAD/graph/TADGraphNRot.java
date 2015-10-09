package TAD.graph;

import java.util.*;
/**
 * Interface que descreve o TAD Grafo.
 * @author Michael Mora
 * @param <E> Classe dos dados que serão armazenados nos nodos do grafo.
 */
public interface TADGraphNRot<E extends Comparable, R extends Comparable> {
	/**
	 * Adiciona um nodo no grafo. 
	 * @param d - Elemento a ser adicionado no grafo.
	 */
	public void addNode(E d);
	
	/**
	 * Adiciona uma aresta no grafo.
	 * @param origem - instância (parcial) do nodo de origem da aresta
	 * @param destino - instância (parcial) do nodo destino da aresta 
	 */
	public void addEdge(E origem, E destino, R label);
	
	/**
	 * Procura um elemento no grafo.
	 * @param elem - instância (parcial) do elemento que se busca no grafo
	 * @return referência para o nodo no grafo 
	 */	
	//public Dado searchNode(Dado elem);
	
	public List<E> depthFirstTraversal(E origem);

}
