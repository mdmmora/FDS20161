package TAD.stack;

public interface StackTAD<T> {
	  public void push(T d);
	  public T pop();
	  public T top();
	  public boolean isEmpty();
	  public int size(); 
}
