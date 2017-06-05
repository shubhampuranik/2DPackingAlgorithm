package twodpacking;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by LG-2 on 5/30/2017.
 */
public class Demo extends JFrame {
    public Rectangle list[];
    public Demo(int w,int h,Rectangle list[]) throws HeadlessException {
        super("DEMO");
        this.list=list;
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
        for(Rectangle r:list){
            //g.drawRect(r.x,r.y,r.w,r.h);
            if(r!=null){
                Color col=new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
                g.setColor(col);
                g.fillRect(r.x,r.y,r.length,r.breadth);
                c=(c+1)%colors.length;
                //System.out.println(r);
            }
        }
    }
}