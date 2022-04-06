package com.CMPT276_Group1.project.object;

import com.CMPT276_Group1.project.*;

import java.io.*;

import static javax.imageio.ImageIO.read;

public class RegularReward3 extends RegularReward{
    public RegularReward3(GamePanel gamePanel){
        super(gamePanel);
        name="Regular Reward 3";
        try{
            image= read(getClass().getResourceAsStream("/objects/regular_reward_3.png"));
            utilityTool.scaleImage(image,gamePanel.tileSize, gamePanel.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
