package mypackage;


import java.util.Comparator;

/**
 * Created by LG-2 on 5/30/2017.
 */
public class ShorterSideComparator implements Comparator<Rectangle> {
    @Override
    public int compare(Rectangle o1, Rectangle o2) {
        if(o1.length<o2.length || (o1.length==o2.length && o1.breadth<o2.breadth))
            return -1;
        else if(o1.length>o2.length || (o1.length==o2.length && o1.breadth>o2.breadth))
            return 1;
        else
            return 0;
    }
}

