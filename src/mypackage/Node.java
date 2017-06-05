package mypackage;

/**
 * Created by LG-2 on 5/31/2017.
 */
public class Node {
    public Node left,right;
    public Rectangle rect;
    public Node(Rectangle rect){
        this.rect=rect;
    }
    public String toString(){
        return "(left="+left+",right="+right+",rect="+rect+")";
    }
}
