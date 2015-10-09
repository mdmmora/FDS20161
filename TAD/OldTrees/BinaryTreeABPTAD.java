package OldTrees;

import java.util.ArrayList;


public interface BinaryTreeABPTAD<Dado extends Comparable> {
	public abstract void addABP(Dado d);
	public abstract Dado searchABP(Dado d);
	public abstract Dado get();
	public abstract Dado getLeft();
	public abstract Dado getRight();
	public abstract Dado getRoot();
	public abstract Dado getFather();
	public abstract int count();
	public abstract int countLeaves();
	public abstract ArrayList<Dado> traversalPre();
	public abstract ArrayList<Dado> traversalPos();
	public abstract ArrayList<Dado> traversalCentral();
	public abstract ArrayList<Dado> traversalWidth();
	public abstract String strTraversalPre();
	public abstract String strTraversalPos();
	public abstract String strTraversalCentral();
}
