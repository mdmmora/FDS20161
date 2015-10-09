package TAD.trees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import TAD.queue.Queue;
import TAD.queue.QueueTAD;


public class GeneralTreeLinked<E extends Comparable<E>> implements GeneralTreeTAD<E>, Iterable<E>
{
	private Node<E> refRoot;

	private static final class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
		private Node<T> father;
		private T item;
		private List<Node<T>> subtrees;

		public Node(T element) {
			father = null;
			item = element;
			subtrees = new LinkedList<Node<T>>();
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
		public void addSubtree(Node<T> n) {
			n.setFather(this);
			subtrees.add(n);
		}
		public boolean removeSubtree(Node<T> n) {
			n.setFather(null);
			return subtrees.remove(n);
		}
		public Node<T> getSubtree(int i) {
			if((i<0) || (i>=subtrees.size()))
				throw new IndexOutOfBoundsException();
			return subtrees.get(i);
		}
		public int countSubtrees() {
			return subtrees.size();
		}
		public int compareTo(Node<T> o) {
			return this.getItem().compareTo(o.getItem());
		}
	}

	private final class IteratorWidth implements IteratorGeneralTree<E> {
		private QueueTAD<Node<E>> fila = new Queue<Node<E>>();

		public IteratorWidth() {
			if (refRoot != null)
				fila.enqueue(refRoot);
			else
				throw new EmptyTreeException();
		}

		public boolean hasNext() {
			boolean res = false;

			if (!fila.isEmpty())
				res = true;

			return res;
		}

		public E next() {
			E res = null;
			Node<E> aux, filAux;
			int totFil;

			if (fila.first() != null){
				aux = fila.dequeue();

				totFil = aux.countSubtrees();
				for (int i = 0; i < totFil; i++) {
					filAux = aux.getSubtree(i);
					if (filAux != null)
						fila.enqueue(filAux);
				}

				res = aux.getItem();
			}

			return res;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		public E getFather() {
			E res = null;
			Node<E> aux;

			if (!fila.isEmpty()) {
				aux = fila.first();

				if (aux.getFather() != null)
					res = aux.getFather().getItem();
			}
			else
				throw new EmptyTreeException();

			return res;
		}

		public E getElem() {
			E res = null;
			Node<E> aux;

			if (!fila.isEmpty()) {
				aux = fila.first();

				res = aux.getItem();
			}
			else
				throw new EmptyTreeException();

			return res;
		}

		public E getChild(int id) {
			E res = null;
			Node<E> aux;

			if (!fila.isEmpty()) {
				aux = fila.first();

				if (id <= aux.countSubtrees()) 
					res = aux.getSubtree(id).getItem();
			}
			else
				throw new EmptyTreeException();

			return res;
		}		
	}

	public GeneralTreeLinked()
	{
		refRoot = null;
	}

	public boolean add(E element, E father) {
		Node<E> n = new Node<E>(element);
		Node<E> nAux = null;
		boolean res = false;
		//Verifica se est√° inserindo na raiz
		if (father == null) {
			//Atualiza o pai da raiz
			if (refRoot != null) {
				n.addSubtree(refRoot);
				refRoot.setFather(n);
			}
			//Atualiza a raiz
			refRoot = n;
			res = true;
		}
		//Insere no meio da √°rvore
		else {
			nAux = searchNodeRef(father, refRoot);
			if (nAux != null) {
				nAux.addSubtree(n);
				res = true;
			}
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
				Node<E> aux = null;
				int i = 0;
				while((aux == null) && (i < target.countSubtrees())) {
					aux = searchNodeRef(element, target.getSubtree(i));
					i++;
				}
				res = aux;
			}
		}
		return res;
	}

	public E get(E element, int i) {
		E res = null;
		Node<E> nAux = searchNodeRef(element, refRoot);
		if(nAux != null) {
			res = nAux.getSubtree(i).getItem();
		}
		return res;		
	}

	public E getFather(E element) {
		E res = null;
		Node<E> nAux = searchNodeRef(element, refRoot);
		if(nAux != null) {
			if(nAux.getFather()!=null) {
				res = nAux.getFather().getItem();
			}
		}
		return res;
	}

	public E getRoot() {
		if(isEmpty())
			throw new EmptyTreeException();
		return refRoot.getItem();
	}

	public boolean isEmpty() {
		return (refRoot == null);
	}

	public boolean removeBranch(E element) {
		Node<E> nAux = null;
		Node<E> father = null;
		boolean rem = false;
		if (refRoot != null) {
			if (refRoot.getItem().equals(element)) {
				refRoot = null;
				rem = true;
			}
			else {
				nAux = searchNodeRef(element, refRoot);
				if (nAux != null) {
					father = nAux.getFather();
					father.removeSubtree(nAux);
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

	public void setRoot(E element) {
		if(isEmpty())
			throw new EmptyTreeException();
		refRoot.setItem(element);
	}

	public int count() {
		return count(refRoot);
	}
	private int count(Node<E> target)
	{
		if (target == null) {
			return 0;
		}
		int total = 1;
		for(int i=0; i<target.countSubtrees(); i++)
			total += count(target.getSubtree(i));
		return total;
	}

	public Iterator<E> iterator() {
		Iterator<E> it = new IteratorWidth();

		return it;
	}

	public Iterator<E> iterator(IteratorTreeType t){
		Iterator<E> it = null;

		if (t.equals(IteratorTreeType.WIDTH)) 
			it = new IteratorWidth();
		else if (t.equals(IteratorTreeType.POST))
			it = null;
		else if (t.equals(IteratorTreeType.PRE))
			it = null;
		else if (t.equals(IteratorTreeType.CENTRAL))
			it = null;

		return it;
	}


	public List<E> traversalPos()
	{
		List<E> res = new ArrayList<E>();
		traversalPos(refRoot, res);
		return res;
	}
	private void traversalPos(Node<E> n, List<E> res)
	{
		if (n != null) {
			for(int i=0; i<n.countSubtrees(); i++) {
				traversalPos(n.getSubtree(i), res);
			}
			res.add(n.getItem());
		}
	}

	public List<E> traversalPre()
	{
		List<E> res = new ArrayList<E>();
		traversalPre(refRoot, res);
		return res;
	}
	private void traversalPre(Node<E> n, List<E> res)
	{
		if (n != null) {
			res.add(n.getItem());
			for(int i=0; i<n.countSubtrees(); i++) {
				traversalPre(n.getSubtree(i), res);
			}
		}
	}

	public List<E> traversalWidth() {
		QueueTAD<Node<E>> fila = new Queue<Node<E>>();
		Node<E> atual = null;
		List<E> res = new ArrayList<E>();
		if (refRoot != null) {
			fila.enqueue(refRoot);
			while (!fila.isEmpty()) {
				atual = fila.dequeue();
				res.add(atual.getItem());
				for(int i=0; i<atual.countSubtrees(); i++) {
					fila.enqueue(atual.getSubtree(i));
				}
			}
		}
		return res;
	}    

	//***********************************************************
	//* Exercicios sobre estruturas em ·rvores. N„o fazem parte 
	//* da interface padr„o. N„o entregar antes de passar o 
	//* exercÌcio.
	//***********************************************************

	public boolean hasRepeat(E el) { 
		int cont = 0;
		boolean res;
		if  (hasRepeat(el, refRoot, cont) <= 1)
			res = false;
		else
			res = true;

		return res;
	}

	private int hasRepeat(E el, Node<E> n, int cont) {
		if (n != null) {
			if (el.equals(n.getItem()))
				cont ++;
			if (cont <= 1){
				for (int i = 0; ((i < n.countSubtrees()) && (cont <=1)); i++)
					cont += hasRepeat(el, n.getSubtree(i), cont);
			}
		}
		return cont;
	}


	public List<E> getInternalElelments() {
		return getInternalElements(refRoot, new ArrayList<E>());
	}

	private List<E> getInternalElements(Node<E> n, List<E> lst) {
		List<E> auxL;

		if (n != null) {
			if ((n != refRoot) && (n.countSubtrees() > 0))
				lst.add(n.getItem());

			for (int i = 0; i < n.countSubtrees(); i++)
				lst = getInternalElements(n.getSubtree(i), lst);
		}

		return lst;
	}

	public int getPathSize(E element) {
		int res = -1;

		Node<E> aux = getNodetoPathSize(element, refRoot);

		if (aux != null)
			while (aux != null) {
				aux = aux.getFather();
				res++;
			}

		return res;
	}

	private Node<E> getNodetoPathSize(E element, Node<E> n){
		Node<E> res = null;

		if (n != null)
			if (element.equals(n.getItem()))
				res = n;
			else for (int i = 0; i < n.countSubtrees(); i++) {
				res = getNodetoPathSize(element, n.getSubtree(i));
				if (res != null)
					break;
			}

		return res;
	}

	public int countBiggerThan(E elem) {
		return countBiggerThan(elem, refRoot);
	}
	private int countBiggerThan(E elem, Node<E> target)
	{
		if (target == null) {
			return 0;
		}
		int total = 0;

		if (target.getItem().compareTo(elem) > 0)
			total = 1;

		for(int i=0; i<target.countSubtrees(); i++)
			total += countBiggerThan(elem, target.getSubtree(i));
		return total;
	}

	public String toString() {
		StringBuilder str = new StringBuilder("");
		String res;
		int level = 0;

		if (refRoot == null)
			res = null;
		else {
			toStringFunc(refRoot, str, level);
			res = str.toString();
		}
		return res;
	}

	private void toStringFunc(Node<E> n, StringBuilder str, int level) {
		String tabs;
		
		if (n != null){
			str.append("tree(" + n.getItem());

			level++;
			for (int i = 0; i < n.subtrees.size(); i++){
				str.append(",");
				
				tabFill(tabs, level);
				
				toStringFunc(n.subtrees.get(i), str);
			}
			
			level--;
			tabFill(tabs, level);
			str.append(")");
		}
	}
}
