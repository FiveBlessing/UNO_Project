package uno;

public class LinnearNode<T> {
    private LinnearNode<T> next;
    private T element;

    public LinnearNode(){
        next=null;
        element=null;
    }
    public LinnearNode(T elem)
    {
        next = null;
        element = elem;
    }

    public LinnearNode<T> getNext(){
        return  next;
    }
    public void setNext(LinnearNode node){
        next = node;
    }
    public T getElement(){
        return element;
    }

    public void setElement(T elem) {
        element=elem;
    }
}
