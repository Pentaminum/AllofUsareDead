package com.CMPT276_Group1.project;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window =new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("All of Us are Dead 2D");

        GamePanel gamePanel=new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setupGameObject();
        gamePanel.startGameThread();
    }
}
