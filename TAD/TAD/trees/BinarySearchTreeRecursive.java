package TAD.trees;

/*@author Júlio Machado
 * 
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTreeRecursive<E extends Comparable<E>> {
	private BinarySearchTreeRecursive<E> parent; // nó pai
	private E item; // raiz
	private BinarySearchTreeRecursive<E> left; // subárvore esquerda
	private BinarySearchTreeRecursive<E> right; // subárvore direita

	public BinarySearchTreeRecursive(E element) {
		parent = null;
		item = element;
		left = null;
		right = null;
	}
	
	public void add(E element){
		if (item.compareTo(element) > 0) {
			if (left != null)
				left.add(element);
			else
				addLeft(new BinarySearchTreeRecursive<E>(element));
		}
		else {
			if (right != null)
				right.add(element);
			else
				addRight(new BinarySearchTreeRecursive<E>(element));			
		}
	}
	
	public boolean contains(E element) {
		if (item.equals(element)) {
			return true;
		}
		if (item.compareTo(element) > 0) {
			if (left != null)
				return left.contains(element);
		}
		else {
			if (right != null)
				return right.contains(element);
		}
		return false;
	}
	

	public boolean remove(E element) {
		BinarySearchTreeRecursive<E> no = containsRef(element);
		if(no == null)
			return false;
		return no.remove();
	}
	
	private boolean remove() {
		BinarySearchTreeRecursive<E> no = this;
		BinarySearchTreeRecursive<E> pai = no.getParent();
		if(no.getLeft() == null){//Nao tem subarvore esquerda
			if(no.getRight() == null){//Nao tem subarvore esquerda, Nao tem subarvore direita
				//No e uma folha
				if(pai == null) //No esta na raiz
					return false; //Impossivel remover a raiz sem filhos
				if(pai.getLeft() == no) //No a ser removido esta na esquerda
					pai.removeLeft();
				else //No a ser removido esta na direita
					pai.removeRight();
			}
			else {//Nao tem subarvore esquerda, tem subarvore direita
				if(pai == null) //No esta na raiz
					no.removeRight();
				if(pai.getLeft() == no){ //No a ser removido esta na esquerda
					pai.removeLeft();
					pai.addLeft(no.getRight());
				}
				else {//No a ser removido esta na direita
					pai.removeRight();
					pai.addRight(no.getRight());
				}
			}
			return true;
		}
		else {//Tem subarvore esquerda
			if(no.getRight() == null){//Tem subarvore esquerda, Nao tem subarvore direita
				if(pai == null) //No esta na raiz
					no.removeLeft();
				if(pai.getLeft() == no){ //No a ser removido esta na esquerda
					pai.removeLeft();
					pai.addLeft(no.getLeft());
				}
				else {//No a ser removido esta na direita
					pai.removeRight();
					pai.addRight(no.getLeft());
				}
				return true;
			}
			else {//Tem subarvore esquerda, tem subarvore direita
				BinarySearchTreeRecursive<E> menorDaDireita = no.getRight().smallest();
				no.setItem(menorDaDireita.getItem());
				return menorDaDireita.remove();
			}
		}		
	}









	private BinarySearchTreeRecursive<E> smallest() {
		BinarySearchTreeRecursive<E> target = this;
		while(target.getLeft() != null)
			target = target.getLeft();
		return target;
	}
	
	private int getDegree() {
		int d = 0;
		if(left != null) d++;
		if(right != null) d++;
		return d;
	}
	
	
	private BinarySearchTreeRecursive<E> containsRef(E element) {
		if (item.equals(element)) {
			return this;
		}
		if (item.compareTo(element) > 0) {
			if (left != null)
				return left.containsRef(element);
		}
		else {
			if (right != null)
				return right.containsRef(element);
		}
		return null;		
	}
	
	private BinarySearchTreeRecursive<E> getParent() {
		return parent;
	}
	
	private void setParent(BinarySearchTreeRecursive<E> tree) {
		parent = tree;
	}
	
	public E getItem() {
        return item;
    }

    private void setItem(E element) {
        item = element;
    }
    
	private BinarySearchTreeRecursive<E> getLeft() {
		return left;
	}

	private BinarySearchTreeRecursive<E> getRight() {
		return right;
	}

	private void addLeft(BinarySearchTreeRecursive<E> tree) {
		left = tree;
		tree.setParent(this);
	}

	private void addRight(BinarySearchTreeRecursive<E> tree) {
		right = tree;
		tree.setParent(this);
	}

	private BinarySearchTreeRecursive<E> removeLeft() {
		BinarySearchTreeRecursive<E> subtree = left;
		left = null;
		subtree.setParent(null);
		return subtree;
	}

	private BinarySearchTreeRecursive<E> removeRight() {
		BinarySearchTreeRecursive<E> subtree = right;
		right = null;
		subtree.setParent(null);
		return subtree;
	}

	// Outros métodos
	
	public int size() {
		int total = 1;
		if (left != null)
			total += left.size();
		if (right != null)
			total += right.size();
		return total;
	}

	public List<E> traversalPre() {
        List<E> res = new ArrayList<E>();
        traversalPreAux(this, res);
        return res;
    }

    private void traversalPreAux(BinarySearchTreeRecursive<E> tree, List<E> res) {
        res.add(tree.getItem());
        if (tree.getLeft() != null)
        	traversalPreAux(tree.getLeft(), res);
        if (tree.getRight() != null)
        	traversalPreAux(tree.getRight(), res);
    }

    
    public List<E> traversalPos() {
        List<E> res = new ArrayList<E>();
        traversalPosAux(this, res);
        return res;
    }

    private void traversalPosAux(BinarySearchTreeRecursive<E> tree, List<E> res) {
        if (tree.getLeft() != null)
        	traversalPosAux(tree.getLeft(), res);
        if (tree.getRight() != null)
        	traversalPosAux(tree.getRight(), res);
        res.add(tree.getItem());
    }
    
    
    
    
    
    
    
    
    public List<E> traversalBreadth() {
        Queue<BinarySearchTreeRecursive<E>> fila = new LinkedList<BinarySearchTreeRecursive<E>>();
        BinarySearchTreeRecursive<E> atual = null;
        List<E> res = new ArrayList<E>();
        fila.add(this);
        while (!fila.isEmpty()) {
            atual = fila.remove();
            res.add(atual.getItem());
            if (atual.getLeft() != null)
            	fila.add(atual.getLeft());
            if (atual.getRight() != null)
            	fila.add(atual.getRight());
        }
        return res;
    }
    
    
    
}