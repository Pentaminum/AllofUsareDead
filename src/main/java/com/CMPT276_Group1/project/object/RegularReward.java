package com.CMPT276_Group1.project.object;

import com.CMPT276_Group1.project.*;
import com.CMPT276_Group1.project.object.*;

import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

import static javax.imageio.ImageIO.read;

/**
 * The regular reward class. Students around the map that the
 * player has to collect in order to win the game.
 */
public class RegularReward extends ObjectSuper {
    /**
     * Read and scale the regular reward PNG file to get images of
     * the students.
     * @param gamePanel the current gamePanel describing the game state
     */
    public RegularReward(GamePanel gamePanel){
        name="Regular Reward";
        try{
            image= read(getClass().getResourceAsStream("/objects/regular_reward.png"));
            utilityTool.scaleImage(image,gamePanel.tileSize, gamePanel.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
