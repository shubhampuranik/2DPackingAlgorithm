package mylogic1;

import java.util.*;

/**
 * Created by LG-2 on 6/2/2017.
 */
public class TwoDPacking {
    public ArrayList<Point> xList,yList;
    public ArrayList<Rectangle> fitRectangles,inputRectangles;
    public Rectangle bin;

    public static boolean  RectIntersect( Rectangle R1 , Rectangle R2 )
    {
        if (  (  R1.topLeft.x  <  R2.bottomRight.x  )  &&  (   R1.bottomRight.x   >  R2.topLeft.x  )  &&
                (  R1.topLeft.y  <  R2.bottomRight.y  )  &&
                (  R1.bottomRight.y  >  R2.topLeft.y  )  )
        {
//            System.out.println("Intersecting");
            return true;
        }
        else
        {
//            System.out.println("  Non - Intersecting");
            return false;
        }
//        if (Math.max(R1.topLeft.x, R2.topLeft.x) <= Math.min(R1.bottomRight.x, R2.bottomRight.x) &&
//                Math.max(R1.topLeft.y, R2.topLeft.y) <= Math.min(R1.bottomRight.y,R2.bottomRight.y)) {
//        return true;
//            // It covers all cases of intersection including equality and inclusion.
//        }return false;
    }

    public boolean isOverLapping(Rectangle other,Rectangle r1) {
        if (r1.topLeft.x >= other.bottomRight.x // R1 is right to R2
        || r1.bottomRight.x <= other.topLeft.x // R1 is left to R2
        || r1.topLeft.y <= other.bottomRight.y // R1 is above R2
        || r1.bottomRight.y >= other.topLeft.y) { // R1 is below R1
             return false; }
        return  true; }
        public boolean intersects(Rectangle rect1,Rectangle rect2) {
            java.awt.Rectangle r1=new java.awt.Rectangle(rect1.topLeft.x,rect1.topLeft.y,rect1.length,rect1.breadth),r2=new java.awt.Rectangle(rect2.topLeft.x,rect2.topLeft.y, rect2.length,rect2.breadth);
            if(isOutOfBin(rect1,rect2))
                return true;
            return r1.intersects(r2);
        }
    public boolean intersects(Rectangle r1,ArrayList<Rectangle> fit){
        boolean intersects=false;
        for(Rectangle rect:fit){
//            if(RectIntersect(r1, rect) /*&& isOverLapping(r1,rect)*/ && !isOutOfBin(rect,r1) ) {
//                intersects=true;
//                break;
//            }
            if(r1.intersects(rect) /*&& isOverLapping(r1,rect) && !isOutOfBin(rect,r1) && !r1.isOutOfBin(this.bin) */) {
                intersects=true;
                break;
            }
        }
        return intersects;
    }
    public boolean isOutOfBin(Rectangle rect1,Rectangle rect2){
//        return ! new java.awt.Rectangle(rect1.topLeft.x,rect1.topLeft.y,rect1.length,rect1.breadth).contains(new java.awt.Rectangle(rect2.topLeft.x,rect2.topLeft.y,rect2.length,rect2.breadth));
        if(rect1.topRight.x+rect2.length>=bin.length && rect1.bottomRight.y+rect2.breadth>=bin.breadth)
            return true;
        else
            return false;
    }
    public void addAllPoints(Rectangle r){
//        xList.add(r.topLeft);
        xList.add(r.topRight);
        xList.add(r.bottomLeft);
        xList.add(r.bottomRight);
        xList.remove(r.topLeft);

//        yList.add(r.topLeft);
        yList.add(r.topRight);
        yList.add(r.bottomLeft);
        yList.add(r.bottomRight);
        yList.remove(r.topLeft);
        Point.sortX(xList);
        Point.sortY(yList);
//        System.out.println("xList="+xList);
//        System.out.println("yList="+yList);
    }
    public ArrayList<Rectangle> randomRectangles(int nos){
        Random r=new Random();
        ArrayList<Rectangle> list=new ArrayList<>();
        for(int i=0;i<nos;i++)
            list.add(new Rectangle((r.nextInt(5)+1)*10,(r.nextInt(5)+1)*5));
        return list;
    }
    public TwoDPacking() {
        fitRectangles = new ArrayList<>();
        inputRectangles = new ArrayList<>();
        xList = new ArrayList<>();
        yList = new ArrayList<>();
//        inputRectangles.add(new Rectangle(100, 100));
//        inputRectangles.add(new Rectangle(120, 60));
//        inputRectangles.add(new Rectangle(120, 60));
//        inputRectangles.add(new Rectangle(100, 80));
//        inputRectangles.add(new Rectangle(80, 50));
//        inputRectangles.add(new Rectangle(120, 80));
//        inputRectangles.add(new Rectangle(70, 50));
//        inputRectangles.add(new Rectangle(80, 80));

        inputRectangles=randomRectangles(50);

        System.out.println(inputRectangles);

        Collections.sort(inputRectangles,new BreadthComparator());
//        System.out.println(inputRectangles);

        bin = new Rectangle(300, 300);
        bin.setTopLeft(new Point(0,0));

        Rectangle r = inputRectangles.get(0);
        r.setTopLeft(new Point(0, 0));
        fitRectangles.add(r);
        addAllPoints(r);

//        for (int i = 1; i < inputRectangles.size(); i++) {
//            r = inputRectangles.get(i);
//            r.setTopLeft(inputRectangles.get(i-1).topRight);
//            fitRectangles.add(r);
//
//        }java.awt.Rectangle rect1=new java.awt.Rectangle(r.topLeft.x,r.topLeft.y,r.length,r.breadth);
//            Rectangle r1=fitRectangles.get(fitRectangles.size()-1);
//            r.setTopLeft(r1.topRight);
//
//            java.awt.Rectangle rect2=new java.awt.Rectangle(r.topLeft.x,r.topLeft.y,r.length,r.breadth);


            boolean flag;
            for (int i = 1; i < inputRectangles.size(); i++) {
                r = inputRectangles.get(i);
                for (int j = 0; j < yList.size(); j++) {
                    Point p = yList.get(j);
                    flag = true;
                    if (flag && p.x + r.length <= bin.length && p.y + r.breadth <= bin.breadth ) {
                        r.setTopLeft(p);
//                    System.out.println(r);
//                        System.out.println("IF    FLAG    r=" + r + " fitRects=" + fitRectangles);
//                        System.out.println(intersects(r, fitRectangles));
                        if (!intersects(r, fitRectangles)) {
                            fitRectangles.add(r);
                            addAllPoints(r);
                            break;
                        } else {
//                        r.reset();
                            r.rotate();
                            r.setTopLeft(p);
//                            System.out.println("ELSE    FLAG    r=" + r + " fitRects=" + fitRectangles);
//                            System.out.println(intersects(r, fitRectangles));
                            if (!intersects(r, fitRectangles)) {
                                fitRectangles.add(r);
                                addAllPoints(r);
                                break;
                            } else {
                                flag = false;
                            }
                        }
                    }
                    if (!flag && p.y + r.breadth <= bin.breadth && p.x + r.length <= bin.length) {
                        if (yList.indexOf(p) + 1 < xList.size()) {
                            Point q = xList.get(xList.indexOf(p) + 1);
                            System.out.println(p + "  " + q);
                            r.reset();
                            r.setBottomRight(q);
//                            System.out.println("IF    !FLAG    r=" + r + " fitRects=" + fitRectangles);
//                            System.out.println(intersects(r, fitRectangles));
                            if (!intersects(r, fitRectangles)) {
                                fitRectangles.add(r);
                                addAllPoints(r);
                                break;
                            } else {
                                r.reset();
                                r.rotate();
                                r.setBottomRight(q);
//                                System.out.println("ELSE    !FLAG    r=" + r + " fitRects=" + fitRectangles);
//                                System.out.println(intersects(r, fitRectangles));
                                if (!intersects(r, fitRectangles)) {
                                    fitRectangles.add(r);
                                    addAllPoints(r);
                                    break;
                                }
                            }
                        }
                    }
                }

            }

//            System.out.println(fitRectangles);

        System.out.println("FIT RECTANGLES:- "+fitRectangles.size());

        new Demo(300, 300, fitRectangles);

        ListIterator<Rectangle> listIterator=fitRectangles.listIterator();

//        while(listIterator.hasNext()){
//            Rectangle rec=listIterator.next();
//            if(rec.isOutOfBin(bin)){
//                listIterator.remove();
//            }
//        }



        }
    public static void main(String[] args) {
        new TwoDPacking();
    }
}
