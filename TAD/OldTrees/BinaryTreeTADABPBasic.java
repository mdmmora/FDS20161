package OldTrees;

import java.util.Vector;

public interface BinaryTreeTADABPBasic<Dado extends Comparable> {
	public abstract void addABP(Dado d);
	public abstract Dado searchABP(Dado d);
	public abstract Vector<Dado> traversalCentral();
}
