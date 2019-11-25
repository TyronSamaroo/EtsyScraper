package gui;

import javax.swing.*;

/**
 * This runs the App using Swing.This is used I want to implement multithreading in my application.
 * @author tyronsamaroo
 *
 */
public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
    }
}
