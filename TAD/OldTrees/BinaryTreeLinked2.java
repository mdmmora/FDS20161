package OldTrees;
import java.util.*;

import OldTrees.BinaryTreeTAD2;
import TAD.trees.NodePosition;

/**
 * Implementação do TAD �?rvore Binária.
 * @author Michael Mora, Júlio Machado, Isabel Manssour
 */
public class BinaryTreeLinked2 <E> implements BinaryTreeTAD2<E> {
	private static final class Node<T> {
		private Node<T> father;
		private Node<T> left;
		private Node<T> right;
		private T item;
		
		public Node(T element) {
			father = null;
			left = null;
			right = null;
			item = element;
		}
		
		public Node<T> getRight() {
			return right;
		}
		public void setRight(Node<T> n) {
			right = n;
		}
		public Node<T> getLeft() {
			return left;
		}
		public void setLeft(Node<T> n) {
			left = n;
		}
		public Node<T> getFather() {
			return father;
		}
		public void setFather(Node<T> n) {
			father = n;
		}
		public T getItem() {
			return item;
		}
		public void setItem(T element) {
			item = element;
		}		
	}

	private int count; //contagem do número de nodos
	private Node<E> refRoot; //referência para o nodo raiz
	
	public BinaryTreeLinked2() {
		count = 0;
		refRoot = null;
	}
	
	public BinaryTreeLinked2(E [] vet) {
		createTree(vet);		
	}
	
	public void createTree(E [] vet)
	{
		List <Node<E>> fila = new LinkedList<Node<E>>();
		int i;
		Node<E> novo = null, primeiro = null;
		NodePosition pos = null;
		
		this.count = vet.length;
		
		if (vet.length > 0)
		{
			novo = new Node<E>(vet[0]);
			refRoot = novo;
					
			fila.add(0, novo);
			pos = NodePosition.LEFT;
			
			for(i = 1; i < vet.length; i++)
			{
				novo = new Node<E>(vet[i]);
				fila.add(novo);
				
				primeiro = fila.get(0);
				novo.setFather(primeiro);
				
				if (pos.equals(NodePosition.LEFT))
				{
					primeiro.setLeft(novo);
					pos = NodePosition.RIGHT;
				}
				else
				{
					primeiro.setRight(novo);
					fila.remove(0);
					pos = NodePosition.LEFT;
				}		
			}
		}
	}
	
	public boolean isEmpty()
	{
		return (refRoot == null);
	}

	public int size()
	{
		return count;
	}

	public E getRoot()
	{
		if(isEmpty())
			throw new EmptyTreeException();
		return refRoot.getItem();
	}

	public void setRoot(E element)
	{
		if(isEmpty())
			throw new EmptyTreeException();
		refRoot.setItem(element);
	}
	
	public int count()
	{
		return count(refRoot);
	}
	private int count(Node<E> n)
	{
		if (n == null) {
			return 0;
		}
		else {
			return 1 + count(n.getLeft()) + count(n.getRight());
		}
	}
	
	public boolean add(E element, E father, NodePosition position)
	{
		Node<E> n = new Node<E>(element);
		Node<E> nAux = null;
		boolean res = false;
		//Verifica se está inserindo na raiz
		if (father == null) {
			if (position == NodePosition.LEFT)
				n.setLeft(refRoot);
			else 
				n.setRight(refRoot);
			//Atualiza o pai da raiz
			if (refRoot != null)
				refRoot.setFather(n);
			//Atualiza a raiz
			refRoot = n;
			res = true;
			count++;
		}
		//Insere no meio da árvore
		else {
			nAux = searchNodeRef(father, refRoot);
			if (nAux != null) {
				n.setFather(nAux);
				if (position == NodePosition.LEFT) {
					//Insere como subárvore da esquerda
					n.setLeft(nAux.getLeft());
					if (nAux.getLeft() != null)
						nAux.getLeft().setFather(n);
					nAux.setLeft(n);
				}
				else {
					//Insere como subárvore da direita
					n.setRight(nAux.getRight());
					if (nAux.getRight() != null)
						nAux.getRight().setFather(n);
					nAux.setRight(n);
				}
				res = true;
				count++;
			}
		}
		return res;
	}

	public E getLeft(E element)
	{
		E res = null;
		Node<E> nAux = searchNodeRef(element, refRoot);
		if(nAux != null) {
			if(nAux.getLeft()!=null) {
				res = nAux.getLeft().getItem();
			}
		}
		return res;
	}

	public E getRight(E element)
	{
		E res = null;
		Node<E> nAux = searchNodeRef(element, refRoot);
		if(nAux != null) {
			if(nAux.getRight()!=null) {
				res = nAux.getRight().getItem();
			}
		}
		return res;
	}
	
	public E getFather(E element)
	{
		E res = null;
		Node<E> nAux = searchNodeRef(element, refRoot);
		if(nAux != null) {
			if(nAux.getFather()!=null) {
				res = nAux.getFather().getItem();
			}
		}
		return res;
	}
	
	public List<E> traversalPre()
	{
		List<E> res = new ArrayList<E>();
		traversalPreAux(refRoot, res);
		return res;
	}
	private void traversalPreAux(Node<E> n, List<E> res)
	{
		if (n != null) {
			res.add(n.getItem()); //Visita o nodo
			traversalPreAux(n.getLeft(), res); //Visita a subárvore da esquerda
			traversalPreAux(n.getRight(), res); //Visita a subárvore da direita
		} 

	}

	public List<E> traversalPos()
	{
		List<E> res = new ArrayList<E>();
		traversalPosAux(refRoot, res);
		return res;
	}
	private void traversalPosAux(Node<E> n, List<E> res)
	{
		if (n != null) {
			traversalPosAux(n.getLeft(), res); //Visita a subárvore da esquerda
			traversalPosAux(n.getRight(), res); //Visita a subárvore da direita
			res.add(n.getItem()); //Visita o nodo
		}
	}

	public List<E> traversalCentral()
	{
		List<E> res = new ArrayList<E>();
		traversalCentralAux(refRoot, res);
		return res;
	}
	private void traversalCentralAux(Node<E> n, List<E> res)
	{
		if (n != null) {
			traversalCentralAux(n.getLeft(), res); //Visita a subárvore da esquerda
			res.add(n.getItem()); //Visita o nodo
			traversalCentralAux(n.getRight(), res); //Visita a subárvore da direita
		}
	}
	
	public List<E> traversalWidth()
	{
		Queue<Node<E>> fila = new LinkedList<Node<E>>();
		Node<E> atual = null;
		List<E> res = new ArrayList<E>();
		if (refRoot != null) {
			fila.add(refRoot);
			while (!fila.isEmpty()) {
				atual = fila.remove();
				if (atual.getLeft() != null) {
					fila.add(atual.getLeft());
				}
				if (atual.getRight() != null) {
					fila.add(atual.getRight());
				}
				res.add(atual.getItem());				
			}
		}
		return res;
	}

	public String strTraversalPre()
	{
		return strTraversalPre(refRoot);
	}
	private String strTraversalPre(Node<E> n)
	{
		String res = "";
		if (n != null)
		{
			res = n.getItem().toString() + "\n" +
				  strTraversalPre(n.getLeft()) +
				  strTraversalPre(n.getRight());
		}
		return res;
	}

	public String strTraversalPos()
	{
		return strTraversalPos(refRoot);
	}
	private String strTraversalPos(Node<E> n)
	{
		String res = "";
		if (n != null)
		{
			res = strTraversalPos(n.getLeft()) +
				  strTraversalPos(n.getRight()) +
				  n.getItem().toString() + "\n";
		}
		return res;
	}

	public String strTraversalCentral()
	{
		return strTraversalCentral(refRoot);
	}
	private String strTraversalCentral(Node<E> n)
	{
		String res = "";
		if (n != null)
		{
			res = strTraversalCentral(n.getLeft()) +
			      n.getItem().toString() + "\n" +
				  strTraversalCentral(n.getRight());

		}
		return res;
	}
	
	public boolean contains(E element)
	{
		Node<E> nAux = searchNodeRef(element, refRoot);
		return (nAux != null);
	}
	private Node<E> searchNodeRef(E element, Node<E> target)
	{
		Node<E> res = null;
		if (target != null) {
			if(target.getItem().equals(element)) {
				res = target;
			}
		    else {
		    	res = searchNodeRef(element, target.getLeft());
		    	if (res == null) {
		    		res = searchNodeRef(element, target.getRight());
		    	}
		    }
		}
		return res;
	}

	public boolean removeBranch(E element)
	{
		Node<E> nAux = null;
		Node<E> father = null;
		int qtdAux = 0;
		boolean rem = false;
		if (refRoot != null) {
			if (refRoot.getItem().equals(element)) {
				refRoot = null;
				count = 0;
				rem = true;
			}
			else {
				nAux = searchNodeRef(element, refRoot);
				if (nAux != null) {
					qtdAux = count(nAux);
					father = nAux.getFather();
					if (father.getLeft() == nAux) {
						father.setLeft(null);
					}
					else if (father.getRight() == nAux) {
						father.setRight(null);
					}
					count = count - qtdAux;
					rem = true;
				}
			}
		}
		return rem;
	}

	public E set(E old, E element) {
		E res = null;
		Node<E> nAux = searchNodeRef(old, refRoot);
		if (nAux != null) {
			res = old;
			nAux.setItem(element);
		}
		return res;
	}
}
