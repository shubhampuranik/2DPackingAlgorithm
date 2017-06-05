package python;


/**
 * Created by LG-2 on 6/1/2017.
 */
public class Rectangle {
    public int length,breadth;
    public Rectangle(int length,int breadth){
        this.length=length;
        this.breadth=breadth;
    }
    public String toString(){
        return "(L="+length+",B="+breadth+")";
    }
}
