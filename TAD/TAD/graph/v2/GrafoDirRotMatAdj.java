package TAD.graph.v2;

import java.util.*;

/******
 * Implementação de um Grafo Dirigido e Rotulado utilizando Matriz de Adjacências.
 * Esta implementação suporta apenas uma aresta um determinado par de nodos.
 * @param N - Genérico. Tipo do nodo do grafo
 * @param A - Genérico. Tipo do rótulo da aresta do grafo
 * @author CAA
 * @version 1.0
 */

public class GrafoDirRotMatAdj<N, A> {

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
	
	private int max;
	private List<Node<N>> nodeList;
	private A [][] matAdj;	
	
	public GrafoDirRotMatAdj(int n) {
		if (n > 0)
			max = n;
		else
			max = 1000;
		
		nodeList = new ArrayList<Node<N>>(max);
		matAdj = (A[][]) new Object[max][max];
	}
	
	
	public int indexOfNode(N elem) {
		int res = -1;
		
		for (int i = 0; i < nodeList.size() && res == -1; i++)
			if (nodeList.get(i).getElem().equals(elem))
				res = i;
		
		return res;
	}
	
	public void addNode(N elem) {
		Node<N> novo = new Node<N>(elem);
		
		if (nodeList.size() < max)
			if (this.indexOfNode(elem) == -1) 
				nodeList.add(novo);
			else
				throw new IllegalArgumentException();
		else
			throw new OutOfMemoryError();
	}
	
	public void addEdge(N orig, N dest, A rot) {
		int posOrig = this.indexOfNode(orig);
		int posDest = this.indexOfNode(dest);
		
		if (posOrig == -1 || posDest == -1)
			throw new IllegalArgumentException("Invalide Node");
		else if (matAdj[posOrig][posDest] == null)
				 matAdj[posOrig][posDest] = rot;
		else 
			throw new IllegalArgumentException("Invalid Label");
	}
	
	public List<Node<N>> getAllNeighbours(N elem){
		
		List<Node<N>> res = new ArrayList<Node<N>>();
		int index = this.indexOfNode(elem);
		
		if (index < 0)
			throw new IllegalArgumentException("Invalid Node");
		else {
			for (int i = 0; i < nodeList.size(); i++)
				if (matAdj[index][i] != null)
					res.add(nodeList.get(i));
		}
				
		return(res);	
	}
	
	public void markAllNodes() {
		for (Node<N> n:nodeList)
			n.mark();	
	}
	
	public void unMarkAllNodes() {
		for (Node<N> n:nodeList)
			n.unMark();	
	}
	
	/***********************
	Algo: caminhoAB
	Entr: Nodo orig, Nodo dest
	Said: Lista de Nodos
	
	DESMARQUE TODOS OS NODOS     <<--
	MARQUE O NODO orig
	RETORNE caminhoABAux(orig, dest)
	----------------------------
	Algo: caminhoABAux
	Entr: Nodo orig, Nodo dest
	Said: Lista de Nodos
	
	Lista res = [];
	
	PARA CADA NODO v VIZINHO DE orig NÃO MARCADO   <<--
	FAÇA {MARQUE v COMO VISITADO 
	      SE (v == dest)
	      ENTÃO { res.addFisrt(orig);
	       		  res.addLast(v);
	              RETORNE (res);
	            }
	      SENÃO {res = caminhoABAux(v, dest);
	             SE (res NÃO ESTÁ VAZIA)
	             ENTÃO {res.addFirst(orig);
	                   RETORNE (res);}
	            }
	RETORNE (res);  
	************************/
	public List<N> singleSourceSingleDestRec(N orig, N dest) {
		int index, index1;
		
		this.unMarkAllNodes();
		index = this.indexOfNode(orig);
		index1 = this.indexOfNode(dest);
		
		if ((index == -1) || (index1 == -1))
			throw new IllegalArgumentException("Invalid Node");
		else {
			nodeList.get(index).mark();
			return this.singleSourceSingleDestRecAux(orig, dest);
		}
	}
	
	private List<N> singleSourceSingleDestRecAux(N orig, N dest) {
		List<N> res = new ArrayList<N>();
		
		for(Node<N> v:this.getAllNeighbours(orig)) {
			if (! v.isMarked()) {
				v.mark();
			
				if (v.getElem().equals(dest)){
					res.add(0, orig);
					res.add(dest);
					return(res);
				}
				else {
					   res = singleSourceSingleDestRecAux(v.getElem(), dest);
				
					   if (! res.isEmpty()) {
						   res.add(0, orig);
						   return(res);
					   }
				}
			}
		}
		return(res);
	}
		
			
	public static void main(String [] argc) {
		GrafoDirRotMatAdj<String, Integer> mapa = new GrafoDirRotMatAdj<String, Integer>(10);
		GrafoDirRotMatAdj<String, String> n = new GrafoDirRotMatAdj<String, String>(10);
		List<String> caminho = new ArrayList<String>();
		
		mapa.addNode("POA");
		mapa.addNode("Viamão");
		mapa.addNode("Cidreira");
		mapa.addNode("Canoas");
		mapa.addNode("Bagé");
		
		mapa.addEdge("POA", "Viamão", 30);
		mapa.addEdge("Viamão", "POA", 30);
		
		mapa.addEdge("POA", "Canoas", 20);
		mapa.addEdge("Canoas", "POA", 20);
		
		mapa.addEdge("POA", "Bagé", 800);
		mapa.addEdge("Bagé", "POA", 800);
		
		mapa.addEdge("Viamão", "Cidreira", 75);
		mapa.addEdge("Cidreira", "Viamão", 75);
		
		mapa.addEdge("Canoas", "Cidreira", 87);
		mapa.addEdge("Cidreira", "Canoas", 87);
		
		
		caminho = mapa.singleSourceSingleDestRec("POA", "Bagé");
		System.out.println(caminho);
		caminho = mapa.singleSourceSingleDestRec("POA", "Cidreira");
		System.out.println(caminho);
		caminho = mapa.singleSourceSingleDestRec("Bagé", "Cidreira");
		System.out.println(caminho);
		
		n.addNode("N1");
		n.addNode("N2");
		n.addNode("N3");
		n.addNode("N4");
		n.addNode("N5");
		n.addNode("N6");
		n.addNode("N7");
		
		n.addEdge("N1", "N2", "r2");
		n.addEdge("N2", "N1", "r1");
		n.addEdge("N1", "N4", "r6");
		
		n.addEdge("N2", "N3", "r3");
		
		n.addEdge("N3", "N4", "r4");
		n.addEdge("N4", "N3", "r5");		
		
		n.addEdge("N5", "N4", "r7");
		n.addEdge("N5", "N6", "r9");
		n.addEdge("N6", "N5", "r10");
		
		n.addEdge("N6", "N7", "r11");
		n.addEdge("N7", "N4", "r8");
		
		System.out.println("\n Grafo dos N \n");
		caminho = n.singleSourceSingleDestRec("N1", "N7");
		System.out.println(caminho);
		caminho = n.singleSourceSingleDestRec("N6", "N1");
		System.out.println(caminho);
		caminho = n.singleSourceSingleDestRec("N5", "N4");
		System.out.println(caminho);
		caminho = n.singleSourceSingleDestRec("N5", "N7");
		System.out.println(caminho);
		
		
	}
}
	