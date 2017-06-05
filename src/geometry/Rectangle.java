package geometry;

/**
 * Created by LG-2 on 6/1/2017.
 */
public class Rectangle {
    public int length,breadth;
    public Point bottomLeft,bottomRight,topLeft,topRight;
    public Rectangle(int length,int breadth){
        this.length=length;
        this.breadth=breadth;
    }
    public Rectangle(Point topLeft,int length,int breadth){
        this.length=length;
        this.breadth=breadth;
        this.topLeft=topLeft;
        this.topRight=new Point(topLeft.x+length,topLeft.y);
        this.bottomLeft=new Point(topLeft.x,topLeft.y+breadth);
        this.bottomRight=new Point(topLeft.x+length,topLeft.y+breadth);
    }
    public void setTopLeft(Point topLeft){
        this.topLeft=topLeft;
        this.topRight=new Point(topLeft.x+length,topLeft.y);
        this.bottomLeft=new Point(topLeft.x,topLeft.y+breadth);
        this.bottomRight=new Point(topLeft.x+length,topLeft.y+breadth);
    }
    public void setTopRight(Point topRight){
        this.topRight=topRight;
        this.topLeft=new Point(this.topRight.x-length,this.topRight.y);
        this.bottomLeft=new Point(this.topLeft.x,this.topLeft.y+breadth);
        this.bottomRight=new Point(this.bottomLeft.x+breadth,this.bottomLeft.y);
    }
    public void setBottomLeft(Point bottomLeft){
        this.bottomLeft=bottomLeft;
        this.bottomRight=new Point(this.bottomLeft.x+length,this.bottomLeft.y);
        this.topLeft=new Point(this.bottomLeft.x,this.bottomLeft.y-breadth);
        this.topRight=new Point(this.topLeft.x+length,this.topLeft.y);
    }
    public void setBottomRight(Point bottomRight){
        this.bottomRight=bottomRight;
        this.bottomLeft=new Point(this.bottomRight.x-length,this.bottomRight.y);
        this.topLeft=new Point(this.bottomLeft.x,this.bottomLeft.y-breadth);
        this.topRight=new Point(this.topLeft.x+length,this.topLeft.y);
    }
    public void reset(){
        this.topLeft=new Point(0,0);
        this.topRight=new Point(0,0);
        this.bottomLeft=new Point(0,0);
        this.bottomRight=new Point(0,0);
    }
    public String toString(){
        return "(L="+length+",B="+breadth+",TL="+topLeft+",TR="+topRight+",BL="+bottomLeft+",BR="+bottomRight+")";
    }
}
