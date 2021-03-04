package edu.touro.cs;

import javax.swing.*;

class InvalidResponseException extends RuntimeException
{
    InvalidResponseException(){
    }

    InvalidResponseException(String message){
        super(message);
    }
    InvalidResponseException(String message, Throwable cause){
        super(message, cause);
    }
}

public class Main {
    public static int x = 0;
    public static void main(String[] args) {
        System.out.println( "Main " + Thread.currentThread().getId());
        HighLowGameHumanPicksModel model = new HighLowGameHumanPicksModel(1_000);
        HiLoGui mw = new HiLoGui( model );
//        HiLoGui mw1 = new HiLoGui( new HighLowGameHumanPicksModelBrainwaveScanner() );
//
//        HiLoConsoleApp app = new HiLoConsoleApp(new HighLowGameHumanPicksModel(1_000));
//        AlexaApp app = new AlexaApp(new HighLowGameHumanPicksModel(1_000));

//        boolean tryAgain = false;
//        do {
//            try {
//                selectDrink();
//                tryAgain = false;
//            } catch (InvalidResponseException ire) {
//                tryAgain = true;
//            }
//        } while (tryAgain);

    }
    static class MyThread extends Thread {
        @Override
        public void run() { // like the "main" method or a process
            for (int i = 0; i < 10_000_000; i++)
                x++;
            System.out.println("Finito");
        }
    }

    public static void main2(String[] args) {
        Thread workerThread1 = new MyThread();
        Thread workerThread2 = new Thread() { // just an object
            @Override
            public void run() { // like the "main" method or a program
                for (int i = 0; i < 10_000_000; i++)
                    x++;
                System.out.println("Finito");
            }
        };
        workerThread1.start();// OS creates a thread and start it...which call run
        workerThread2.start(); // causes a race condition: when the result of multithreading
        // (running in parallel)
        // is different than a sequential process

        try {
            Thread.sleep(2_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(x);
    }
    private static void selectDrink() {

        int selection = -1;
        try {
            String[] drinks = {"Coke", "Sprite", "Ginger Ale"};
            System.out.println("Select a drink");
            for (int i = 0; i < drinks.length; i++) {
                System.out.println(String.format("%d : %s", i, drinks[i]));
            }
            selection = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "Enter the item number", "Drink Selector"));

            System.out.println("Enjoy your " + drinks[selection]);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new InvalidResponseException(
                    String.format("Option [%d] selected not supported", selection), e);
        }
    }
}





