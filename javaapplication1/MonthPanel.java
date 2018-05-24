/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
/*  w w w .ja  v  a  2  s  .c o  m*/
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MonthPanel extends JPanel implements ActionListener {
  int month;
  int year;
  private JPanel contentPanel; 
  protected String[] monthNames = { "January", "February", "March", "April",
      "May", "June", "July", "August", "September", "October", "November",
      "December" };

  protected String[] dayNames = { "S", "M", "T", "W", "T", "F", "S" };

  private WeekPanel weekPanel;
  
  void set(WeekPanel tmp){ 
        weekPanel = tmp;
   }
  
  public MonthPanel(JPanel panel, int month, int day, int year) {
    this.month = month-1;
    this.year = year;
    
    contentPanel = panel;
    
    JPanel monthPanel = new JPanel(true);
    monthPanel.setLayout(new BorderLayout());
    monthPanel.add(createTitleGUI(), BorderLayout.NORTH);
    monthPanel.add(createDaysGUI(), BorderLayout.SOUTH);
    this.add(monthPanel);
  }
  
  protected JPanel createTitleGUI() {
    JPanel titlePanel = new JPanel(true);
    titlePanel.setLayout(new FlowLayout());
    titlePanel.setBackground(Color.WHITE);

    JLabel label = new JLabel(monthNames[month] + " " + year);
    label.setForeground(SystemColor.activeCaption);
    titlePanel.add(label, BorderLayout.CENTER);
    return titlePanel;
  }

  protected JPanel createDaysGUI() {
    JPanel dayPanel = new JPanel(true);
    dayPanel.setLayout(new GridLayout(0, dayNames.length));

    Calendar today = Calendar.getInstance();
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.MONTH, month);
    calendar.set(Calendar.YEAR, year);
    calendar.set(Calendar.DAY_OF_MONTH, 1);

    Calendar iterator = (Calendar) calendar.clone();
    iterator.add(Calendar.DAY_OF_MONTH,
        -(iterator.get(Calendar.DAY_OF_WEEK) - 1));

    Calendar maximum = (Calendar) calendar.clone();
    maximum.add(Calendar.MONTH, +1);

    // draw the name of day 
    for (int i = 0; i < dayNames.length; i++) {
      JPanel dPanel = new JPanel(true);
      dPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      JLabel dLabel = new JLabel(dayNames[i]);
      dPanel.add(dLabel);
      

      
      dayPanel.add(dPanel);
    }

    int count = 0;
    int limit = dayNames.length * 6;

    while (iterator.getTimeInMillis() < maximum.getTimeInMillis()) {
      int lMonth = iterator.get(Calendar.MONTH);
      int lYear = iterator.get(Calendar.YEAR);

      JPanel dPanel = new JPanel(true);
      dPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      JLabel dayLabel = new JLabel();
      
      
      

      if ((lMonth == month) && (lYear == year)) {
        int lDay = iterator.get(Calendar.DAY_OF_MONTH);
        dayLabel.setText(Integer.toString(lDay));
        JButton button = new JButton();
        button.setText(Integer.toString(lDay));
        button.setOpaque(false);
//      button.setContentAreaFilled(false);
        button.setBackground(Color.WHITE);
        button.setBorderPainted(false);
        
        button.addActionListener(this );
        

        dPanel.add(button);
      } 
//      dPanel.add(dayLabel);


      dayPanel.add(dPanel);

      
//      button.setOpaque(false);
//      button.setContentAreaFilled(false);
//      button.setBorderPainted(false);
      
      

      
      iterator.add(Calendar.DAY_OF_YEAR, +1);
      count++;
    }

    for (int i = count; i < limit; i++) {
      JPanel dPanel = new JPanel(true);
      dPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

      dPanel.add(new JLabel());
      
      dayPanel.add(dPanel);
    }
    return dayPanel;
  }
  
  
  

    
  
  public void actionPerformed(ActionEvent a) {
        JButton button = (JButton) a.getSource();
        System.out.println(button.getText());
      
        CardLayout cardLayout = (CardLayout) (contentPanel.getLayout());
        cardLayout.show(contentPanel, "Panel2");
        weekPanel.buttonText(button.getText());
    }
  
}