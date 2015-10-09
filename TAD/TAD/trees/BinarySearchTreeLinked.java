package TAD.trees;

import java.io.Serializable;
import java.util.*;

import TAD.queue.Queue;
import TAD.queue.QueueTAD;
import TAD.stack.Stack;
import TAD.stack.StackTAD;


/**
 * Classe que implementa o TAD Árvore Binária de Pesquisa.
 * @author Michael Mora, Júlio Machado, Isabel Manssour
 * TO DO: revisar interface para que seja o mais compatível possível
 * com ArvBin (tipos de retorno, em particular); acrescentar um "iterador"
 * com controle left e right
 */

public class BinarySearchTreeLinked<E extends Comparable<E>> implements BinarySearchTreeTAD<E> {
	private int count; //contagem do nÃºmero de nodos
	private Node<E> refRoot; //referÃªncia para o nodo raiz
	
	private static final class Node<T extends Comparable<T>> implements Comparable<Node<T>>, Serializable {
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
		
		public int compareTo(Node<T> arg0) {
			return this.getItem().compareTo(arg0.getItem());
		}		
	}

	private final class IteratorWidth implements IteratorBinTree<E> {
		
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
			Node<E> aux;
			
			if (fila.first() != null){
				aux = fila.dequeue();
				
				if (aux.getLeft() != null)
					fila.enqueue(aux.getLeft());
				if (aux.getRight() != null)
					fila.enqueue(aux.getRight());
				
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
	
		public E getLeft() {
			E res = null;
			Node<E> aux;
			
			if (!fila.isEmpty()) {
				aux = fila.first();
				
				if (aux.getLeft() != null)
					res = aux.getLeft().getItem();
			}
			else
				throw new EmptyTreeException();
			
			return res;
		}
	
		public E getRight() {
			E res = null;
			Node<E> aux;
			
			if (!fila.isEmpty()) {
				aux = fila.first();
				
				if (aux.getRight() != null)
					res = aux.getRight().getItem();
			}
			else
				throw new EmptyTreeException();
			
			return res;
		}
				
	}
	
	private final class IteratorPre implements IteratorBinTree<E> {
	
		private StackTAD<Node<E>> pilha = new Stack<Node<E>>();
		
		public IteratorPre() {
			if (refRoot != null)
				pilha.push(refRoot);
		}
		
		public boolean hasNext() {
			boolean res = false;
			
			if (!pilha.isEmpty())
				res = true;
			
			return res;
		}
	
		public E next() {
			E res = null;
			Node<E> aux;
			
			if (pilha.top() != null){
				aux = pilha.pop();
				
				if (aux.getRight() != null)
					pilha.push(aux.getRight());
				if (aux.getLeft() != null)
					pilha.push(aux.getLeft());
				
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
			
			if (!pilha.isEmpty()) {
				aux = pilha.top();
				
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
			
			if (!pilha.isEmpty()) {
				aux = pilha.top();
				
				res = aux.getItem();
			}
			else
				throw new EmptyTreeException();
			
			return res;
		}
	
		public E getLeft() {
			E res = null;
			Node<E> aux;
			
			if (!pilha.isEmpty()) {
				aux = pilha.top();
				
				if (aux.getLeft() != null)
					res = aux.getLeft().getItem();
			}
			else
				throw new EmptyTreeException();
			
			return res;
		}
	
		public E getRight() {
			E res = null;
			Node<E> aux;
			
			if (!pilha.isEmpty()) {
				aux = pilha.top();
				
				if (aux.getRight() != null)
					res = aux.getRight().getItem();
			}
			else
				throw new EmptyTreeException();
			
			return res;
		}
				
	}

	
	private final class Navigator implements NavigatorBinTree<E> {
		private Node<E> current;
		
		public Navigator() {
			current = refRoot;
		}

		//Esta operação não faz sentido para ABP´s
		public boolean add(E elem, NodePosition position) {
			return false;
		}

		//@Override
		//public E remove() {
			// TODO Auto-generated method stub
		//	return null;
		//}

		public boolean goLeft() {
			boolean res = true;
			
			if (current != null && current.getLeft() != null)
				current = current.getLeft();
			else
				res = false;
			
			return res;
		}

		public boolean goRight() {
		boolean res = true;
			
			if (current != null && current.getRight() != null)
				current = current.getRight();
			else
				res = false;
			
			return res;
		}

		public boolean goFather() {
			boolean res = true;
			
			if (current != null && current.getFather() != null)
				current = current.getFather();
			else
				res = false;
			
			return res;
		}

		public boolean hasLeft() {
			boolean res = false;
			
			if ((current != null) && (current.getLeft() != null))
				res = true;
				
			return res;
		}

		public boolean hasRight() {
			boolean res = false;
			
			if ((current != null) && (current.getRight() != null))
				res = true;
				
			return res;
		}

		public boolean hasFather() {
			boolean res = false;
			
			if ((current != null) && (current.getFather() != null))
				res = true;
				
			return res;
		}

		public E getItem() {
			E res = null;
			
			if (current != null)
				res = current.getItem();
				
			return res;
		}
		
		public boolean setItem(E item) {
			boolean res = true;
			
			if (current != null)
				current.setItem(item);
			else
				res = false;
				
			return res;
		}

		public E search(E elem) {
			Node<E> aux = searchNodeRef(elem, refRoot);
			E res = null;
			
			current = aux;
			if (current != null)
				res = current.getItem();
			
			return res;
		}

		public boolean goRoot() {
			boolean res = true;
			
			current = refRoot;
			
			return res;
		}
	}

	public Iterator<E> iterator() {
		Iterator<E> it = new IteratorPre();
		
		return it;
	}
	
	public Iterator<E> iterator(IteratorTreeType t){
		Iterator<E> it = null;
		
		if (t.equals(IteratorTreeType.WIDTH)) 
			it = new IteratorWidth();
		else if (t.equals(IteratorTreeType.POST))
			it = null;
		else if (t.equals(IteratorTreeType.PRE))
			it = new IteratorPre();
		else if (t.equals(IteratorTreeType.CENTRAL))
			it = null;
		
		return it;
		}
	
	public NavigatorBinTree<E> navigator() {
		NavigatorBinTree<E> nav = new Navigator();
		
		return nav;
	}
	
	public BinarySearchTreeLinked() {
		count = 0;
		refRoot = null;
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
	
	public void addRec(E element)
	{
		refRoot = addRec(refRoot, element, null);
		count++;
	}

    private Node<E> addRec(Node<E> n, E e, Node<E> father) 
    {
        if (n == null){
        	Node<E> aux = new Node<E>(e);
        	aux.setFather(father);
            return aux;
        }
        if ( n.getItem().compareTo(e) < 0 )
            n.setRight( addRec(n.getRight(),e, n) );
        else
            n.setLeft( addRec(n.getLeft(),e, n) );
        return n;
    }
  //<<<<<------  Incluir no código de teste!!!!
    public void add(E element){   
    	Node<E> auxN = refRoot, auxPai = null, novo = new Node<E>(element);
    	int auxC = 0;
    	
    	if (refRoot == null)
    		refRoot = novo;
    	else {
    		  while(auxN != null) {
    			  auxPai = auxN;
    			  auxC = element.compareTo(auxN.getItem());
    			  
    			  if (auxC < 0)
    				  auxN = auxN.getLeft();
    			  else 
    				  auxN = auxN.getRight();
    		  }
    		  
    		  novo.setFather(auxPai);
    		  if (auxC < 0)
    			  auxPai.setLeft(novo);
    		  else
    			  auxPai.setRight(novo);
    	}
    	count++;
    }
    
    
    public E get(E element){
    	E res = null;
    	
		Node<E> nAux = searchNodeRef(element, refRoot);
		if(nAux != null)
			res = nAux.getItem();
		
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
			traversalPreAux(n.getLeft(), res); //Visita a subÃ¡rvore da esquerda
			traversalPreAux(n.getRight(), res); //Visita a subÃ¡rvore da direita
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
			traversalPosAux(n.getLeft(), res); //Visita a subÃ¡rvore da esquerda
			traversalPosAux(n.getRight(), res); //Visita a subÃ¡rvore da direita
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
			traversalCentralAux(n.getLeft(), res); //Visita a subÃ¡rvore da esquerda
			res.add(n.getItem()); //Visita o nodo
			traversalCentralAux(n.getRight(), res); //Visita a subÃ¡rvore da direita
		}
	}
	
	public List<E> traversalWidth()
	{
		Queue<Node<E>> fila = new Queue<Node<E>>();
		Node<E> atual = null;
		List<E> res = new ArrayList<E>();
		
		if (refRoot != null) {
			fila.enqueue(refRoot);
			while (!fila.isEmpty()) {
				atual = fila.dequeue();
				if (atual.getLeft() != null) {
					fila.enqueue(atual.getLeft());
				}
				if (atual.getRight() != null) {
					fila.enqueue(atual.getRight());
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
			res = n.getItem().toString() + " " +
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
				  n.getItem().toString() + " " ;
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
			      n.getItem().toString() + " " +
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
        int r;

        if (element == null || target == null)
          return null;
        
        r = element.compareTo(target.getItem());
        
        if (r == 0)
          return target;
        else if (r < 0)
            return searchNodeRef(element, target.getLeft());
        else
            return searchNodeRef(element, target.getRight());		
	}
	
	public E search(E element){
		E res = null;
		Node <E> aux = searchNodeRef(element, refRoot);
		
		if (aux != null)
			res = aux.getItem();
		
		return res;
	}

	/**
	 * Remove o nodo da árvore.
	 * @param element Referência para o dado a ser removido.
	 * @return true se a árvore contém o elemento especificado.
	 */
	public E remove(E element) 
	{
        E res = null;
		
		Node<E> aux;
        if (element != null && refRoot != null) {
            aux = searchNodeRef(element, refRoot);
            if (aux != null){
            	res = aux.getItem();
                remove(aux);
                count--;
            }
        }
        return res;  	
	}
    private void remove (Node<E> n){
        Node<E> aux, m;
        aux = n.getFather();
        if (n.getLeft() == null) {
            if (n.getRight() == null) {  //Nodo a excluir é Folha
                if (refRoot == n) {
                	refRoot = null;
                    return;
                }
                if (aux.getLeft() == n)
                    aux.setLeft(null);
                else
                    aux.setRight(null);
                return;
            }
            else { //Esquerda Nula e Direita Não
                if (refRoot == n) {
                	refRoot = n.getRight();    
                    return;
                }    
                if (aux.getLeft() == n) {
                    aux.setLeft(n.getRight());
                    n.getRight().setFather(aux);
                }
                else {
                    aux.setRight(n.getRight());
                    n.getRight().setFather(aux);
                }
            }
            return;
        }

        if ( n.getRight() == null ) { //Direita Nula e Esquerda Não
            if (refRoot == n) {
            	refRoot = n.getLeft();    
                 return;
            }                
            if ( aux.getLeft() == n ){
                 aux.setLeft(n.getLeft());
                 n.getLeft().setFather(aux);
            }
            else {
                 aux.setRight(n.getLeft());
                 n.getLeft().setFather(aux);
            }
            return;
        }

        //Esquerda e Direita Não Nulas
        m = smallest(n.getRight());
        n.setItem(m.getItem());
        remove(m);
    }	
	
	/**
	 * Retorna referência para o nodo que contém o menor elemento da árvore
	 * cuja raiz foi passada por parâmetro.
	 * @param n nodo a partir do qual deve-se procurar o menor elemento.
	 * @return referência para o nodo que contém o menor elemento.
	 */	
    private Node<E> smallest(Node<E> n){
        if (n == null)
          return null;
        if (n.getLeft() == null)
          return n;
        return smallest(n.getLeft());
    }   
    
	/**
	 * Remove o nodo da árvore, juntamente com todos os seus filhos.
	 * @param element Referência para o dado a ser removido.
	 * @return true se a árvore contém o elemento especificado.
	 */	
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
    	E b = remove(old);
    	if (b != null){
    		addRec(element);
    		res = b;
    	}
		return res;
	}
	
    public int height () {
        return height(refRoot);
    }    
    
    private int height (Node<E> n) {
        if (n == null) 
            return -1;
        else {
            int heightLeft = height(n.getLeft());
            int heightRight = height(n.getRight());
            if (heightLeft < heightRight) 
                return heightRight + 1;
            else 
                return heightLeft + 1;
        }
    }	
    
    public boolean isRoot(E element)
    {
    	if (refRoot != null)
            if (refRoot.getItem().equals(element))
            	return true;
         return false;
    }    
    
    public boolean isLeave(E element)
    {
        if (refRoot == null)
            return false;
            
        Node<E> aux = searchNodeRef(element, refRoot);
        if (aux == null)
            return false;
        else if (aux.getLeft()==null && aux.getRight()==null)
            return true;
        else
            return false;
    }
    
    public boolean isBranch(E element)
    {
        if (refRoot == null)
            return false;
        else if (refRoot.getItem().equals(element))
        	return false;
        Node<E> aux = searchNodeRef(element, refRoot);
        if (aux == null)
            return false;
        else if (aux.getLeft()!=null || aux.getRight()!=null)
            return true;
        else
            return false;
    }    
    
    public int level(E element)
    {
        Node<E> aux = searchNodeRef(element, refRoot);
        if (aux == null)
            return -1;    
        Node<E> father = aux.getFather();
        if (father == null)
            return 0;
        else
            return 1 + level(father.getItem());
    }      
    
	public int countLeaves() {
		return countLeaves(refRoot);
	}
	private int countLeaves(Node<E> n) {
		int res = 0;
		
		if (n != null)		{
			if ((n.getLeft() == null) &&  (n.getRight() == null))
				res = 1;
			else 
				res = countLeaves(n.getLeft()) +  countLeaves(n.getRight());
		}
		return res;
	}    
	
	public int countBranches() {
		return countBranches(refRoot);
	}
	private int countBranches(Node<E> n) {
		int res = 0;
		
		if (n != null)		{
			if ( n.getFather()!=null && (n.getLeft()!=null || n.getRight()!=null) )
				res = 1 + countBranches(n.getLeft()) +  countBranches(n.getRight());
			else 
				res = countBranches(n.getLeft()) +  countBranches(n.getRight());
		}
		return res;
	}	
}
