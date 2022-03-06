package com.CMPT276_Group1.project.object;

import com.CMPT276_Group1.project.*;

import javax.imageio.*;
import java.io.*;

public class Exit extends ObjectSuper{
    GamePanel gamePanel;
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
