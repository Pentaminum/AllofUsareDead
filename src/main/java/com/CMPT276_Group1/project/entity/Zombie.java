package com.CMPT276_Group1.project.entity;

import com.CMPT276_Group1.project.GamePanel;
import com.CMPT276_Group1.project.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Zombie extends Entity{
    GamePanel gamePanel;

    public Zombie(GamePanel gamePanel){
        this.gamePanel=gamePanel;
        name = "Zombie";
        speed = 1;
        maxLife = 1;
        life = maxLife;

        solidArea.x=3;
        solidArea.y=15;
        solidArea.width=40;
        solidArea.height=33;
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
        down1 = setUp("zombie_down_1");
        down1 = setUp("zombie_down_1");
        down1 = setUp("zombie_down_1");
        down1 = setUp("zombie_down_1");
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
            if(i>75 && i<=100){
                direction="right";
            }
            spriteCounter=0;
        }
    }
}
