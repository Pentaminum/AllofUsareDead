package com.CMPT276_Group1.project.object;

import com.CMPT276_Group1.project.*;

import javax.imageio.*;
import java.io.*;

public class OBJ_Heart extends ObjectSuper{
    GamePanel gamePanel;
    public OBJ_Heart(GamePanel gamePanel){
        this.gamePanel=gamePanel;
        name="Heart";
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/objects/heart_full.png"));
            image2= ImageIO.read(getClass().getResourceAsStream("/objects/heart_half.png"));
            image3= ImageIO.read(getClass().getResourceAsStream("/objects/heart_blank.png"));
            image=utilityTool.scaleImage(image,gamePanel.tileSize, gamePanel.tileSize);
            image2=utilityTool.scaleImage(image2,gamePanel.tileSize, gamePanel.tileSize);
            image3=utilityTool.scaleImage(image3,gamePanel.tileSize, gamePanel.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
