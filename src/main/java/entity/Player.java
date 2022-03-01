package main.java.entity;

import main.java.*;

import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;

public class Player extends Entity {
    GamePanel gamePanel;
    KeyHandler keyHandler;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        solidArea = new Rectangle(8, 16, 32, 32);

        setDefaultValue();
        getPlayerImage();
    }

    public void setDefaultValue() {
        health = 3;
        x = 48;
        y = 48;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/main_character_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/main_character_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/main_character_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/main_character_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/main_character_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/main_character_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/main_character_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/main_character_right_2.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyHandler.downPressed || keyHandler.upPressed || keyHandler.leftPressed || keyHandler.rightPressed) {
            if (keyHandler.upPressed) {
                direction = "up";
            } else if (keyHandler.downPressed) {
                direction = "down";
            } else if (keyHandler.leftPressed) {
                direction = "left";
            } else {
                direction = "right";
            }

            collisionOn = false;
            gamePanel.collisionChecker.checkTile(this);

            if (!collisionOn) {
                switch (direction) {
                    case "up" -> y -= speed;
                    case "down" -> y += speed;
                    case "left" -> x -= speed;
                    case "right" -> x += speed;
                }
            }

            spriteCounter++;
            if (spriteCounter > 20) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2D) {
        //g2D.setColor(Color.WHITE);
        //g2D.fillRect(x, y, gamePanel.tileSize, gamePanel.tileSize);
        BufferedImage image = null;
        switch (direction) {
            case "up" -> {
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
            }
            case "down" -> {
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
            }
            case "left" -> {
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
            }
            case "right" -> {
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
            }
        }
        g2D.drawImage(image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
    }
}
