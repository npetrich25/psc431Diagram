class Rectangle 
{
  int x_,y_;
  String header_ = "";
  Rectangle(int x, int y)
  {
    x_ = x;
    y_ = y;
  }
  void updateHeader(String header)
  {
    header_ = header;
  }
  void drawRectangle()
  {
    fill(#86ADFF);
    rect(x_, y_, 100, 100, 7);
    
    fill(0);
    text(header_, x_ + 20, y_ + 50);
  }
}
