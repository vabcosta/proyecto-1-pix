/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luisa Portillo
 */
public class Node <E> {
    protected E data;
    protected Node <E> nextElement;
    
    public Node(E v, Node<E> next)
    // pre: v is a value, next is a reference to remainder of list
    // post: an element is constructed as the new head of list
    {
        data = v;
        nextElement = next;
    }
    
    public Node(E v)
    // post: constructs a new tail of a list with value v
    {
        this(v,null);
    }
    
    public Node<E> next()
    // post: returns reference to next value in list
    {
        return nextElement;
    }
    
    public void setNext(Node<E> next)
    // post: sets reference to new next value
    {
        nextElement = next;
    }
    
    public E value()
    // post: returns value associated with this element
    {
        return data;
    }
    
    public void setValue(E value)
    // post: sets value associated with this element
    {
        data = value;
    }
}
