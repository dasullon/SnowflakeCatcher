 int a= (int)(Math.random()*255)+1;
 int b= (int)(Math.random()*255)+1;
 int c= (int)(Math.random()*255)+1;
    SnowFlake [] james;
    void setup()
    {
      size(300,300);
      background(0);
      james=new SnowFlake[100];
      for (int i =0; i<james.length; i++)
      {
        james[i] = new SnowFlake();
      }
    }

    void draw()
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
  void mouseDragged()
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
      void show()
      {
        fill(255);  
        ellipse(x, y, 3, 3);
      }
      void lookDown()
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

    void erase()
    {
      fill(0);
      ellipse(x,y,7,7);
    }
    void move()
    {
     if( isMoving==true){
      y++;
    }
  }
  void wrap()
  {
    if (y>295) {
      y=0;
    }
  }
}

