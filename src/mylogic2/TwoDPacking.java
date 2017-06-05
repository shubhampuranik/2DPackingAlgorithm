package mylogic2;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

/**
 * Created by LG-2 on 6/2/2017.
 */
public class TwoDPacking {
    public ArrayList<Point> yList;
    public Rectangle bin;
    public TwoDPacking(int binWidth,int binHeight){
        yList = new ArrayList<>();
        bin = new Rectangle(binWidth,binHeight);
    }
    public void addAllPoints(Rectangle r){
        Point topRight=r.topRight,bottomRight=r.bottomRight,bottomLeft=r.bottomLeft;
        //Add all points on the right edge to list
        for(int i=topRight.y;i<=bottomRight.y;i++)
            yList.add(new Point(topRight.x,i));
        //Add all points on the bottom edge to list
        for(int i=bottomLeft.x;i<bottomRight.x;i++)
            yList.add(new Point(i,bottomLeft.y));
        //Get the top left and top right co-ordinates of the current rectangle
        int x1=r.topLeft.x,y1=r.topLeft.y,x2=r.topRight.x,y2=r.topRight.y;
        ListIterator listIterator=yList.listIterator();
        //For sequencing remove the top co-ordinates
        while(listIterator.hasNext()){
            Point p=(Point)listIterator.next();
            if(p.y<=y1 && p.x>=x1 && p.x<x2 )
                listIterator.remove();
        }
        //Sort the list according to ascending X and ascending Y
        Point.sortY(yList);
    }
    public ArrayList<Rectangle> randomRectangles(int nos){
        Random r=new Random();
        ArrayList<Rectangle> list=new ArrayList<>();
        //Generate random rectangles
        for(int i=0;i<nos;i++)
            list.add(new Rectangle((r.nextInt(10)+1)*23,(r.nextInt(10)+1)*23));
        return list;
    }
    public ArrayList<Rectangle> fit(ArrayList<Rectangle> inputRectangles){
        //Store the fit rectangles in this variable
        ArrayList<Rectangle> fitRectangles=new ArrayList<>();
        bin.setTopLeft(new Point(0,0));
        //Store the current rectangle in this variable
        Rectangle r = inputRectangles.get(0);
        //Place the first rectangle at (0,0)
        r.setTopLeft(new Point(0, 0));
        fitRectangles.add(r);
        addAllPoints(r);
        //The flag checks the position of current rectangle wrt to the selected point i.e. either below it(true) or above it(false)
        boolean flag;
        for (int i = 1; i < inputRectangles.size(); i++) {
            r = inputRectangles.get(i);
            for (int j = 0; j < yList.size(); j++) {
                Point p = yList.get(j);
                flag = true;
                //Check if the rectangle goes out of bin
                if (flag && p.x + r.length <= bin.length && p.y + r.breadth <= bin.breadth ) {
                    r.setTopLeft(p);
                    if (!r.intersects(fitRectangles)) {
                        fitRectangles.add(r);
                        addAllPoints(r);
                        break;
                    } else {
                        //Try to fit the rectangle by rotating it
                        r.rotate();
                        r.setTopLeft(p);
                        if (!r.intersects(fitRectangles)) {
                            fitRectangles.add(r);
                            addAllPoints(r);
                            break;
                        } else {
                            flag = false;
                        }
                    }
                }
                //Check if the rectangle goes out of bin
                if (!flag && p.y + r.breadth <= bin.breadth && p.x + r.length <= bin.length && p.y + r.breadth >0 && p.x + r.length>0) {
                    r.reset();
                    r.setBottomLeft(p);
                    if (!r.intersects(fitRectangles)) {
                        fitRectangles.add(r);
                        addAllPoints(r);
                        break;
                    }
                    else {
                        //Try to fit the rectangle by rotating it
                        r.reset();
                        r.rotate();
                        r.setBottomLeft(p);
                        if (!r.intersects(fitRectangles)) {
                            fitRectangles.add(r);
                            addAllPoints(r);
                            break;
                        }
                    }
                }
            }
        }
        return fitRectangles;
    }
    public static void main(String[] args) {
        TwoDPacking packing=new TwoDPacking(1300,725);
        ArrayList<Rectangle> inputRectangles = new ArrayList<>();
        inputRectangles=packing.randomRectangles(100);
        ArrayList<Rectangle> fitRectangles=packing.fit(inputRectangles);
        System.out.println("TOTAL RECTANGLES:-"+inputRectangles.size()+" FIT RECTANGLES:- "+fitRectangles.size());
        new Demo(packing.bin.length,packing.bin.breadth, fitRectangles);
    }
}
