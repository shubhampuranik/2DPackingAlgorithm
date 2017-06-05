package twodpacking;

import java.util.Comparator;

/**
 * Created by LG-2 on 5/30/2017.
 */
public class MaxSideComparator implements Comparator<Rectangle> {
    @Override
    public int compare(Rectangle o1, Rectangle o2) {
        return new Sort().mSort(o1,o2);
    }
}
