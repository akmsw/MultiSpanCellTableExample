package multispancelltableexample;

import java.awt.Dimension;

 interface CellAttribute {

  public void addColumn();
  public void addRow();
  public void insertRow(int row);
  public void setSize(Dimension size);

  public Dimension getSize();
}