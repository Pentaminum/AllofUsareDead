package com.CMPT276_Group1.project.entity;

import com.CMPT276_Group1.project.GamePanel;
import com.CMPT276_Group1.project.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Zombie extends Entity{
    GamePanel gamePanel;

    public Zombie(GamePanel gamePanel){
        this.gamePanel=gamePanel;
        name = "Zombie";
        speed = 2;
        maxLife = 1;
        life = maxLife;

        solidArea = new Rectangle(8, 16, 32, 32);
        solidAreaDefaultX=solidArea.x;
        solidAreaDefaultY=solidArea.y;

        getImage();
    }

    public BufferedImage setUp(String imageName) {
        UtilityTool utilityTool = new UtilityTool();
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/zombie/" + imageName + ".png"));
            image = utilityTool.scaleImage(image, gamePanel.tileSize, gamePanel.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public void getImage(){
        down1 = setUp("zombie_down_1");
        down2 = setUp("zombie_down_2");
        left1 = setUp("zombie_left_1");
        left2 = setUp("zombie_left_2");
        right1 = setUp("zombie_right_1");
        right2 = setUp("zombie_right_2");
        up1 = setUp("zombie_up_1");
        up2 = setUp("zombie_up_2");
    }

    public void update() {
        setAction();
        //check tile collision
        collisionOn = false;
        gamePanel.collisionChecker.checkTile(this);

        //check object collision
        gamePanel.collisionChecker.checkObject(this, false);

        //check zombie collision
        gamePanel.collisionChecker.checkZombie(this, gamePanel.zombies);

        //check player collision
        gamePanel.collisionChecker.checkPlayer(this);


        if (!collisionOn) {
            switch (direction) {
                case "up" -> y -= speed;
                case "down" -> y += speed;
                case "left" -> x -= speed;
                case "right" -> x += speed;
            }
        }
    }

    public void setAction(){
        spriteCounter ++;
        if(spriteCounter==120){
            Random random = new Random();
            int i = random.nextInt(100)+1;
            if(i<=25){
                direction="up";
            }
            if(i>25 && i<=50){
                direction="down";
            }
            if(i>50 && i<=75){
                direction="left";
            }
            if(i>75){
                direction="right";
            }

            if (spriteNum == 1) {
                spriteNum = 2;
            } else {
                spriteNum = 1;
            }
            spriteCounter=0;
        }
    }

    public void draw(Graphics2D g2D) {
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
        g2D.drawImage(image, x, y, null);
    }

}
