package com.CMPT276_Group1.project.object;

import com.CMPT276_Group1.project.*;

import javax.imageio.*;
import java.io.*;

public class SpecialReward extends ObjectSuper {
    GamePanel gamePanel;
    public SpecialReward(GamePanel gamePanel){
        name="Special Reward";
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/objects/special_reward.png"));
            utilityTool.scaleImage(image,gamePanel.tileSize, gamePanel.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
