package multispancelltableexample;

import java.awt.Font;

interface CellFont {

  public void setFont(Font font, int row, int column);
  public void setFont(Font font, int[] rows, int[] columns);

  public Font getFont(int row, int column);
}