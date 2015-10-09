package TAD.graph;

import java.util.*;
/**
 * Implementação do TAD Grafos utilizando listas de adjacências.
 * Esta implementação da lista de adjacências aponta para a instância do nodo armazenada
 * no Grafo Dirigido. 
 * @author Michael Mora
 * @param <Dado> Classe dos dados que serão armazenados nos nodos do grafo.
 */
public class GrafoDirLstAdj<Dado extends Comparable<Dado>, Rotulo extends Comparable<Dado>> implements TADGraphNRot<Dado, Rotulo> {
	private class Edge{
		private Node nodo;
		private Rotulo label;
		
		public Edge()
		{
			nodo = null;
			label = null;
		}
		
		public Edge(Node n, Rotulo r)
		{
			nodo = n;
			label = r;
		}
		public Node getNodo() {
			return nodo;
		}
		public void setNodo(Node elem) {
			this.nodo = elem;
		}
		public Rotulo getLabel() {
			return label;
		}
		public void setLabel(Rotulo label) {
			this.label = label;
		}
	}
	
	private class Node {
		private Dado elem;
		private boolean marked = false;
		private List <Edge> edgeList = new LinkedList<Edge>();
		
		public Node(Dado d)
		{
			elem = d;
		}
		
		int compareTo(Node n)
		{
			return elem.compareTo(n.getElem());
		}
		
		public void setElem(Dado d)
		{
			elem = d;
		}
		public Dado getElem()
		{
			return elem;
		}
		
		public void markNode()
		{
			marked = true;
		}
		
		public void unmarkNode()
		{
			marked = false;
		}
		
		public boolean isMarked()
		{
			return marked;
		}
		
		public void addEdge(Node n, Rotulo r)
		{
			Edge novo = new Edge(n, r);
			
			edgeList.add(novo);
		}
		
		public void removeEdge(Node n, Rotulo r)
		{
			edgeList.remove(new Edge(n, r));
		}
		
		public List<Edge> getEdgeList()
		{
			return edgeList;
		}
	}
	
	private List<Node> nodeList = new LinkedList<Node>();
	
	private int getNodePosByValue(Dado d)
	{
		int res = -1, i;
		
		for (i = 0;( (i < nodeList.size()) &&
				      (nodeList.get(i).getElem().compareTo(d) != 0) ); i++);
		
		if (i < nodeList.size())
			res = i;
		
		return res;
	}

	private Node getNodeByValue(Dado d)
	{
		Node res;
		int nPos;
		
		nPos = getNodePosByValue(d);
		
		res = nodeList.get(nPos);
		
		return res;
	}

	private void unmarkAll()
	{
		for (Node n:nodeList)
			n.unmarkNode();
	}
	
	public void addNode(Dado d)
	{
		Node novo = new Node(d);
		nodeList.add(novo);
	}
	
	public void addEdge(Dado orig, Dado dest, Rotulo label)
	{
		int indexOri, indexDest;
		
		indexOri  = getNodePosByValue(orig);
		indexDest = getNodePosByValue(dest);
		
		if ((indexOri >= 0 ) && (indexDest >= 0))
			nodeList.get(indexOri).addEdge(nodeList.get(indexDest), label);
		else
			throw new IllegalArgumentException("Nodo não encontrado"
					  + "Nodo Origem = " + indexOri
					  + " Nodo Destino = " + indexDest);
	}
	
	public List<Dado> depthFirstTraversal(Dado origem)
	{
		List<Dado> res = new LinkedList<Dado>();
		List<Node> pilha = new LinkedList<Node>(), auxL;
		List<Edge> auxEdge = new LinkedList<Edge>();
		Node auxN;
		
		unmarkAll();
		
		auxN = getNodeByValue(origem);
		pilha.add(0, auxN);
		auxN.markNode();
		
		while (pilha.size() != 0)
		{
			auxN = pilha.remove(0);
			res.add(auxN.getElem());
			auxEdge = auxN.getEdgeList();
			
			for (Edge e:auxEdge)
				if (!e.getNodo().isMarked())
				{
					pilha.add(0, e.getNodo());
					e.getNodo().markNode();
				}
		}
		
		return res;
	}
	
	

	public String toString()
	{
		String res = "";
		
		for (Node n:nodeList)
		{
			res = res + n.getElem().toString() + " - "; 
			res = res + "[";
			
			for (Edge e:n.getEdgeList())
				res = res + "(" + e.getNodo().getElem().toString() + ", " + e.getLabel().toString() + ")";
			
			res = res.substring(0, res.length());
			res = res + "]" + "\n";
		}
		
		return res;
	}

}
