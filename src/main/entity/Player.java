package main.entity;

import main.java.*;

import java.awt.*;

public class Player extends Entity{
    GamePanel gamePanel;
    KeyHandler keyHandler;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        setDefaultValue();
    }
    public void setDefaultValue(){
        health=3;
        x=0;
        y=0;
        speed=4;
    }
    public void update() {
        if (keyHandler.upPressed) {
            y -= speed;
        } else if (keyHandler.downPressed) {
            y += speed;
        } else if (keyHandler.leftPressed) {
            x -= speed;
        } else if (keyHandler.rightPressed) {
            x += speed;
        }
    }
    public void draw(Graphics2D g2D){
        g2D.setColor(Color.WHITE);
        g2D.fillRect(x, y, gamePanel.tileSize, gamePanel.tileSize);
    }
}
