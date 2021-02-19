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

void settings()
{
  size(frameWidth, frameHeight);
}
void setup()
{
}

void draw()
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
void mousePressed()
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
void keyPressed()
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
void keyTyped()
{
  if (textMode == true && key != '=')
  {
    s += key;
  }
}
