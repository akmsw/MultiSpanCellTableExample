package multispancelltableexample;

import java.awt.Color;

interface ColoredCell {

  public void setBackground(Color color, int row, int column);
  public void setBackground(Color color, int[] rows, int[] columns);
  public void setForeground(Color color, int row, int column);
  public void setForeground(Color color, int[] rows, int[] columns);

  public Color getBackground(int row, int column);
  public Color getForeground(int row, int column);
}