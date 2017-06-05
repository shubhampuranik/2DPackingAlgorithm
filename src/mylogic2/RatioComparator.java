package mylogic2;


import java.util.Comparator;

/**
 * Created by LG-2 on 5/30/2017.
 */
public class RatioComparator implements Comparator<Rectangle> {
    @Override
    public int compare(Rectangle o1, Rectangle o2) {
        float r1=(float)o1.length/(float)o1.breadth,r2=(float)o2.length/(float)o2.breadth;
        System.out.println("r1="+r1+" r2="+r2);
        if(r1>r2)
            return -1;
        else if(r1<r2)
            return 1;
        else
            return 0;
    }
}
