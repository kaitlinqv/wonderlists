package SE330;

/**
 * Created by Kenneth on 3/7/2016.
 */
public class TreeNode
{
    protected Comparable el;
    protected TreeNode left, right;

    public TreeNode(Comparable el)
    {
        this(el,null,null);
    }//End constructor brace
    public TreeNode(Comparable el,TreeNode rt, TreeNode lt )
    {
        this.el = el; left = lt; right = rt;
    }//End constructor brace


}//End class brace







/**
 * Created by Kaitlin on 3/10/2016.
 */

/*
public class TreeNode < T extends Comparable< T > > {
    TreeNode< T > leftNode;
    T info;
    TreeNode< T > rightNode;

    public TreeNode(T nodeData) {
        info = nodeData;
        leftNode = rightNode = null;
    }

    public void insert( T insertValue ) {
        if ( insertValue.compareTo( info ) < 0 ){
            if (leftNode == null )
                leftNode = new TreeNode< T >(insertValue);
            else
                leftNode.insert(insertValue);
        } //end if
        else if ( insertValue.compareTo(info) > 0){
            if (rightNode == null)
                rightNode = new TreeNode< T >(insertValue);
            else
                rightNode.insert(insertValue);


        }
    }
}
*/