package gui;

import javax.swing.*;

/**
 * This runs the App. This is used I want to implement multithreading in my application.
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
