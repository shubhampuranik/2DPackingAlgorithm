package twodpacking;

/**
 * Created by LG-2 on 5/30/2017.
 */
public class Rectangle{
    int length,breadth,x=0,y=0;
    public Rectangle(int Length,int Breadth)
    {
        this.length=Length;
        this.breadth=Breadth;
    }
    public Rectangle(int x,int y,int length,int breadth)
    {
        this.x=x;
        this.y=y;
        this.length=length;
        this.breadth=breadth;
    }
    public void interchangeLengthBreadth(){
        int temp=this.length;
        this.length=this.breadth;
        this.breadth=temp;
    }
    public void set(int x,int y){
        this.x=x;
        this.y=y;
    }
    public String toString(){
        return "("+x+","+y+","+length+","+breadth+")";
    }
}
