package com.CMPT276_Group1.project.entity;

import com.CMPT276_Group1.project.object.*;

import java.awt.*;
import java.awt.image.*;

/**
 * Entity class that will be the parent to both zombie and player.
 * Defines member variables that will be used by all entities
 */
public abstract class Entity extends ObjectSuper {
    public int maxLife;
    public int life;
    public int speed;

    public boolean invincible=false;
    public int invincibleCounter=0;

    public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2;
    public String direction;

    public int spriteCounter=0;
    public int spriteNum=1;
    public Rectangle solidArea;
    public int solidAreaDefaultX,solidAreaDefaultY;
    public boolean collisionOn=false;
}
