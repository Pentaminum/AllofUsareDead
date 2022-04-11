package com.CMPT276_Group1.project.entity;


import com.CMPT276_Group1.project.*;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.*;
import java.awt.image.*;

/**
 * Player class that handles the player and all interactions the player has with entities
 */
public class Player extends Entity {
    GamePanel gamePanel;
    KeyHandler keyHandler;
    public int hasRegularReward = 0;
    public int hasSpecialReward = 0;
    public int zombieDefeated=0;
    UtilityTool tool=new UtilityTool();
    /**
     * Constructor for Player class
     * @param gamePanel the current gamePanel describing the game state
     * @param keyHandler the key handler parameter
     */
    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        name="Player";

        solidArea = new Rectangle(8, 16, 32, 32);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        setDefaultValue();
        getPlayerImage();
    }

    /**
     * Set default values for the player class that were not set in the constructor
     */
    public void setDefaultValue() {
        x = 48;
        y = 48;
        speed = 4;
        direction = "down";

        //Player Status
        maxLife=6;
        life=maxLife;
    }

    /**
     * Setting player sprite
     */
    public void getPlayerImage() {
        up1 = setImage("main_character_up_1");
        up2 = setImage("main_character_up_2");
        down1 = setImage("main_character_down_1");
        down2 = setImage("main_character_down_2");
        left1 = setImage("main_character_left_1");
        left2 = setImage("main_character_left_2");
        right1 = setImage("main_character_right_1");
        right2 = setImage("main_character_right_2");
    }

    /**
     * Reading our png files to get the player sprite
     * @param imageName a PNG file of the image
     * @return the image of the specified PNG
     */
    public BufferedImage setImage(String imageName) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/player/" + imageName + ".png"));
            image = tool.scaleImage(image, gamePanel.tileSize, gamePanel.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    /**
     * Updates our player on each frame based on player input
     */
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

            //check tile collision
            collisionOn = false;
            gamePanel.collisionChecker.checkTile(this);

            //check object collision
            int objectIndex = gamePanel.collisionChecker.checkObject(this, true);
            pickUpObject(objectIndex);

            //check trap
            for (int i= 0; i< gamePanel.traps.length; i++) {
                gamePanel.traps[i].checkEvent(i);
            }
            //check zombie
            int monsterIndex=gamePanel.collisionChecker.checkZombie(this,gamePanel.zombies);
            contactZombie(monsterIndex);

            //if collision is false player can move
            tool.moveConsideringCollision(this);

            spriteCounter++;
            if (spriteCounter > 10) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }

        if(invincible){
            invincibleCounter++;
            if(invincibleCounter>60){
                invincible=false;
                invincibleCounter=0;
            }
        }
    }

    /**
     * Allows player to pickup objects and exit the game when they have picked up all objects
     * @param i an index to the reward array
     */
    public void pickUpObject(int i) {
        if (i != 999) {
            String objectName = gamePanel.obj[i].name;
            switch (objectName) {
                case "Regular Reward" -> {
                    hasRegularReward++;
                    gamePanel.obj[i] = null;
                    gamePanel.playSoundEffect(1);
                }
                case "Regular Reward 2"->{
                    hasRegularReward++;
                    gamePanel.obj[i] = null;
                    gamePanel.playSoundEffect(2);
                }
                case "Regular Reward 3"->{
                    hasRegularReward++;
                    gamePanel.obj[i] = null;
                    gamePanel.playSoundEffect(3);
                }
                case "Special Reward" -> {
                    hasSpecialReward++;
                    gamePanel.obj[i] = null;
                    gamePanel.playSoundEffect(4);
                }
                case "Exit" -> {
                    if (hasRegularReward == 3) {
                        gamePanel.stopMusic();
                        gamePanel.playSoundEffect(5);
                        gamePanel.gameState=gamePanel.finishState;
                    }
                }
            }
        }
    }

    /**
     * Make the player take damage when they make contact with a zombie
     * @param i an index to the zombie array
     */
    public void contactZombie(int i){
        if(i!=999){
            if(hasSpecialReward==0){
                if(!invincible){
                    if(life<=0){
                        gamePanel.gameState= gamePanel.finishState;
                    }else{
                        life-=1;
                        invincible=true;
                    }
                }
            }else{
                hasSpecialReward--;
                zombieDefeated++;
                gamePanel.playSoundEffect(8);
                gamePanel.zombies[i]=null;
            }
        }
    }

    /**
     * Draw the player sprite based on what direction the player is moving
     * @param g2D 2D graphics parameter
     */
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
        if(invincible){
            g2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.3f));
        }
        g2D.drawImage(image, x, y, null);
        g2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f));
    }
}
