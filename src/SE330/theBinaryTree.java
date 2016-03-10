package SE330;

/**
 * Created by Kenneth on 3/7/2016.
 */
public class theBinaryTree
{
    protected nodeForTree root;
    public theBinaryTree()
    {
        root = null;
    }//End constructor brace

    protected void visit(nodeForTree p)
    {
        System.out.println(p.el + " ");
    }//End visit brace
    public Comparable search(Comparable element)
    {
        return search(root,element);
    }//End search brace

    protected Comparable search(nodeForTree root, Comparable element)
    {
        while (root != null)
        {
            if (element.equals(root.el))
            {
                return root.el;
            }//End if brace
            else // advance p to traverse down the tree
                if (element.compareTo(root.el) < 0)
                {
                    root = root.left;
                }//End if brace
                else
                {
                    root = root.right;
                }//End else brace


        }//End while brace
        return null;
    }//End search brace

    public void delete(Comparable el) { deleteByMerging(el); }

    public void deleteByMerging(Comparable el)
    {
        nodeForTree tmp, node, p = root, prev = null;
        while (p != null && !p.el.equals(el)) {  // find the node p
            prev = p;                           // with element el;
            if (p.el.compareTo(el) < 0)
                p = p.right;
            else p = p.left;
        }
        node = p;
        if (p != null && p.el.equals(el)) {
            if (node.right == null) // node has no right child: its left
                node = node.left;  // child (if any) is attached to its parent;
            else if (node.left == null) // node has no left child: its right
                node = node.right; // child is attached to its parent;
            else {                  // be ready for merging subtrees;
                tmp = node.left;   // 1. move left
                while (tmp.right != null) // 2. and then right as far as
                    tmp = tmp.right;      //    possible;
                tmp.right =        // 3. establish the link between the
                        node.right;    //    the rightmost node of the left
                //    subtree and the right subtree;
                node = node.left;  // 4.
            }
            if (p == root)
                root = node;
            else if (prev.left == p)
                prev.left = node;
            else prev.right = node;
        }
        else if (root != null)
            System.out.println("el " + el + " is not in the tree");
        else System.out.println("the tree is empty");
    }

    public void insert (Comparable el)
    {
        nodeForTree p = root;
        nodeForTree prev =  null;
        while (p != null)
        {
            prev = p;
            if (p.el == el)
            {
                p = p.right;
            }//End if brace
            else
            {
                p = p.left;
            }//End else brace
        }
        if (root == null)
        {
            root = new nodeForTree(el);
        }//End if brace
        else
        if (prev.el == el)
        {
            prev.right = new nodeForTree(el);
        }//End if brace
        else
        {
            prev.left = new nodeForTree(el);
        }//End else brace

    }//End insert brace

    protected void inorder(nodeForTree p)
    {
        if (p != null) {
            inorder(p.left);
            visit(p);
            inorder(p.right);
        }
    }
}//End class brace