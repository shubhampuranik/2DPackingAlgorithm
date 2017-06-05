package twodpacking;

/**
 * Created by LG-2 on 5/30/2017.
 */
public class Node{
    public Node left,right,fit;
    public Rectangle rect;
    public boolean used;
    public Node(){}
    public Node(Rectangle rect){
        this.rect=rect;
    }
    public String toString(){
        return "(left="+left+",right="+right+",rect="+rect+",fit="+fit+",used="+used+")";
    }
}