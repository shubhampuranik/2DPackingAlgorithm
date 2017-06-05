package geometry;

import org.w3c.dom.css.Rect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Created by LG-2 on 6/1/2017.
 */
public class TwoDPacking {

    public static void  RectIntersect( Rectangle R1 , Rectangle R2 )
    {
        if (  (  R1.topLeft.x  <  R2.bottomRight.x  )  &&  (   R1.bottomRight.x   >  R2.topLeft.x  )  &&
                (  R1.topLeft.y  <  R2.bottomRight.y  )  &&
                (  R1.bottomRight.y  >  R2.topLeft.y  )  )
        {
            System.out.println("Intersecting");
        }
        else
        {
            System.out.println("  Non - Intersecting");
        }
    }

    public static boolean intersects(Rectangle rect1,Rectangle rect2) {
        java.awt.Rectangle r1=new java.awt.Rectangle(rect1.topLeft.x,rect1.topLeft.y,rect1.length,rect1.breadth),r2=new java.awt.Rectangle(rect2.topLeft.x,rect2.topLeft.y,rect2.length,rect2.breadth);
        return r1.intersects(r2);
    }
    public static boolean contains(Rectangle rect1,Rectangle rect2) {
        java.awt.Rectangle r1=new java.awt.Rectangle(rect1.topLeft.x,rect1.topLeft.y,rect1.length,rect1.breadth),r2=new java.awt.Rectangle(rect2.topLeft.x,rect2.topLeft.y,rect2.length,rect2.breadth);
        return r1.contains(r2);
    }
    public static boolean isOutOfBin(Rectangle rect1,Rectangle rect2,Rectangle bin){
        if(rect1.topRight.x+rect2.length>bin.length || rect1.bottomRight.y+rect2.breadth>bin.breadth)
            return true;
        else
            return false;
    }
    public static boolean intersects(Rectangle r1,ArrayList<Rectangle> fit){
        boolean intersects=false;
        for(Rectangle rect:fit){
            if(intersects(r1, rect)) {
                intersects=true;
                break;
            }
        }
        return intersects;
    }

    public static void main(String[] args) {
//        Rectangle bin=new Rectangle(300,300);
//        Rectangle blocks[]={new Rectangle(100,100),new Rectangle(130,60),new Rectangle(120,50),new Rectangle(90,80),new Rectangle(80,40),new Rectangle(110,70),new Rectangle(80,80)};
//        Arrays.sort(blocks,new BreadthComparator());
////        for(Rectangle r:blocks)
////            System.out.println(r);
//        ArrayList<Rectangle> fit=new ArrayList<>();
//        bin.setTopLeft(new Point(0,0));
//        blocks[0].setTopLeft(bin.topLeft);
//        fit.add(blocks[0]);

//        for(int i=1;i<blocks.length;i++){
//            System.out.println(fit);
//            ListIterator<Rectangle> listIterator=fit.listIterator();
//            while(listIterator.hasNext()){
//                Rectangle curr=listIterator.next();
//                blocks[i].setTopLeft(curr.topRight);
//                if(!intersects(blocks[i],curr)){
//                    if(!isOutOfBin(curr,blocks[i],bin)){
//                        System.out.println(blocks[i]);
//                        listIterator.add(blocks[i]);
//                        break;
//                    }
//                }
//            }
//        }

//        fit.add(blocks[0]);
//        blocks[1].setTopLeft(blocks[0].topRight);
//        fit.add(blocks[1]);
//        blocks[2].setTopLeft(blocks[1].topRight);
//        fit.add(blocks[2]);
//        blocks[3].setTopLeft(blocks[2].topRight);
//        fit.add(blocks[3]);
//        blocks[4].setTopLeft(blocks[1].bottomLeft);
//        fit.add(blocks[4]);

//        for(int i=1;i<blocks.length;i++){
//            ListIterator<Rectangle> listIterator=fit.listIterator();
//            while(listIterator.hasNext()){
//                Rectangle curr=listIterator.next();
//                blocks[i].setTopLeft(curr.topRight);
//                if(!intersects(curr,blocks[i])){
//                    if(!isOutOfBin(curr,blocks[i],bin)){
//                        System.out.println(blocks[i]);
//                        listIterator.add(blocks[i]);
//                    }
//                }
//            }
//        }
//        new Demo(bin.length,bin.breadth,fit);

        Rectangle r1=new Rectangle(new Point(0,0),100,100);
        System.out.println(r1);
        Rectangle r2=new Rectangle(new Point(0,100),100,100);
        System.out.println(r2);
        RectIntersect(r1,r2);

    }
}
