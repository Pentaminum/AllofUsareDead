package com.CMPT276_Group1.project.object;

import com.CMPT276_Group1.project.*;

import javax.imageio.*;
import java.io.*;

/**
 * The exit class that allows the player to exit the game.
 */
public class Exit extends ObjectSuper{

    /**
     * Read and scale the exit PNG file to get the door image.
     * @param gamePanel the current gamePanel describing the game state
     */
    public Exit(GamePanel gamePanel){
        name="Exit";
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/objects/exit.png"));
            utilityTool.scaleImage(image,gamePanel.tileSize, gamePanel.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
