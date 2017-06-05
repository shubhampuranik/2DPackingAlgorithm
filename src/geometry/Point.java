package geometry;

/**
 * Created by LG-2 on 6/1/2017.
 */
public class Point {
    public int x,y;
    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }
    public Point(Point p){
        this.x=p.x;
        this.y=p.y;
    }
    public String toString(){
        return "("+x+","+y+")";
    }
}
