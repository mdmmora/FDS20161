package TAD.trees;

import java.util.Iterator;

public interface IteratorBinTree<E> extends Iterator<E> {
	public E getFather();
	public E getLeft();
	public E getRight();
	public E getElem();
}
