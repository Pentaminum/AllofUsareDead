package main.java.object;

import main.java.*;

import java.awt.*;
import java.awt.image.*;

public class Location {
    public BufferedImage image;
    public String name;
    public boolean collision=false;
    public int x,y;
    public Rectangle solidArea=new Rectangle(0,0,48,48);
    public int solidAreaDefaultX=0,solidAreaDefaultY=0;

    public void draw(Graphics2D graphics2D, GamePanel gamePanel){
        graphics2D.drawImage(image,x,y,gamePanel.tileSize,gamePanel.tileSize,null);
    }
}
