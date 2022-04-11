package com.CMPT276_Group1.project.object;

import com.CMPT276_Group1.project.*;

import javax.imageio.*;
import java.io.*;

/**
 * The special reward class. Baseball bats around the map that the
 * player can choose to collect in order to kill the zombie.
 */
public class SpecialReward extends ObjectSuper {

    /**
     * Read and scale the special reward PNG file to get images of
     * the baseball bats.
     * @param gamePanel the current gamePanel describing the game state
     */
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
