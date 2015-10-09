package TAD.graph.incrementos.v2;

import java.util.*;


/******
 * Implementa��o did�tica e parcial de um Grafo Dirigido utilizando Matriz de Adjac�ncias.
 * @param N - Gen�rico. Tipo do nodo do grafo
 * @author Michael da Costa M�ra
 * @version 1.1
 */

public class GraphDirMatAdj<N> {
	private class Node <T> {
		private T elem;
		private boolean marked = false;

		public Node(T n) {
			this.elem = n;
			unMark();
		}
		public T getElem() {
			return elem;
		}
		public void setElem(T elem) {
			this.elem = elem;
		}
		public boolean isMarked() {
			return marked;
		}
		public void mark() {
			this.marked = true;
		}

		public void unMark() {
			this.marked = false;
		}
	}
	private List<Node<N>> lNodes;
	private int max;
	private boolean [][] matAdj;	

	public GraphDirMatAdj(int n) {
		if (n > 0)
			max = n;
		else
			max = 1000;

		lNodes = new ArrayList<Node<N>>(max);
		matAdj = new boolean[max][max];
		for (int i = 0; i < max; i++)
			for (int j = 0; j < max; j++)
				matAdj[i][j] = false;
	}
	private int indexItem(N item) {
		int res = -1;
		int i;

		for (i =0; ((i < lNodes.size()) && !item.equals(lNodes.get(i).getElem())); i++);

		if (i < lNodes.size())
			res = i;

		return res;
	}
	public void markAllNodes() {
		for (Node<N> n:lNodes)
			n.mark();	
	}
	public void unMarkAllNodes() {
		for (Node<N> n:lNodes)
			n.unMark();	
	}

	public void addNode(N item) {				
		if (lNodes.size() < max)
			if (indexItem(item) == -1) {
				Node<N> novo = new Node<>(item);
				lNodes.add(novo);
			}
			else
				throw new IllegalArgumentException();
		else
			throw new OutOfMemoryError("Max number of nodes reached");
	}

	public void addEdge(N orig, N dest) {
		int posOrig = indexItem(orig);
		int posDest = indexItem(dest);

		if (posOrig == -1 || posDest == -1)
			throw new IllegalArgumentException("Invalid Node");
		else {
			matAdj[posOrig][posDest] = true;
		}
	}

	private List<Node<N>> getAllAdjacents(N nodo){
		List<Node<N>> res = new ArrayList<>();
		int index = indexItem(nodo);
		if (index < 0)
			throw new IllegalArgumentException("Invalid Node");
		else {
			for (int i = 0; i < lNodes.size(); i++)
				if (matAdj[index][i])
					res.add(lNodes.get(i));
		}

		return(res);	
	}	

	/* *********************************
	Algo: wfs
	Entr: Nodo orig
	Said: Lista de Nodos

	Fila fAux, result;
	Nodo nAux;

	DESMARCA TODOS OS NODOS;
	fAux.offer(orig);
	orig.marca();

	ENQUANTO (fAux n�o est� vazia)
	FA�A {
	      nAux = fAux.poll();
	      result.enqueue(nAux);

	      PARA CADA VIZINHO N�O MARCADO v DE nAUX
	      FA�A {v.marca();
	      		fAux.offer(v);}
	     }
	 RETORNA result 	
	 **********************************/

	/* (non-Javadoc)
	 * @see TAD.graph.GraphTAD#wfs(N)
	 */

	public List<N> traversalWidth(N orig) {
		List<N> result = new ArrayList<N>();
		Queue<Node<N>> fAux = new LinkedList<Node<N>>();
		Node<N> nAux;
		int index;

		index = this.indexItem(orig);
		if (index == -1)
			throw new IllegalArgumentException("InvNod");
		else {	this.unMarkAllNodes();

		result.add(lNodes.get(index).getElem());
		fAux.offer(lNodes.get(index));
		lNodes.get(index).mark();

		while(!fAux.isEmpty()) {
			nAux = fAux.poll();

			for(Node<N> v:this.getAllAdjacents(nAux.getElem()))
				if (!v.isMarked()) {
					result.add(v.getElem());
					v.mark();
					fAux.offer(v);  }
		}
		}	
		return result;
	}

	
	/* *********************************
	Algo: dfs
	Entr: Nodo orig
	Said: Lista de Nodos

	Lista result;
	DESMARCA TODOS OS NODOS;
	dfsAux(orig, result);
	RETORNA result;
	 ***********************************
	Algo: dfsAux
	Entr: Nodo orig, Lista de Nodos result
	Said: NULL

	result.add(orig);
	orig.marca();

	PARA CADA VIZINHO N�O MARCADO v DE orig
	FA�A dfsAux(v, result);
	 ***********************************/

	/* (non-Javadoc)
	 * @see TAD.graph.GraphTAD#dfs(N)
	 */

	public List<N> traversalDepth(N orig) {
		List<N> result = new ArrayList<N>();
		int index;

		index = this.indexItem(orig);
		if (index == -1)
			throw new IllegalArgumentException("InvNod");
		else {
			this.unMarkAllNodes();
			traversalDepth(lNodes.get(index), result);
		}
		return result;
	}

	private void traversalDepth(Node<N> orig, List<N> result) {
		result.add(orig.getElem());
		orig.mark();

		for(Node<N> v:getAllAdjacents(orig.getElem()))
			if (! v.isMarked())
				traversalDepth(v, result);
	}


	public List<N> pathFromTo(N orig, N dest) {
		int index, index1;

		this.unMarkAllNodes();
		index = this.indexItem(orig);
		index1 = this.indexItem(dest);
		if ((index == -1) || (index1 == -1))
			throw new IllegalArgumentException("InvNode");
		else {
			lNodes.get(index).mark();
			return this.pathFromToAux(orig, dest);
		}
	}
	private List<N> pathFromToAux(N orig, N dest) {
		List<N> res = null;

		if (orig.equals(dest)){
			res = new ArrayList<N>();
			res.add(dest);
			return(res);
		}	
		int pos = indexItem(orig);
		lNodes.get(pos).mark();	
		for(Node<N> v:this.getAllAdjacents(orig)) {
			if (! v.isMarked()) {
					res = pathFromToAux(v.getElem(), dest);

					if (res != null) {
						res.add(0, orig);
						return(res);
					}
				}
			}
		return(res);
	}

	
	public String toString() {
		StringBuilder res = new StringBuilder();
		N n;

		for (int l = 0; l < lNodes.size(); l++) {
			n = lNodes.get(l).getElem();

			res.append(n.toString());
			res.append(":");
			
			for (int c = 0; c < lNodes.size(); c++)
				if (matAdj[l][c]) {
					res.append("\t");
					res.append(lNodes.get(c).getElem().toString());
					res.append("\n");
				}
		}

		return res.toString();
	}
}
