package rectpack;

/**
 * Created by LG-2 on 6/1/2017.
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 */

/**
 * @author kskch
 *
 */
public class RectPack extends JComponent {

    /**
     *
     */
    private static final long serialVersionUID = -7996860477058340695L;
    /**
     * @param args
     */
    static int numofRect = 0, minW = 0,minH = 0, sumofAreas=0, boundingW =0, boundingH = 0, scale =0;
    static List<Point> coordinates = new ArrayList<Point>();
    static List<Rectangle> rectangles = new ArrayList<Rectangle>();
    List<List<Rectangle>> listofLists = new ArrayList<List<Rectangle>>();
    Random randomNumber = new Random();

    public RectPack(){

    }

    public void paint(Graphics g) {
        int i=0,w=0;

        g.drawRect(9, 9, boundingW*scale+1, boundingH*scale+1);
        g.setColor(getRandomColor());

        g.fillRect (10, 10, rectangles.get(i).width*scale, rectangles.get(i).height*scale);
        g.setColor(Color.black);
        g.drawRect (10, 10, rectangles.get(i).width*scale, rectangles.get(i).height*scale);
        w=rectangles.get(i).width*scale;
        i+=1;
        while(i<numofRect){

            g.setColor(getRandomColor());
            g.fillRect (10 + rectangles.get(i).p.x*scale, 10 + rectangles.get(i).p.y*scale, rectangles.get(i).width*scale, rectangles.get(i).height*scale);
            g.setColor(Color.black);
            g.drawRect (10 + rectangles.get(i).p.x*scale, 10 + rectangles.get(i).p.y*scale, rectangles.get(i).width*scale, rectangles.get(i).height*scale);
            w += rectangles.get(i).width*scale;

            i++;
        }
    }

    private Color getRandomColor() {
        return new Color(randomNumber.nextFloat(),
                randomNumber.nextFloat(), randomNumber.nextFloat());
    }



    public void getRect(){
        Scanner scanner = null;
        Scanner scanner2 = null;
        try {
            scanner = new Scanner(new File("C:\\Users\\LG-2\\IdeaProjects\\TwoDPacking\\src\\rectpack\\instance.txt"));
            scanner2 = new Scanner(new File("C:\\Users\\LG-2\\IdeaProjects\\TwoDPacking\\src\\rectpack\\instance.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



        while(scanner2.hasNextLine()){
            numofRect++;
            scanner2.nextLine();
        }
        System.out.println("Total number of rectangle: "+numofRect );


        int i=0;
        while(scanner.hasNextInt())
        {
            Rectangle r = this.new Rectangle();
            r.width = (int)scanner.nextInt();
            r.height = (int)scanner.nextInt();
            r.area = r.width*r.height;

            sumofAreas += r.area;
            if(minW < r.width) minW = r.width;
            if(minH < r.height) minH = r.height;
            rectangles.add(r);
            i++;
        }

        if(minH < 10 && minW< 10){
            scale = 50;
        }
        else if(minH > 10 && minW > 10 && minH < 20 && minW < 20){
            scale = 5;
        }
        else
            scale =1;
        rectangles.sort((r2, r1) -> r1.area - r2.area); /* ######*/
        rectangles.get(0).p = new Point(0,0);

        boolean val1 = true;
        while(val1){

            Map<Integer, Integer> factorPairs = factorize(sumofAreas);


            if(!factorPairs.isEmpty()){

                for (Map.Entry<Integer, Integer> factor : factorPairs.entrySet()){

                    int bigW = factor.getKey();
                    int bigH = factor.getValue();
                    boolean val2 = check(bigW,bigH);
                    if(val2){
                        val1 = false;
                        System.out.println("Solution found is = " + factor.getKey() + " x " + factor.getValue() +" = "+ sumofAreas);
                        boundingW = factor.getKey();
                        boundingH = factor.getValue();

                        break;

                    }

                }
            }
            sumofAreas++;
        }


    }


    private boolean check(int W,int H){
        int i=0,flag = 0;
        Point p1 = new Point(rectangles.get(0).width,0);
        Point p2 = new Point(0,rectangles.get(0).height);

        coordinates.add(p1);
        coordinates.add(p2);
        i++;
        flag++;
        while(i<numofRect){
            for (Point p : coordinates){

                int startX = p.x;
                int startY = p.y;
                rectangles.get(i).p = p;

                if(startX+rectangles.get(i).width <= W && startY + rectangles.get(i).height <= H && !isOverlapping(i)){
                    coordinates.remove(p);

                    coordinates.add(new Point(startX+rectangles.get(i).width, startY));
                    coordinates.add(new Point(startX,startY + rectangles.get(i).height));

                    flag++;
                    break;
                }

            }


            i++;
        }
        coordinates.clear();
        if(flag==numofRect)
            return true;
        else
            return false;

    }


    private static boolean isOverlapping(int i){


        for(int j=0;j<i;j++){

            if(rectangles.get(i).p.x >= rectangles.get(j).p.x + rectangles.get(j).width
                    || rectangles.get(i).p.x + rectangles.get(i).width<= rectangles.get(j).p.x
                    || rectangles.get(i).p.y >= rectangles.get(j).p.y + rectangles.get(j).height
                    || rectangles.get(i).p.y + rectangles.get(i).height<= rectangles.get(j).p.y){}
            else
                return true;

        }
        return false;

    }

    private static Map<Integer, Integer> factorize(int number) {
        Map<Integer, Integer> factors = new HashMap<Integer, Integer>();

        for (int i = 1; i < Math.sqrt(number); i++) {
            if (number % i == 0){
                if((number/i)>=minH && i>=minW ){
                    factors.put(i, number / i);
                }

                if(i>=minH && (number/i)>=minW){
                    factors.put(number / i,i);

                }
            }
        }

        return factors;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RectPack m = new RectPack();
        m.getRect();
        JFrame window = new JFrame();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(new RectPack());
        window.setBounds(30, 30, (boundingW*scale)+scale, boundingH*scale+(scale*2));
        window.setVisible(true);
    }

    private class Rectangle{
        public int width;
        public int height;
        public int area;
        public Point p;


    }

}


