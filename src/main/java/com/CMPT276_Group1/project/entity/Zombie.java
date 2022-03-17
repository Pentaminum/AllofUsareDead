package com.CMPT276_Group1.project.entity;

import com.CMPT276_Group1.project.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * The Zombie class that implements all interactions the zombies
 * has with entities
 */
public class Zombie extends Entity {
    GamePanel gamePanel;

    /**
     * The constructor that initializes the features of the zombies
     * as well as the areas
     * @param gamePanel the current gamePanel describing the game state
     */
    public Zombie(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        name = "Zombie";
        speed = 2;
        maxLife = 1;
        life = maxLife;

        solidArea = new Rectangle(8, 16, 32, 32);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getImage();
    }

    /**
     * Read and scale the png files that can then be displayed
     * on the screen.
     * @param imageName a PNG file of the image
     * @return the image of the specified PNG
     */
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

    /**
     * Setting zombie sprite.
     */
    public void getImage() {
        down1 = setUp("zombie_down_1");
        down2 = setUp("zombie_down_2");
        left1 = setUp("zombie_left_1");
        left2 = setUp("zombie_left_2");
        right1 = setUp("zombie_right_1");
        right2 = setUp("zombie_right_2");
        up1 = setUp("zombie_up_1");
        up2 = setUp("zombie_up_2");
    }

    /**
     * Update the action of the zombies and check for collisions.
     * If moving enemies pass through cells that contain rewards
     * or punishments, it won’t affect the awards/punishments.
     * The enemies cannot go through the walls/barriers either.
     */
    public void update() {
        setAction();
        //chase();
        //check tile collision
        collisionOn = false;
        gamePanel.collisionChecker.checkTile(this);

        //check object collision
        gamePanel.collisionChecker.checkObject(this, false);

        //check zombie collision
        gamePanel.collisionChecker.checkZombie(this, gamePanel.zombies);

        //check player collision
        boolean attack = gamePanel.collisionChecker.checkPlayer(this);
        contactPlayer(attack, this);

        if (!collisionOn) {
            switch (direction) {
                case "up" -> y -= speed;
                case "down" -> y += speed;
                case "left" -> x -= speed;
                case "right" -> x += speed;
            }
        }
    }

    /**
     * Set the action of the zombies. When the distance between the
     * Zombie and the Player is less than three times the tile size,
     * The Zombie will move towards a direction that makes them
     * closest to the current position of the Player. Otherwise,
     * they will move randomly.
     */
    public void setAction() {
        spriteCounter++;
        int playerX = gamePanel.player.x;
        int playerY = gamePanel.player.y;
        int distance = (int) Math.sqrt((playerX - x) * (playerX - x) + (playerY - y) * (playerX - y));
        if (distance <= 3 * gamePanel.tileSize) {
            speed=3;
            if (spriteCounter == 20) {
                if (x < playerX) {
                    direction="right";
                } else if (x > playerX+gamePanel.player.solidArea.width) {
                    direction="left";
                } else {
                    if(y<playerY){
                        direction="down";
                    }else if(y>playerY+gamePanel.player.solidArea.height){
                        direction="up";
                    }
                }
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        } else {
            speed=2;
            if (spriteCounter == 20) {
                Random random = new Random();
                int i = random.nextInt(100) + 1;
                if (i <= 25) {
                    direction = "up";
                }
                if (i > 25 && i <= 50) {
                    direction = "down";
                }
                if (i > 50 && i <= 75) {
                    direction = "left";
                }
                if (i > 75) {
                    direction = "right";
                }

                if (spriteNum == 1) {
                    spriteNum = 2;
                } else {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    /**
     * When the Zombie contact the Player, if the Player has a special
     * reward, then the Player can kill the Zombie. Otherwise, the
     * player will lose one life and become invincible for a few seconds.
     * @param isPlayer Whether the object that contacts the Zombie is
     *                 a player or not
     * @param entity An Entity object to test whether the zombie is still
     *               an entity
     */
    public void contactPlayer(boolean isPlayer, Entity entity) {
        if (isPlayer) {
            if (gamePanel.player.hasSpecialReward == 0) {
                if (!gamePanel.player.invincible) {
                    gamePanel.player.life -= 1;
                    gamePanel.player.invincible = true;
                }
            } else {
                gamePanel.player.hasSpecialReward--;
                for (int i = 0; i < gamePanel.zombies.length; i++) {
                    if (gamePanel.zombies[i] == entity) {
                        gamePanel.zombies[i] = null;
                    }
                }
            }
        }
    }

    /**
     * Draws the images of the Zombies in each case.
     * @param g2D the 2D graphics parameter
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
        g2D.drawImage(image, x, y, null);
    }

}
