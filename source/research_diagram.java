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

public class research_diagram extends PApplet {

// application constants
int frameWidth = 600;
int frameHeight = 400;

int posX, posY = -1;
boolean toggle = false;
boolean textMode = false;
boolean drawMode = false;
String s = "";
ArrayList<Rectangle> Squares = new ArrayList<Rectangle>();
int currentRect = 0;

public void settings()
{
  size(frameWidth, frameHeight);
}
public void setup()
{
}

public void draw()
{

  pushMatrix();
  if (toggle == true && posX > 0)
  {
    Rectangle temp = new Rectangle(posX, posY);
    Squares.add(temp);
    toggle = !toggle;
  }
  
  if (Squares.size() >= 0)
  {
    for (int i = 0; i < Squares.size(); i++)
    {
      Squares.get(i).drawRectangle();
    }
  }
  popMatrix();
}
public void mousePressed()
{
  if (!drawMode)
  {
    posX = mouseX;
    posY = mouseY;
  }
  else
  {
    
  }
  //toggle = !toggle;
}
public void keyPressed()
{
  if (key == '9')
  {
    toggle = !toggle;
  }
  if (key == '8')
  {
    drawMode = !drawMode;
  }
  if (key == '=' && textMode == true)
  {
    Squares.get(currentRect).updateHeader(s);
    currentRect++;
    textMode = !textMode;
    s = "";
  }
  if (key == '=' && textMode == false)
  {
    textMode = !textMode;
  }
  if (key == '0')
  {
    saveFrame("petrich_research_question.jpeg");
  }
}
public void keyTyped()
{
  if (textMode == true && key != '=')
  {
    s += key;
  }
}
class Rectangle 
{
  int x_,y_;
  String header_ = "";
  Rectangle(int x, int y)
  {
    x_ = x;
    y_ = y;
  }
  public void updateHeader(String header)
  {
    header_ = header;
  }
  public void drawRectangle()
  {
    fill(0xff86ADFF);
    rect(x_, y_, 100, 100, 7);
    
    fill(0);
    text(header_, x_ + 20, y_ + 50);
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "research_diagram" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
