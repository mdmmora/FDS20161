//package TAD.trees;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
///**
// * Classe que implementa o TAD Árvore Binária de Pesquisa
// * para uma árvore binária balanceada (AVL).
// * @author Michael Mora, Júlio Machado, Isabel Manssour
// */
//
//public class AVLLinked<E extends Comparable<E>> implements BinarySearchTreeTAD<E>  {
//	private Node<E> refRoot; //referência para o nodo raiz
//	
//	private static final class Node<T> {
//		private Node<T> father;
//		private Node<T> left;
//		private Node<T> right;
//		private T item;
//        private int height;
//        private int nodesAmount;		
//		
//		public Node(T element) {
//			father = null;
//			left = null;
//			right = null;
//			item = element;
//			height = 0;
//			nodesAmount = 1;
//		}
//		
//		public Node<T> getRight() {
//			return right;
//		}
//		public void setRight(Node<T> n) {
//			right = n;
//		}
//		public Node<T> getLeft() {
//			return left;
//		}
//		public void setLeft(Node<T> n) {
//			left = n;
//		}
//		public Node<T> getFather() {
//			return father;
//		}
//		public void setFather(Node<T> n) {
//			father = n;
//		}
//		public T getItem() {
//			return item;
//		}
//		public void setItem(T element) {
//			item = element;
//		}
//		public int getHeight() {
//			return height;
//		}
//		public void setHeight(int height) {
//			this.height = height;
//		}
//		public int getNodesAmount() {
//			return nodesAmount;
//		}
//		public void setNodesAmount(int nodes) {
//			this.nodesAmount = nodes;
//		}		
//	}
//
//
//	
//	public AVLLinked() {
//		refRoot = null;
//	}
//	
//	public boolean isEmpty()
//	{
//		return (refRoot == null);
//	}
//
//	public int size()
//	{
//		if (refRoot != null)
//			return refRoot.getNodesAmount();
//		else
//			return 0;
//	}
//
//	public E getRoot()
//	{
//		if(isEmpty())
//			throw new EmptyTreeException();
//		return refRoot.getItem();
//	}
//	
//	public int count()
//	{
//		return count(refRoot);
//	}
//	private int count(Node<E> n)
//	{
//		if (n == null) {
//			return 0;
//		}
//		else {
//			return 1 + count(n.getLeft()) + count(n.getRight());
//		}
//	}
//
//	public void add(E element)
//	{
//        Node<E> aux, auxP = null;
//
//        if (element == null)
//          return;
//        aux = new Node<E>(element);
//        if (refRoot == null)
//        {
//        	refRoot = aux;
//            return;
//        }
//        auxP = add(refRoot,element);
//        if (auxP == null)
//          return ;
//        if (auxP.getItem().compareTo(element) > 0)
//          auxP.setLeft(aux);
//        else
//          auxP.setRight(aux);
//        aux.setFather(auxP);
//        
//        this.nodesAmountAdjustment(auxP);
//        this.heightAdjustment(auxP);
//        this.balancing();
//    }
//    
//    private Node<E> add(Node<E> a, E e)
//    {
//        int r;
//
//        if (a == null)
//          return null;
//        r = a.getItem().compareTo(e);
//
//        if (r > 0)
//        {
//            if (a.getLeft() == null)
//              return a;
//            return add(a.getLeft(),e);
//        }
//        
//        if (a.getRight() == null)
//          return a;
//        return add(a.getRight(),e);
//    }
//    
//	public E getLeft(E element)
//	{
//		E res = null;
//		Node<E> nAux = searchNodeRef(element, refRoot);
//		if(nAux != null) {
//			if(nAux.getLeft()!=null) {
//				res = nAux.getLeft().getItem();
//			}
//		}
//		return res;
//	}
//
//	public E getRight(E element)
//	{
//		E res = null;
//		Node<E> nAux = searchNodeRef(element, refRoot);
//		if(nAux != null) {
//			if(nAux.getRight()!=null) {
//				res = nAux.getRight().getItem();
//			}
//		}
//		return res;
//	}
//	
//	public E getFather(E element)
//	{
//		E res = null;
//		Node<E> nAux = searchNodeRef(element, refRoot);
//		if(nAux != null) {
//			if(nAux.getFather()!=null) {
//				res = nAux.getFather().getItem();
//			}
//		}
//		return res;
//	}
//	
//	public List<E> traversalPre()
//	{
//		List<E> res = new ArrayList<E>();
//		traversalPreAux(refRoot, res);
//		return res;
//	}
//	private void traversalPreAux(Node<E> n, List<E> res)
//	{
//		if (n != null) {
//			res.add(n.getItem()); //Visita o nodo
//			traversalPreAux(n.getLeft(), res); //Visita a subárvore da esquerda
//			traversalPreAux(n.getRight(), res); //Visita a subárvore da direita
//		} 
//
//	}
//
//	public List<E> traversalPos()
//	{
//		List<E> res = new ArrayList<E>();
//		traversalPosAux(refRoot, res);
//		return res;
//	}
//	private void traversalPosAux(Node<E> n, List<E> res)
//	{
//		if (n != null) {
//			traversalPosAux(n.getLeft(), res); //Visita a subárvore da esquerda
//			traversalPosAux(n.getRight(), res); //Visita a subárvore da direita
//			res.add(n.getItem()); //Visita o nodo
//		}
//	}
//
//	public List<E> traversalCentral()
//	{
//		List<E> res = new ArrayList<E>();
//		traversalCentralAux(refRoot, res);
//		return res;
//	}
//	private void traversalCentralAux(Node<E> n, List<E> res)
//	{
//		if (n != null) {
//			traversalCentralAux(n.getLeft(), res); //Visita a subárvore da esquerda
//			res.add(n.getItem()); //Visita o nodo
//			traversalCentralAux(n.getRight(), res); //Visita a subárvore da direita
//		}
//	}
//	
//	public List<E> traversalWidth()
//	{	
//		Queue<Node<E>> fila = new LinkedList<Node<E>>();
//		Node<E> atual = null;
//		List<E> res = new ArrayList<E>();
//		if (refRoot != null) {
//			fila.offer(refRoot);
//			while (!fila.isEmpty()) {
//				atual = fila.poll();
//				if (atual.getLeft() != null) {
//					fila.offer(atual.getLeft());
//				}
//				if (atual.getRight() != null) {
//					fila.offer(atual.getRight());
//				}
//				res.add(atual.getItem());				
//			}
//		}
//		return res;
//	}
//
//	public String strTraversalPre()
//	{
//		return strTraversalPre(refRoot);
//	}
//	private String strTraversalPre(Node<E> n)
//	{
//		String res = "";
//		if (n != null)
//		{
//			res = n.getItem().toString() + "\n" +
//				  strTraversalPre(n.getLeft()) +
//				  strTraversalPre(n.getRight());
//		}
//		return res;
//	}
//
//	public String strTraversalPos()
//	{
//		return strTraversalPos(refRoot);
//	}
//	private String strTraversalPos(Node<E> n)
//	{
//		String res = "";
//		if (n != null)
//		{
//			res = strTraversalPos(n.getLeft()) +
//				  strTraversalPos(n.getRight()) +
//				  n.getItem().toString() + "\n";
//		}
//		return res;
//	}
//
//	public String strTraversalCentral()
//	{
//		return strTraversalCentral(refRoot);
//	}
//	private String strTraversalCentral(Node<E> n)
//	{
//		String res = "";
//		if (n != null)
//		{
//			res = strTraversalCentral(n.getLeft()) +
//			      n.getItem().toString() + "\n" +
//				  strTraversalCentral(n.getRight());
//
//		}
//		return res;
//	}
//	
//	
//	public String strTraversalCentralComplete()
//	{
//		return strTraversalCentralComplete(refRoot);
//	}
//	private String strTraversalCentralComplete(Node<E> n)
//	{
//		String res = "";
//		if (n != null)
//		{
//			res = strTraversalCentralComplete(n.getLeft()) +
//			      n.getItem().toString() + ", height " + n.getHeight() + ", nodes amount " + n.getNodesAmount() + "\n" +
//			      strTraversalCentralComplete(n.getRight());
//
//		}
//		return res;
//	}
//	public boolean contains(E element)
//	{
//		Node<E> nAux = searchNodeRef(element, refRoot);
//		return (nAux != null);
//	}
//	private Node<E> searchNodeRef(E element, Node<E> target)
//	{		
//        int r;
//
//        if (element == null || target == null)
//          return null;
//        
//        r = target.getItem().compareTo(element);
//        
//        if (r == 0)
//          return target;
//        else if (r > 0)
//            return searchNodeRef(element, target.getLeft());
//        else
//            return searchNodeRef(element, target.getRight());		
//	}
//
//	/**
//	 * Remove o nodo da árvore.
//	 * @param element Referência para o dado a ser removido.
//	 * @return true se a árvore contém o elemento especificado.
//	 */
//	public boolean remove(E element) 
//	{
//        Node<E> aux;
//        
//        if (element == null || refRoot == null)
//            return false;     
//        aux = searchNodeRef(element, refRoot);
//        if (aux == null)
//            return false;
//        remove(aux);
//        balancing();       
//        return true;  	
//	}
//    private void remove (Node<E> n){
//		Node<E> auxP, sb;
//		
//		auxP = n.getFather();
//		
//		if (n.getLeft() == null)
//		{
//		  if (n.getRight() == null)
//		  {
//		      if(refRoot == n)
//		      {
//		    	  refRoot = null;
//		          return;
//			  }
//			  if (auxP.getLeft() == n)
//			     auxP.setLeft(null);
//			  else
//			     auxP.setRight(null);
//				nodesAmountAdjustment(auxP);
//				heightAdjustment(auxP);
//				return; 
//			}
//			sb = smallest(n.getRight());
//			n.setItem(sb.getItem());
//			remove(sb);
//			return;
//		}		 
//		sb = biggest(n.getLeft());
//		n.setItem(sb.getItem());
//		remove(sb);
//    }	
//    
//	/**
//	 * Retorna referência para o nodo que contém o maior elemento da árvore
//	 * cuja raiz foi passada por parâmetro.
//	 * @param n nodo a partir do qual deve-se procurar o maior elemento.
//	 * @return referência para o nodo que contém o maior elemento.
//	 */	
//    private Node<E> biggest(Node<E> n){
//        if (n == null)
//          return null;
//        if (n.getRight() == null)
//          return n;
//        return biggest(n.getRight());
//    }     
//	
//	/**
//	 * Retorna referência para o nodo que contém o menor elemento da árvore
//	 * cuja raiz foi passada por parâmetro.
//	 * @param n nodo a partir do qual deve-se procurar o menor elemento.
//	 * @return referência para o nodo que contém o menor elemento.
//	 */	
//    private Node<E> smallest(Node<E> n){
//        if (n == null)
//          return null;
//        if (n.getLeft() == null)
//          return n;
//        return smallest(n.getLeft());
//    }   
//    
//	/**
//	 * Remove o nodo da árvore, juntamente com todos os seus filhos.
//	 * @param element Referência para o dado a ser removido.
//	 * @return true se a árvore contém o elemento especificado.
//	 */	
//	public boolean removeBranch(E element)
//	{
//		Node<E> nAux = null;
//		Node<E> father = null;
//		boolean rem = false;
//		if (refRoot != null) {
//			if (refRoot.getItem().equals(element)) {
//				refRoot = null;
//				rem = true;
//			}
//			else {
//				nAux = searchNodeRef(element, refRoot);
//				if (nAux != null) {
//					father = nAux.getFather();
//					if (father.getLeft() == nAux) {
//						father.setLeft(null);
//					}
//					else if (father.getRight() == nAux) {
//						father.setRight(null);
//					}
//					heightAdjustment(father);
//					nodesAmountAdjustment(father);
//					balancing();
//					rem = true;
//				}
//			}
//		}
//		return rem;
//	}
//
//    private int balancingFactor(Node<E> n)
//    {
//        int leftHeight, rigthHeight;
//        
//        if (n == null)
//            return 0;
//        
//        leftHeight = rigthHeight = -1;
//        
//        if (n.getLeft() != null)
//        	leftHeight = n.getLeft().getHeight();
//            
//        if (n.getRight() != null)
//        	rigthHeight = n.getRight().getHeight();
//            
//        return (leftHeight - rigthHeight);
//    }	
//	
//    private void heightAdjustment(Node<E> n)
//    {
//        int leftHeight, rigthHeight;
//
//        while (n != null) {
//        	leftHeight = rigthHeight = -1;
//            if (n.getLeft() != null)
//            	leftHeight = n.getLeft().getHeight();
//            if (n.getRight() != null) 
//            	rigthHeight = n.getRight().getHeight();
//
//            if (leftHeight > rigthHeight)
//                 n.setHeight(leftHeight+1);
//            else 
//                 n.setHeight(rigthHeight+1);
//            n = n.getFather();
//        }
//    }    
//    
//    
//    private void nodesAmountAdjustment(Node<E> n)
//    {
//        int leftAmount, rightAmount;
//
//        while (n != null) {
//        	leftAmount = rightAmount = 0;
//            if (n.getLeft() != null)
//            	leftAmount = n.getLeft().getNodesAmount();
//            if (n.getRight() != null) 
//            	rightAmount = n.getRight().getNodesAmount();
//
//            n.setNodesAmount(leftAmount+rightAmount+1);
//            n = n.getFather();
//        }       
//    }  
//    
//    public void balancing()
//    {
//        int bf;
//        bf = balancingFactor(refRoot);
//        if (bf > 1)
//           if (balancingFactor(refRoot.getLeft()) > 0)
//               rotationLL(refRoot);
//           else
//               rotationLR(refRoot);
//        else if (bf < -1)
//           if (balancingFactor(refRoot.getRight()) < 0)
//               rotationRR(refRoot);
//           else 
//               rotationRL(refRoot);
//    }    
//    
//    private void rotationLL(Node<E> n)
//    {
//       Node<E> temp, pai = n.getFather();
//       temp = n.getLeft();
//       n.setLeft(temp.getRight());
//       if (n.getLeft()!= null)
//           n.getLeft().setFather(n);
//       temp.setRight(n);
//       n.setFather(temp);
//       n = temp;
//       n.setFather(pai);
//       if (pai == null)
//           refRoot = n;
//       else					// Linha 1 incluída
//    	   pai.setRight(n); // Linha 2 incluída
//       heightAdjustment(n.getRight());
//       nodesAmountAdjustment(n.getRight());       
//    }    
//    
//    private void rotationRR(Node<E> n)
//    {
//       Node<E> temp, pai = n.getFather();
//       temp = n.getRight();
//       n.setRight(temp.getLeft());
//       if (n.getRight()!= null)
//           n.getRight().setFather(n);
//       temp.setLeft(n);
//       n.setFather(temp);
//       n = temp;
//       n.setFather(pai);
//       if (pai == null)
//    	   refRoot = n;
//       else					// Linha 1 incluída
//    	   pai.setLeft(n);	// Linha 2 incluída
//       heightAdjustment(n.getLeft());
//       nodesAmountAdjustment(n.getLeft());
//    } 
//    
//    private void rotationLR(Node<E> n) 
//    {
//    	rotationRR(n.getLeft());
//    	rotationLL(n);
//    }
//      
//    private void rotationRL(Node<E> n) 
//    {
//    	rotationLL(n.getRight());
//        rotationRR(n);   
//    }
//    
//    public boolean isBalanced()
//    {
//        return isBalanced(refRoot);
//    }
//       
//    private boolean isBalanced(Node<E> n)
//    {
//        if (balancingFactor(n)<=1 && balancingFactor(n)>=-1)
//            return true;
//        else
//            return false;
//    }    
//    
//	public E set(E old, E element) {
//		E res = null;
//    	boolean b = remove(old);
//    	if (b){
//    		add(element);
//    		res = old;
//    	}
//		return res;
//	}
//	
//    public int height () {
//        if (refRoot == null)
//            return -1;
//        return refRoot.getHeight();
//    }    
//    
//    public boolean isRoot(E element)
//    {
//    	if (refRoot != null)
//            if (refRoot.getItem().equals(element))
//            	return true;
//         return false;
//    }    
//    
//    public boolean isLeave(E element)
//    {
//        if (refRoot == null)
//            return false;
//            
//        Node<E> aux = searchNodeRef(element, refRoot);
//        if (aux == null)
//            return false;
//        else if (aux.getLeft()==null && aux.getRight()==null)
//            return true;
//        else
//            return false;
//    }
//    
//    public boolean isBranch(E element)
//    {
//        if (refRoot == null)
//            return false;
//        else if (refRoot.getItem().equals(element))
//        	return false;
//        Node<E> aux = searchNodeRef(element, refRoot);
//        if (aux == null)
//            return false;
//        else if (aux.getLeft()!=null || aux.getRight()!=null)
//            return true;
//        else
//            return false;
//    }    
//    
//    public int level(E element)
//    {
//        Node<E> aux = searchNodeRef(element, refRoot);
//        if (aux == null)
//            return -1;    
//        Node<E> father = aux.getFather();
//        if (father == null)
//            return 0;
//        else
//            return 1 + level(father.getItem());
//    }      
//    
//	public int countLeaves() {
//		return countLeaves(refRoot);
//	}
//	private int countLeaves(Node<E> n) {
//		int res = 0;
//		
//		if (n != null)		{
//			if ((n.getLeft() == null) &&  (n.getRight() == null))
//				res = 1;
//			else 
//				res = countLeaves(n.getLeft()) +  countLeaves(n.getRight());
//		}
//		return res;
//	}    
//	
//	public int countBranches() {
//		return countBranches(refRoot);
//	}
//	private int countBranches(Node<E> n) {
//		int res = 0;
//		
//		if (n != null)		{
//			if ( n.getFather()!=null && (n.getLeft()!=null || n.getRight()!=null) )
//				res = 1 + countBranches(n.getLeft()) +  countBranches(n.getRight());
//			else 
//				res = countBranches(n.getLeft()) +  countBranches(n.getRight());
//		}
//		return res;
//	}	
//	
//	public ArrayList<E> getElements() {
//		//return (ArrayList<E>)traversalCentral();
//		ArrayList<E> a = new ArrayList<E>();
//		a = (ArrayList<E>)traversalCentral();
//		return a;
//	}
//}
