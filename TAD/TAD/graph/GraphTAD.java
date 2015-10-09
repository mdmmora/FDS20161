package TAD.graph;

import java.util.List;

public interface GraphTAD<N, A> {

	/**
	 * Adiciona um novo nodo no grafo.
	 */
	public abstract void addNode(N elem);

	/**
	 * Adiciona uma nova aresta no grafo.
	 */
	public abstract void addEdge(N orig, N dest, A rot);

	/**
	 * Retorna uma lista de nodos, após fazer caminhamento em profundidade.
	 */
	public abstract List<N> traversalDepth(N orig);

	/**
	 * Retorna uma lista de nodos, após fazer caminhamento em amplitude.
	 */
	public abstract List<N> traversalWidth(N orig);
	
	/**
	 * Retorna um caminho qualquer entre dois nodos.
	 */
	public abstract List<N> findPath(N orig, N dest);
	
	/**
	 * Retorna o número de nodos de um grafo.
	 */
	public abstract int size();
}