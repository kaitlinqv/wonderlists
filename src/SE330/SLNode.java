package SE330;

/**
 * Created by Kaitlin on 3/8/2016.
 */
public class SLNode< T > {
    T info;
    SLNode< T > next;

    SLNode( T el ){
        this( el, null );
    }

    SLNode( T el, SLNode< T > node ) {
        info = el;
        next = node;
    }

    T getInfo(){
        return info;
    }

    SLNode< T > getNext(){
        return next;
    }
}
