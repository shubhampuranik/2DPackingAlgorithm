package mylogic1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by LG-2 on 6/1/2017.
 */
public class Point {
    public int x,y;
    public Point(int x, int y){
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
    public static void sortX(ArrayList<Point> points){
        Collections.sort(points,new SortAscendingXComparator());
    }
    public static void sortY(ArrayList<Point> points){
        Collections.sort(points,new SortAscendingYComparator());
    }
//    public static void sortXY(ArrayList<Point> points){
//        Collections.sort(points,new SortAscendingXComparator());
//        Collections.sort(points,new SortAscendingYComparator());
//    }
//    public static void sortYX(ArrayList<Point> points){
//        Collections.sort(points,new SortAscendingYComparator());
//        Collections.sort(points,new SortAscendingXComparator());
//    }
    public static class SortAscendingYComparator implements Comparator<Point>{
        @Override
        public int compare(Point o1, Point o2) {
            if(o1.y>o2.y)
                return 1;
            else if(o1.y<o2.y)
                return -1;
            else{
                if(o1.x>o2.x)
                    return 1;
                else if(o1.x<o2.x)
                    return -1;
                else
                    return 0;
            }
        }
    }
    public static class SortAscendingXComparator implements Comparator<Point>{
        @Override
        public int compare(Point o1, Point o2) {
            if(o1.x>o2.x)
                return 1;
            else if(o1.x<o2.x)
                return -1;
            else{
                if(o1.y>o2.y)
                    return 1;
                else if(o1.y<o2.y)
                    return -1;
                else
                    return 0;
            }
        }
    }
    public static SortAscendingYComparator getSortAscendingYComparator(){
        return new SortAscendingYComparator();
    }
    public static SortAscendingXComparator getSortAscendingXComparator(){
        return new SortAscendingXComparator();
    }
}
