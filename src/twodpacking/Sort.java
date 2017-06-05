package twodpacking;

/**
 * Created by LG-2 on 5/30/2017.
 */
public class Sort{
    public int length(Rectangle a,Rectangle b){
        return b.length-a.length;
    }
    public int breadth(Rectangle a,Rectangle b){
        return b.breadth-a.breadth;
    }
    public int max(Rectangle a,Rectangle b){
        return Integer.max(b.length,b.breadth)-Integer.max(a.length,a.breadth);
    }
    public int min(Rectangle a,Rectangle b){
        return Integer.min(b.length, b.breadth)-Integer.min(a.length, a.breadth);
    }
    public int mSort(Rectangle a,Rectangle b){
        if(max(a,b)!=0)
            return max(a,b);
        else if(min(a,b)!=0)
            return min(a, b);
        else if(breadth(a,b)!=0)
            return breadth(a,b);
        else if(length(a,b)!=0)
            return length(a,b);
        else
            return 0;
    }
}
