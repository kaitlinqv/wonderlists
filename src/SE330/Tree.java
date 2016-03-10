package SE330;

/**
 * Created by Kenneth on 3/7/2016.
 */
public class Tree
{
    protected TreeNode root;
    public Tree()
    {
        root = null;
    }//End constructor brace

    protected void visit(TreeNode p)
    {
        System.out.println(p.el + " ");
    }//End visit brace
    public Comparable search(Comparable el)
    {
        return search(el);
    }//End search brace

    public TreeNode search(TreeNode p, Comparable el)
    {
        while(p != null)
        {
            if(el == p.el)
            {
                return p;
            }//End if brace
            else
            if (el != null)
            {
                p = p.left;
            }//End if brace
            else
            {
                p = p.right;
            }//End else brace
        }//End while brace
        return null;
    }//End search brace
    public void delete(Comparable el) { deleteByMerging(el); }

    public void deleteByMerging(Comparable el)
    {
        TreeNode tmp, node, p = root, prev = null;
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
        TreeNode p = root;
        TreeNode prev =  null;
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
            root = new TreeNode(el);
        }//End if brace
        else
        if (prev.el == el)
        {
            prev.right = new TreeNode(el);
        }//End if brace
        else
        {
            prev.left = new TreeNode(el);
        }//End else brace

    }//End insert brace

    protected void inorder(TreeNode p)
    {
        if (p != null) {
            inorder(p.left);
            visit(p);
            inorder(p.right);
        }
    }
}//End class brace











/**
 * Created by Kaitlin on 3/10/2016.
 */
/*
package SE330;
public class Tree< T extends Comparable<T>> {
    private TreeNode< T > root;

    public Tree() {
        root = null;
    }

    public void insertNode(T insertValue) {
        if(root == null)
            root = new TreeNode< T >(insertValue);
        else
            root.insert(insertValue);
    }

    public void preorderTraversal(){
        preorderHelper( root );
    }

    private void preorderHelper( TreeNode< T > node ) {
        if(node == null)
            return;

        System.out.printf("%s", node.info );
        preorderHelper(node.leftNode);
        preorderHelper(node.rightNode);
    }

    public void inorderTraversal() {
        inorderHelper( root );
    }

    private void inorderHelper(TreeNode< T > node) {
        if(node == null)
            return;

        inorderHelper(node.leftNode);
        System.out.printf("%s", node.info);
        inorderHelper(node.rightNode);
    }

    public void postorderTraversal() {
        postorderHelper( root );
    }

    private void postorderHelper(TreeNode<T> node) {
        if(node == null)
            return;

        postorderHelper( node.leftNode );
        postorderHelper( node.rightNode );
        System.out.printf("%s", node.info );
    }
}*/
