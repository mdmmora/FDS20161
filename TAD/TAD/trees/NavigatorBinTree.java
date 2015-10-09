package TAD.trees;

public interface NavigatorBinTree<E> {
	public boolean add(E elem, NodePosition pos);
	//public E remove();
	public E search(E elem);
	public boolean goLeft();
	public boolean goRight();
	public boolean goFather();
	public boolean goRoot();
	public boolean hasLeft();
	public boolean hasRight();
	public boolean hasFather();
	public E getItem();
	public boolean setItem(E item);
}
