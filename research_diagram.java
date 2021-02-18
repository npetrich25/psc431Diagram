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
String s = "";
ArrayList<Rectangle> Squares;
public void settings()
{
  fullScreen();
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
  }
  if (Squares.size() > 0)
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
  posX = mouseX;
  posY = mouseY;
  toggle = !toggle;
}
public void keyPressed()
{
  if (key == ' ')
  {
    toggle = !toggle;
  }
  if (key == '0')
  {
    saveFrame("petrich_research_question.jpeg");
  }
}
public void keyTyped()
{
  if (toggle == true)
  {
    s += key;
  }
}
class Rectangle 
{
  int x_,y_;
  String header = "";
  Rectangle(int x, int y)
  {
    x_ = x;
    y_ = y;
  }
  public void updateHeader(String s)
  {
    header = s;
  }
  public void drawRectangle()
  {
    fill(0xff86ADFF);
    rect(x_, y_, 100, 100, 7);
    fill(0);
    text(header, posX + 20, posY + 50);
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
