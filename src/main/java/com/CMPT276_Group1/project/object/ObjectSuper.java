package com.CMPT276_Group1.project.object;

import com.CMPT276_Group1.project.*;

import java.awt.*;
import java.awt.image.*;

public class ObjectSuper {
    public BufferedImage image,image2,image3;
    public String name;
    public boolean collision=false;
    public int x,y;
    public Rectangle solidArea=new Rectangle(0,0,48,48);
    public int solidAreaDefaultX=0,solidAreaDefaultY=0;
    UtilityTool utilityTool=new UtilityTool();

    public void draw(Graphics2D graphics2D, GamePanel gamePanel){
        graphics2D.drawImage(image,x,y,gamePanel.tileSize,gamePanel.tileSize,null);
    }
}
