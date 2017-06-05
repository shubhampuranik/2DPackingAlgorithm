package python;

import geometry.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by LG-2 on 6/1/2017.
 */
public class Python {
    public Rectangle bin,rects[];
    public Python(){}
    public Python(Rectangle bin,Rectangle[] rects){
        this.bin=bin;
        this.rects=rects;
    }
    public Rectangle[] fit() throws Exception{
        Rectangle fits[];
        String command="C:\\Python27\\python 2d.py 1 300 300 100 100";
        Process p=Runtime.getRuntime().exec(command);
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        while(br.read()!=-1){
            System.out.println(br.read());
        }
        return null;
    }
    public static void main(String[] args) {
        Python p=new Python();
        try{
            p.fit();
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
