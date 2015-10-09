package TAD.trees;

public interface ReferenceBinTree<E> {
	//public E remove();
	public boolean add(E elem, NodePosition pos);
	public ReferenceBinTree<E> search(E elem);
	public ReferenceBinTree<E> goLeft();
	public ReferenceBinTree<E> goRight();
	public ReferenceBinTree<E> goFather();
	public ReferenceBinTree<E> goRoot();
	public boolean hasLeft();
	public boolean hasRight();
	public boolean hasFather();
	public E getItem();
	public boolean setItem(E item);
}
