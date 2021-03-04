package edu.touro.cs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HiLoGui extends JFrame {
    private HighLowGameHumanPicksInterface model;

    private JTextField userGuess;
    private JLabel promptLabel;
    private HiLoComputerPicks game = new HiLoComputerPicks(100);
    private boolean dirtyBit = true; // changes were made and were not saved

    private JLabel statusBar = new JLabel("I am a status bar");

    public HiLoGui(HighLowGameHumanPicksInterface myModel) { // constructor dependency injection
        model  = myModel;

        this.setTitle("First 364 GUI!!");
        System.out.println( "Ctor" + Thread.currentThread().getId());

        JPanel mainPanel = new JPanel();
        this.add(mainPanel, BorderLayout.CENTER);
        this.add(statusBar, BorderLayout.SOUTH);
        mainPanel.setLayout(new GridLayout(3,5));
        for (int i=0;i<15;i++)
        {
            JButton b;
            mainPanel.add(b = new JButton(i + ""));
            b.addActionListener(new ActionListener() { // Swing is not thread safe (unsafe to update GUI from a different thread)
                @Override
                public void actionPerformed(ActionEvent e) { // Event Dispatch Thread return within 100 ms

                    Thread workerThread = new Thread() { // just an object
                        @Override
                        public void run() { // like the "main" method or a process
                            updateStatusBarInEDT("Starting...");
                            System.out.println( "Run Method" + Thread.currentThread().getId());
                            slowMethod();
                            System.out.println( "Run Method" + Thread.currentThread().getId());
                            updateStatusBarInEDT("Completed!");
                        }
                    };
                    workerThread.start(); // tells OS to create a new thread and start executing it
                    System.out.println( "EDT" + Thread.currentThread().getId());

              }
            });
        }


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void updateStatusBarInEDT(String s)
    {
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() { // will run in the EDT
                        statusBar.setText(s);
                        System.out.println( "EDT" + Thread.currentThread().getId());
                    }
                }
        );
    }
    private void slowMethod()  {// Swing is not thread safe
        System.out.println("Start Slow Method");
        System.out.println( Thread.currentThread().getId());
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("End Slow Method");
    }


}
