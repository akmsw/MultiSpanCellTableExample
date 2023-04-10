package multispancelltableexample;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class MultiSpanCellTableExample extends JFrame {

  MultiSpanCellTableExample() {
    super("Multi-Span Cell Example");

    AttributiveCellTableModel ml = new AttributiveCellTableModel(10, 6);

    final CellSpan cellAtt = (CellSpan) ml.getCellAttribute();
    final MultiSpanCellTable table = new MultiSpanCellTable(ml);

    JScrollPane scroll = new JScrollPane(table);

    JButton bOne = new JButton("Combine");
    bOne.addActionListener(e -> {
      int[] columns = table.getSelectedColumns();
      int[] rows = table.getSelectedRows();

      cellAtt.combine(rows, columns);

      table.clearSelection();
      table.revalidate();
      table.repaint();
    });

    JButton bSplit = new JButton("Split");
    bSplit.addActionListener(e -> {
      int column = table.getSelectedColumn();
      int row = table.getSelectedRow();

      cellAtt.split(row, column);

      table.clearSelection();
      table.revalidate();
      table.repaint();
    });

    JPanel pButtons = new JPanel();
    pButtons.setLayout(new GridLayout(2, 1));
    pButtons.add(bOne);
    pButtons.add(bSplit);

    Box box = new Box(BoxLayout.X_AXIS);
    box.add(scroll);
    box.add(new JSeparator(SwingConstants.HORIZONTAL));
    box.add(pButtons);

    getContentPane().add(box);
    setSize(400, 200);
    setVisible(true);
  }

  public static void main(String[] args) {
    MultiSpanCellTableExample frame = new MultiSpanCellTableExample();
    frame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }
}