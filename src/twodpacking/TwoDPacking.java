package twodpacking;

import mylogic1.BreadthComparator;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by LG-2 on 5/29/2017.
 */
public class TwoDPacking {
    public Node root;
    public Node findNode(Node root,int w,int h){
        if(root.used){
            if(findNode(root.right,w,h)!=null){
                Node node=findNode(root.right,w,h);
                return  node;
            }else{
                Node node=findNode(root.left,w,h);
                return  node;
            }
        }else if(w<=root.rect.length){
            if(h<=root.rect.breadth)
                return root;
            else
                return null;
        }else{
            return null;
        }
    }
    public Node splitNode(Node node,int w,int h){
        node.used=true;
        node.left=new Node(new Rectangle(node.rect.x,node.rect.y+h,node.rect.length,node.rect.breadth-h));
        node.right=new Node(new Rectangle(node.rect.x+w,node.rect.y,node.rect.length-w,h));
        System.out.println(node);
        return node;
    }
    public Rectangle[] fit(Rectangle blocks[]){
        Node node,block;
        int currShelf=0;
        Rectangle fits[]=new Rectangle[blocks.length];
        for(int i=0,j=0;i<blocks.length;i++){
            block=new Node(blocks[i]);
            node=findNode(this.root,block.rect.length,block.rect.breadth);
            if(node!=null){
                //System.out.println("1:-"+node);


//                if(node.rect.x==0) {
//                    if(block.rect.breadth>block.rect.length)
//                        block.rect.interchangeLengthBreadth();
//                    currShelf = block.rect.breadth;
//                    System.out.println("currShelf="+currShelf);
//
//                }else if(Integer.max(block.rect.length,block.rect.breadth)<currShelf) {
//                    if(block.rect.breadth>block.rect.length)
//                        block.rect.interchangeLengthBreadth();
//                }else {
//                    if(block.rect.breadth>block.rect.length/* && node.rect.length>block.rect.breadth*/)
//                        block.rect.interchangeLengthBreadth();
//                }


                block.fit=splitNode(node,block.rect.length,block.rect.breadth);
                //System.out.println("2:-"+node);
                Rectangle rectangle=new Rectangle(block.fit.rect.x,block.fit.rect.y,block.rect.length,block.rect.breadth);
//                if(rectangle.x==0 && rectangle.y==0){
//                    if(rectangle.breadth>rectangle.length) {
//                        rectangle.interchangeLengthBreadth();
                        fits[j++]=rectangle;
                System.out.println(rectangle);
//                        currShelf=rectangle;
//                    }
//                }else if()
//                if(rectangle.x==0 && rectangle.y!=0)
//                    currShelf=rectangle.breadth;

            }
        }
        return fits;
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
    public TwoDPacking(){
        root=new Node(new Rectangle(0,0,300,300));
//        Rectangle blocks[]={new Rectangle(100,100),new Rectangle(130,60),new Rectangle(50,120),new Rectangle(80,90),new Rectangle(40,80),new Rectangle(70,110),new Rectangle(80,80)};
       //
//         Rectangle blocks[]={new Rectangle(100,80),new Rectangle(80,100),new Rectangle(50,50),new Rectangle(120,80),new Rectangle(70,80),new Rectangle(70,50),new Rectangle(90,130),new Rectangle(60,60)};
//        Rectangle blocks[]={new Rectangle(100,110),new Rectangle(80,100),new Rectangle(90,20),new Rectangle(100,30),new Rectangle(80,60),new Rectangle(80,20),new Rectangle(40,60)};
         //Rectangle[] blocks=randomRectangles(100);
//        Arrays.sort(blocks,new LengthComparator());
        Rectangle blocks[]={new Rectangle(100,100),new Rectangle(130,60),new Rectangle(50,120),new Rectangle(80,90),new Rectangle(40,80),new Rectangle(70,110),new Rectangle(80,80)};

//        Arrays.sort(blocks,new BreadthComparator());
//       Arrays.sort(blocks,new MaxSideComparator());
//        Arrays.sort(blocks,new LengthBreadthComparator());
//        Arrays.sort(blocks,new AreaComparator());
//        Arrays.sort(blocks,new RatioComparator());
//        Arrays.sort(blocks,new PerimeterComparator());
//        for(Rectangle rect:blocks){
//            System.out.println(rect);
//        }
//        Arrays.sort(blocks,new ShorterSideComparator());
        System.out.println("FIT RECTS:-");
        Rectangle rec[]=fit(blocks);
        //Rectangle rec[]=fitInterchangeLengthBreadth(blocks);
        new Demo(root.rect.length,root.rect.breadth,rec);
//        Rectangle[] newRec=Rotation.rotate(rec);
//        Rectangle newRec1[]=fit(newRec);
//
//        new Demo(root.rect.length,root.rect.breadth,newRec1);

//        for(Rectangle rect:rec){
//            if(rect!=null)
//                System.out.println(rect);
//        }
//        for(int i=0;i<blocks.Length;i++){
//            if()
//        }
    }

    public static void main(String[] args) {
        new TwoDPacking();
    }
}

