import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SnowflakeCatcher extends PApplet {

 int a= (int)(Math.random()*255)+1;
 int b= (int)(Math.random()*255)+1;
 int c= (int)(Math.random()*255)+1;
    SnowFlake [] james;
    public void setup()
    {
      size(300,300);
      background(0);
      james=new SnowFlake[100];
      for (int i =0; i<james.length; i++)
      {
        james[i] = new SnowFlake();
      }
    }

    public void draw()
    {
      for (int i=0; i< james.length;i++)
      {
        james[i].erase();
        james[i].lookDown();
        james[i].move();
        james[i].wrap();
        james[i].show();
      }  
    }
  public void mouseDragged()
    {
      stroke(a,b,c);
      line(pmouseX, pmouseY, mouseX, mouseY);
      stroke(0);
    }

    class SnowFlake
    {
      int x,y;
      boolean isMoving; 
      SnowFlake()
      {
        x=(int)(Math.random()*299 +1);
        y=(int)(Math.random()*299 +1);; 
        isMoving=true;  
      }
      public void show()
      {
        fill(255);  
        ellipse(x, y, 3, 3);
      }
      public void lookDown()
      {
       if (get(x,y+4)!=color(0,0,0))
       {
        isMoving=false;

      }
      else
      {
        isMoving=true;
      }
    }

    public void erase()
    {
      fill(0);
      ellipse(x,y,7,7);
    }
    public void move()
    {
     if( isMoving==true){
      y++;
    }
  }
  public void wrap()
  {
    if (y>295) {
      y=0;
    }
  }
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SnowflakeCatcher" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
