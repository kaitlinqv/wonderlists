package SE330;


/**
 * Created by Kaitlin on 3/8/2016.
 */
public class SLList < T > {
    public SLNode< T > head;
    private SLNode< T > tail;
    public String name;

    public SLList(){
        this("list");
    }

    public SLList(String listName ) {
        name = listName;
        head = tail = null;
    }

    public T getHead()throws EmptyListException{
        if ( isEmpty() )
            throw new EmptyListException( name );
        else
            return (T) head.info;
    }

    public void insertAtFront( T insertItem ) {
        if( isEmpty())
            head = tail = new SLNode< T >( insertItem );
        else
            head = new SLNode< T >( insertItem, head );
    }

    public void insertAtBack( T insertItem ) {
        if( isEmpty() )
            head = tail = new SLNode< T >(insertItem);
        else
            tail = tail.next = new SLNode< T >(insertItem);
    }

    public T deleteFromFront() throws EmptyListException {
        if ( isEmpty() )
            throw new EmptyListException( name );

        T removedItem = head.info;
        if ( head == tail )
            head = tail = null;
        else
            head = head.next;

        return removedItem;
    }

    public T removeFromBack() throws EmptyListException {
        if ( isEmpty() )
            throw new EmptyListException( name );

        T removedItem = tail.info;

        if(head == tail )
            head = tail = null;
        else{
            SLNode< T > current = head;
            while ( current.next != tail)
                current = current.next;

            tail = current;
            current.next = null;
        }
        return removedItem;
    }
    public T find(T el) {
        SLNode tmp = head;
        for ( ; tmp != null && !el.equals(tmp.info); tmp = tmp.next);
        if (tmp == null)
            return null;
        else
            return (T) tmp.info;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void print() {  //not really used
        if( isEmpty() ) {
            System.out.printf( "Empty %s\n", name );
            return;
        }

        System.out.printf("The %s is: ", name );
        SLNode< T > current = head;

        while (current != null) {
            System.out.printf("%s ", current.info);
            current = current.next;
        }
        System.out.println("\n");
    }
}




