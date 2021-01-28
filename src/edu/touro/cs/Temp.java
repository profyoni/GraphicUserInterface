package edu.touro.cs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;



class MyWindow extends JFrame {
    private JTextField textField1, textField2;
    private JLabel sumLabel;
    private java.util.List<Point> pointList = new LinkedList<>();

    MyWindow() {
        this.setTitle("First 364 GUI!!");
        this.setSize(400, 200);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel topPanel = new JPanel();

        JButton button = new JButton("ADD"); // event source
        topPanel.add(button);

        // registering the event listener
        ActionListener al = new MyActionListener(); // 2
        button.addActionListener(al); // 3

        textField1 = new JTextField(10);
        topPanel.add(textField1);
        textField2 = new JTextField(10);
        topPanel.add(textField2);

        sumLabel = new JLabel("Sum will go here");
        topPanel.add(sumLabel);

        this.add(topPanel, BorderLayout.NORTH);

        this.addMouseMotionListener( new MyMouseMotionListner());


        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);

        g.setColor( new Color(255, 55,87));
        for(Point p: pointList)
        {
            g.fillOval(p.x, p.y, 4, 4);
        }

    }
    class MyMouseMotionListner implements MouseMotionListener{
        @Override
        public void mouseDragged(MouseEvent e) {
            System.out.println(String.format("Dragged at x:%d, y:%d", e.getX(), e.getY() ));
            MyWindow.this.pointList.add( e.getPoint());
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            System.out.println(String.format("Moved at x:%d, y:%d", e.getX(), e.getY() ));
        }
    }
    // event handler in an (nonstatic) inner class
    private class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton buttonSource = (JButton) e.getSource();
            String text1 = textField1.getText();
            String text2 = textField2.getText();

            String display = (Integer.parseInt(text1) + Integer.parseInt(text2)) + "";

            sumLabel.setText( display );
            buttonSource.setText(display);
        }
    }
}