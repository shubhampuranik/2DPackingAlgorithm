package twodpacking;

import java.util.Comparator;

/**
 * Created by LG-2 on 5/30/2017.
 */
public class LengthBreadthComparator implements Comparator<Rectangle> {
    @Override
    public int compare(Rectangle o1, Rectangle o2){
        int max1=Integer.max(o1.length,o1.breadth),max2=Integer.max(o1.length,o2.breadth);
        if(max1>max2){
            return -1;
        }else if(max1<max2){
            return 1;
        }else{
            return 0;
        }
    }
}