package com.CMPT276_Group1.project.object;

import com.CMPT276_Group1.project.*;

import java.awt.*;
import java.awt.image.*;

/**
 * Super object class that will be the parent to the other objects.
 * Defines member variables that will be used by all objects.
 */
public class ObjectSuper {
    public BufferedImage image,image2,image3;
    public String name;
    public boolean collision=false;
    public int x,y;
    public Rectangle solidArea=new Rectangle(0,0,48,48);
    public int solidAreaDefaultX=0,solidAreaDefaultY=0;
    UtilityTool utilityTool=new UtilityTool();

    /**
     * Draws the object images
     * @param graphics2D the 2D graphics for the images
     * @param gamePanel the current gamePanel describing the game state
     */
    public void draw(Graphics2D graphics2D, GamePanel gamePanel){
        graphics2D.drawImage(image,x,y,gamePanel.tileSize,gamePanel.tileSize,null);
    }
}
