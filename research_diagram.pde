// application constants
int frameWidth = 600;
int frameHeight = 400;

int posX, posY = -1;
boolean toggle = false;
String s = "";
ArrayList<Rectangle> Squares;
void settings()
{
  fullScreen();
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
void mousePressed()
{
  posX = mouseX;
  posY = mouseY;
  toggle = !toggle;
}
void keyPressed()
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
void keyTyped()
{
  if (toggle == true)
  {
    s += key;
  }
}
