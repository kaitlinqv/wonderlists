package SE330;

/**
 * Created by Kenneth on 3/7/2016.
 */
public class nodeForTree
{
    protected Comparable el;
    protected nodeForTree left, right;

    public nodeForTree(Comparable element)
    {
        this(element,null,null);
    }//End constructor brace
    public nodeForTree(Comparable el,nodeForTree rt, nodeForTree lt )
    {
        this.el = el; left = lt; right = rt;
    }//End constructor brace


}//End class brace