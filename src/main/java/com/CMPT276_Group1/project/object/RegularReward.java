package com.CMPT276_Group1.project.object;

import com.CMPT276_Group1.project.*;
import com.CMPT276_Group1.project.object.*;

import javax.imageio.*;
import java.io.*;

public class RegularReward extends ObjectSuper {
    GamePanel gamePanel;
    public RegularReward(GamePanel gamePanel){
        name="Regular Reward";
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/objects/regular_reward.png"));
            utilityTool.scaleImage(image,gamePanel.tileSize, gamePanel.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
