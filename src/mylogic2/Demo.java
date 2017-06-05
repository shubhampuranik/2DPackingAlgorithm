package mylogic2;



import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by LG-2 on 5/30/2017.
 */
public class Demo extends JFrame {
    public ArrayList<Rectangle> rectList;
    public Demo(int w, int h, ArrayList<Rectangle> rectList) throws HeadlessException {
        super("DEMO");
        this.rectList=rectList;
        setForeground(Color.white);
        setBackground(Color.white);
        setSize(w,h);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    @Override
    public void paint(Graphics g) {
        Color colors[]={Color.red,Color.green,Color.blue,Color.cyan,Color.orange,Color.magenta,Color.black,Color.pink,Color.yellow};
        Random random=new Random();
        int c=0;
        for(Rectangle r:rectList){
            if(r!=null){
                //Generate random colors
                Color col=new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
                g.setColor(Color.black);
                //Draw outlines
                g.drawRect(r.topLeft.x,r.topLeft.y,r.length,r.breadth);
                g.setColor(col);
                //Fill the rectangle with random color
                g.fillRect(r.topLeft.x+1,r.topLeft.y+1,r.length-1,r.breadth-1);
                g.setColor(Color.white);
                //Number the rectangle according to its ID
                g.drawString(new Integer(r.id).toString(),r.topLeft.x+r.length/2,r.topLeft.y+r.breadth/2);
                c=(c+1)%colors.length;
            }
        }

    }
}