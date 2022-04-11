package com.CMPT276_Group1.project.object;

import com.CMPT276_Group1.project.*;

import java.io.*;

import static javax.imageio.ImageIO.read;

/**
 * The second regular reward class. One of the student around the map that the
 * player has to collect in order to win the game.
 */
public class RegularReward2 extends RegularReward{
    /**
     * Read and scale the regular reward PNG file to get images of
     * the student.
     * @param gamePanel the current gamePanel describing the game state
     */
    public RegularReward2(GamePanel gamePanel){
        super(gamePanel);
        name="Regular Reward 2";
        try{
            image= read(getClass().getResourceAsStream("/objects/regular_reward_2.png"));
            utilityTool.scaleImage(image,gamePanel.tileSize, gamePanel.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
