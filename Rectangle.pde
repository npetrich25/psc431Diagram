class Rectangle 
{
  int x_,y_;
  String header = "";
  Rectangle(int x, int y)
  {
    x_ = x;
    y_ = y;
  }
  void updateHeader(String s)
  {
    header = s;
  }
  void drawRectangle()
  {
    fill(#86ADFF);
    rect(x_, y_, 100, 100, 7);
    fill(0);
    text(header, posX + 20, posY + 50);
  }
}
