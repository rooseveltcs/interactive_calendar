
// public class AddRow {
//   public static void main(String[] argv) throws Exception {
//     DefaultTableModel model = new DefaultTableModel();
//      
//     model.addColumn("Color");
//     model.addColumn("Name");
//     model.addColumn("Extra");
// 
//     JTable table = new JTable(model);
//     
//     JButton b = new JButton("Add Row");
//     
// 
//     model = (DefaultTableModel) table.getModel();
//     model.addRow(new Object[]{"", "", ""});
//     JFrame f = new JFrame();
//     f.add(table);
//     f.add(b, BorderLayout.SOUTH);
//     f.setSize(300, 300);
//     f.add(new JScrollPane(table));
//     f.setVisible(true);
// 
//   }
// }


import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.*;	 
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AddRow {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                String[][] data = { { "Color", "Name", "Extra" } };
                String[] col = { "", "","" };
                final DefaultTableModel model = new DefaultTableModel(data, col);
                JTable table = new JTable(model);
                JButton addRow = new JButton("Add Row");
                addRow.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        model.addRow(new Object[] {});
                    }
                });
        
                JPanel panel = new JPanel(new BorderLayout());
                panel.add(new JScrollPane(table));
                panel.add(addRow, BorderLayout.SOUTH);
                JOptionPane.showMessageDialog(null, panel);
            }
        });
    }
}
