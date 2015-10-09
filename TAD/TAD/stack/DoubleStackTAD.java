package TAD.stack;


/**
 * Write a description of interface DoubleStack here.
 * 
 * @author Márcia Cristina Moraes 
 * @version 16/05/2009
 */

public interface DoubleStackTAD<E>
{
    public void pushStack1(E element);
    public void pushStack2(E element);
    public E popStack1();
    public E popStack2();
    public int sizeStack1();
    public int sizeStack2();
    
}
