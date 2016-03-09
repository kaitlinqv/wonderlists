/***   EXCEPTION HANDLING   ***/

package SE330;

public class EmptyListException extends RuntimeException {

    public EmptyListException() {
        this("List");
    }

    public EmptyListException( String name ) {  //not super important
        super( name + " is empty" );
    }

}