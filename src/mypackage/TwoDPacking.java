package mypackage;

import java.util.*;

/**
 * Created by LG-2 on 5/31/2017.
 */
public class TwoDPacking {
    public int length,breadth;
    public boolean fitsIn(Rectangle rectToFit,Rectangle freeRect){
        if(rectToFit.length<freeRect.length && rectToFit.breadth<freeRect.breadth && freeRect.x+rectToFit.length<=freeRect.length && freeRect.y+rectToFit.breadth<=freeRect.breadth)
            return true;
        else
            return false;
    }
    public ArrayList<Rectangle> merge(ArrayList<Rectangle> rects){
        ArrayList<Rectangle> copy=new ArrayList<>(rects),temp=new ArrayList<>();
        for(Rectangle r1:rects){
            for(Rectangle r2:copy){
//                if((r1.length==r2.length && r1.x==r2.x))
            }
        }
        return null;
    }
    public Rectangle[] randomRectangles(int nos){
        Rectangle blocks[]=new Rectangle[nos];
        Random r=new Random();
        System.out.println("ALL RECTS:-");
        for(int i=0;i<nos;i++){
            blocks[i]=new Rectangle((r.nextInt(10)+1)*7,(r.nextInt(10)+1)*5);
            System.out.println(blocks[i]);
        }
        return blocks;
    }
    public void fit(Rectangle[] blocks,int length,int breadth){
        Arrays.sort(blocks,new AreaComparator());
//        for(Rectangle r:blocks)
//            System.out.println(r);

        ArrayList<Rectangle> fit=new ArrayList<>(),freeRects=new ArrayList<>();

        freeRects.add(new Rectangle(length,breadth));

        for(Rectangle r:blocks){

            //Collections.sort(freeRects,new ShorterSideComparator());

            ListIterator<Rectangle> listIterator=freeRects.listIterator();

            System.out.println(freeRects);

//            Set<Rectangle> rectangleSet=new HashSet<>(freeRects);
//
//            SortedSet sortedSet=new TreeSet<>()


//            System.out.println(freeRects);





            while(listIterator.hasNext()){

                Rectangle curr=listIterator.next(),r1,r2;

//                System.out.println(curr);

                if(fitsIn(r,curr)){

//                    System.out.println("HERE");

                    listIterator.remove();

                    r.x=curr.x;

                    r.y=curr.y;

                    System.out.println("FIT= "+r);

                    fit.add(r);

                    if(curr.length<curr.breadth){

                        r1=new Rectangle(curr.x+r.length,curr.y,curr.length-r.length,r.breadth);

                        r2=new Rectangle(curr.x,curr.y+r.breadth,curr.length,curr.breadth-r.breadth);

                    }else{

                        r1=new Rectangle(curr.x+r.length,curr.y,curr.length-r.length,curr.breadth);

//                        r2=new Rectangle(curr.x,r.breadth,r.length,curr.breadth-r.breadth);

                        r2=new Rectangle(curr.x,curr.breadth,r.length,curr.breadth-r.breadth);

                    }

                    listIterator.add(r1);

                    listIterator.add(r2);

                    //break;

                }

            }

        }

        new Demo(length,breadth,fit);





//        Set<Node> nodeSet=new HashSet<>();
//
//        Node root=new Node(blocks[0]);
//        root.right=new Node(new Rectangle(root.rect.x+root.rect.length,root.rect.y,length-root.rect.length,breadth));
//        root.left=new Node(new Rectangle(root.rect.x,root.rect.y+root.rect.breadth,breadth-root.rect.breadth,root.rect.length));
//
//        System.out.println(root);
//
//        nodeSet.add(root);

//        for(int i=1;i<blocks.length;i++){
//            Node node=new Node(blocks[i]);
//            if(root.left.rect.x+node.rect.length<length && root.left.rect.y+node.rect.breadth<breadth){
//                root=new Node(new Rectangle(root.left.rect.x+node.rect.x,root.left.rect.y+node.rect.y,node.rect.length,node.rect.breadth));
//                System.out.println(root.rect);
//            }

    }
    public static void main(String[] args) {
        Rectangle blocks[]={new Rectangle(100,100),new Rectangle(130,60),new Rectangle(50,120),new Rectangle(80,90),new Rectangle(40,80),new Rectangle(70,110),new Rectangle(80,80)};



        TwoDPacking packing=new TwoDPacking();

//        Rectangle blocks[]=packing.randomRectangles(100);

        packing.fit(blocks,300,300);



//        TwoDPacking packing=new TwoDPacking();
//        packing.fit(blocks,300,300);
//        TreeSet<Integer> integers=new TreeSet<>();

//        ArrayList<Integer> integers=new ArrayList<>();
//        integers.add(1);
//        integers.add(2);
//        integers.add(3);
//        integers.add(4);
//
//        System.out.println(integers);
////
//        ListIterator<Integer> integerIterator=integers.listIterator();
//        while (integerIterator.hasNext()){
//            int i=(Integer)integerIterator.next();
//            if(i==2){
//                integerIterator.remove();
//                integerIterator.add(5);
//                integerIterator.add(6);
//            }
//        }
//
//        System.out.println(integers);
    }
}
