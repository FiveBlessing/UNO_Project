package uno;

public class LInedQueue<T> implements QueueADT<T> {
    private int count;
    private LinnearNode<T> head,tail;
    public LInedQueue(){
        count=0;
        head=tail=null;
    }

    @Override
    public void enqueue(T element) {
        LinnearNode<T> node = new LinnearNode<T>(element);
        if (isEmpty())
            head = node;
        else
            tail.setNext(node);
            tail = node;
            count++;

    }

    @Override
    public T dequeue() throws EmptyCollectionException {
        LinnearNode<T> front = new LinnearNode<T>();
        if (isEmpty())
        {
            throw new EmptyCollectionException("queue");
        }
        T result = head.getElement();
        head = head.getNext();
        count--;

        if (isEmpty()) {
            tail=null;
        }

        return  result;
    }

    @Override
    public T first() {
        String result = (String) head.getElement();
       // System.out.println(result);
        return (T) result;
    }

    @Override
    public boolean isEmpty() {

        if (size()==0){

            return true;
        }
        else {

            return false;
        }
    }

    @Override
    public int size() {
       // System.out.println(count);
        return count;
    }

    @Override
    public String toString(){

        LinnearNode<T> temp = head;
        String result= "";
        while (temp!=null){
            result+=temp.getElement()+" ";
          // System.out.println(temp.getElement());
           temp=temp.getNext();
        }

        return result;
    }
}
