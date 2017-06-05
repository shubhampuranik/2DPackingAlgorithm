package mylogic2;



import java.util.ArrayList;

/**
 * Created by LG-2 on 6/1/2017.
 */
public class Rectangle {
    public int length,breadth,id;
    public static int counter;
    public Point bottomLeft,bottomRight,topLeft,topRight;
    public Rectangle(int length, int breadth){
        this.id=counter++;
        this.length=length;
        this.breadth=breadth;
    }
    public Rectangle(Point topLeft, int length, int breadth){
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
    public void rotate(){
        int temp=this.length;
        this.length=this.breadth;
        this.breadth=temp;
    }
    public boolean intersects(Rectangle r){
        java.awt.Rectangle r1=new java.awt.Rectangle(r.topLeft.x,r.topLeft.y,r.length,r.breadth);
        java.awt.Rectangle r2=new java.awt.Rectangle(this.topLeft.x,this.topLeft.y,this.length,this.breadth);
        java.awt.Rectangle inter=r1.intersection(r2);
        return !inter.isEmpty();
    }
    public boolean intersects(ArrayList<Rectangle> rect){
        boolean intersects=false;
        for(Rectangle r:rect){
            if(this.intersects(r)){
                intersects=true;
                break;
            }
        }
        return intersects;
    }
    public boolean isOutOfBin(Rectangle bin){
        java.awt.Rectangle r1=new java.awt.Rectangle(this.topLeft.x,this.topLeft.y,this.length,this.breadth);
        java.awt.Rectangle r2=new java.awt.Rectangle(bin.topLeft.x,bin.topLeft.y,bin.length,bin.breadth);
//        java.awt.Rectangle inter=r1.intersection(r2);
//        int area=new Double(inter.getWidth()).intValue()*new Double(inter.getHeight()).intValue();
//        if(area<=(r1.width*r1.height))
        return !r2.contains(r1);
    }
    public String toString(){
        return "("+id+" L="+length+",B="+breadth+",TL="+topLeft+",TR="+topRight+",BL="+bottomLeft+",BR="+bottomRight+")";
    }
    public static void main(String[] args) {
        Rectangle r1=new Rectangle(new Point(0,0),300,300);
        Rectangle r2=new Rectangle(new Point(251,0),50,50);
        System.out.println(r2.isOutOfBin(r1));

    }
}
