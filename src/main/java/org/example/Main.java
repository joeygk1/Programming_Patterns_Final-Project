package org.example;

import org.example.controller.MainFrameController;
import org.example.view.MainFrame;

public class Main {
    public static void main(String[] args) {
        MainFrameController controller = new MainFrameController();
        new MainFrame(controller);
    }
}