package TAD.graph.incrementos;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;



/******
 * Implementação didática e parcial de um Grafo Não-Dirigido utilizando Lista de Adjacências.
 * @param N - Genérico. Tipo do nodo do grafo
 * @author Michael da Costa Móra
 * @version 1.1
 */
public class GraphDirListAdj<E> {	
	private ArrayList<Node<E>> lNodes = new ArrayList<Node<E>>();
	private class Node<T> {
		private T item;
		private ArrayList<Node<T>> lAdj = new ArrayList<Node<T>>();
		public T getItem() {
			return item;
		}
		public void setItem(T item) {
			this.item = item;
		}
		public void addAdjacent(Node<T> n){
			if (!lAdj.contains(n))
				lAdj.add(n);
		}
		public ArrayList<Node<T>> getAdjacents(){
			return lAdj;
		}
		public Node<T> getAdjacent(int i){
			Node<T> res = null;
			if ((i < lAdj.size()) && (i >= 0))
				res = lAdj.get(i);
			return res;
		}
	}

	private Node<E> searchNodeRef(E item){
		Node<E> res = null;
		int i;

		for (i = 0; ((i < lNodes.size()) && !lNodes.get(i).getItem().equals(item)); i++);

		if (i < lNodes.size())
			res = lNodes.get(i);

		return res;
	}

	private List<Node<E>> getAllAdjacents(E nodo){
		List< Node<E>> res;
		Node<E> nAux = searchNodeRef(nodo);
		if (nAux == null)
			throw new IllegalArgumentException("Invalid Node");
		else 
			res = (List<Node<E>>)(nAux.getAdjacents().clone());

		return(res);	
	}	

	public boolean addNode(E item) {
		Node<E> nAux;
		boolean res = false;

		nAux = searchNodeRef(item);

		if (nAux == null){
			Node<E> novo = new Node<E>();
			novo.setItem(item);
			lNodes.add(novo);
			res = true;
		}

		return res;
	}

	public boolean addEdge(E n1, E n2) {
		Node<E> n1Aux, n2Aux;
		boolean res = false;
		int i;

		n1Aux = searchNodeRef(n1);
		if (n1Aux != null) {
			n2Aux = searchNodeRef(n2);
			if (n2Aux != null) {
				for (i = 0; i < n1Aux.getAdjacents().size(); i++)
					if (n1Aux.getAdjacent(i).getItem().equals(n2Aux.getItem()))
						break;
				if (i >= n1Aux.getAdjacents().size()) {	
					n1Aux.addAdjacent(n2Aux);
					res = true;
				}
			}
		}

		return res;
	}


	public boolean isReachable(E dado){
		boolean res = false;

		if (dado != null) 
			for (Node<E> n: lNodes)
				for (Node<E> m:n.getAdjacents())
					if (m.getItem().equals(dado)){
						res = true;
						break;
					}

		return res;
	}

	public List<E> getTwoLevelsAhead(E dado){
		List<E> res = null;
		List<Node<E>> lAux;
		Set<E> conjRes = null;
		Node<E> aux;

		if (dado != null) {
			aux = searchNodeRef(dado);
			if (aux != null){
				conjRes = new HashSet<E>();
				lAux = new LinkedList<>();

				for(Node<E> n:aux.getAdjacents()){
					lAux.add(n);
					conjRes.add(n.getItem());
				}

				int tam = lAux.size();

				for (int i = 0; i < tam; i++)
					for(Node<E> n:lAux)
						for(Node<E> m:n.getAdjacents())
							conjRes.add(m.getItem());
			}
		}

		if (conjRes != null && !conjRes.isEmpty())
			res = new LinkedList<>(conjRes);

			return res;
	}

	public String toString() {
		StringBuilder res = new StringBuilder();

		for (Node<E> n:lNodes) {
			res.append("\n");
			res.append(n.getItem().toString());
			res.append(": \t");
			for (Node<E> m:n.getAdjacents()) {
				res.append(m.getItem().toString());
				res.append("\n\t");
			}
		}

		return res.toString();
	}
}
