package com.CMPT276_Group1.project.object;

import com.CMPT276_Group1.project.*;

import javax.imageio.*;
import java.awt.*;
import java.io.*;

/**
 * The trap class. Traps that can make the player lose health when they
 * pass through.
 */
public class Trap extends ObjectSuper {
    GamePanel gamePanel;

    /**
     * Constructor for features of the trap as well as the image of
     * the trap.
     * @param gamePanel the current gamePanel describing the game state
     */
    public Trap(GamePanel gamePanel){
        this.gamePanel=gamePanel;
        name="Trap";
        solidArea=new Rectangle();
        solidArea.x=23;
        solidArea.y=23;
        solidArea.width=2;
        solidArea.height=2;
        solidAreaDefaultX=solidArea.x;
        solidAreaDefaultY=solidArea.y;
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/objects/trap.png"));
            utilityTool.scaleImage(image,gamePanel.tileSize, gamePanel.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Check if the trap was hit by the player and if it did, then the trap
     * does damage to the player and the player becomes shortly invisible
     * @param i the index that specifies which of the 4 traps was hit
     *          by the player
     */
    public void checkEvent(int i){
        if(hit(gamePanel.traps[i].x/gamePanel.tileSize,gamePanel.traps[i].y/gamePanel.tileSize,"left")){
            trapDamage(gamePanel.playState, i,"left");
        }else if(hit(gamePanel.traps[i].x/gamePanel.tileSize,gamePanel.traps[i].y/gamePanel.tileSize,"right")){
            trapDamage(gamePanel.playState, i, "right");
        }else if(hit(gamePanel.traps[i].x/gamePanel.tileSize,gamePanel.traps[i].y/gamePanel.tileSize,"up")){
            trapDamage(gamePanel.playState, i, "up");
        }else if(hit(gamePanel.traps[i].x/gamePanel.tileSize,gamePanel.traps[i].y/gamePanel.tileSize,"down")){
            trapDamage(gamePanel.playState, i, "down");
        }
    }

    /**
     * Check if the trap is hit by the player
     * @param eventCol the location of the trap on the board in columns
     * @param eventRow the location of the trap on the board in rows
     * @param reqDirection check which specific direction the trap is
     *                     being hit
     * @return return whether the trap is hit by the player or not
     */
    public boolean hit(int eventCol, int eventRow, String reqDirection){
        boolean hit=false;
        gamePanel.player.solidArea.x=gamePanel.player.x+gamePanel.player.solidArea.x;
        gamePanel.player.solidArea.y=gamePanel.player.y+gamePanel.player.solidArea.y;
        solidArea.x=eventCol*gamePanel.tileSize+solidArea.x;
        solidArea.y=eventRow*gamePanel.tileSize+solidArea.y;

        if(gamePanel.player.solidArea.intersects(solidArea)){
            if(gamePanel.player.direction.contentEquals(reqDirection)||reqDirection.contentEquals("any")){
                hit=true;
            }
        }

        gamePanel.player.solidArea.x=gamePanel.player.solidAreaDefaultX;
        gamePanel.player.solidArea.y=gamePanel.player.solidAreaDefaultY;
        solidArea.x=solidAreaDefaultX;
        solidArea.y=solidAreaDefaultY;

        return hit;
    }

    /**
     * The player will lose one life and become shortly invincible
     * @param gameState the current game state
     * @param i the index that specifies which of the 4 traps was hit
     *          by the player
     * @param direction check for the collision at a specific direction
     */
    public void trapDamage(int gameState, int i, String direction){
        gamePanel.gameState=gameState;
        gamePanel.player.life-=1;
        if(!gamePanel.player.invincible){
            gamePanel.player.invincible=true;
        }
        switch ((direction)) {
            case "right" -> gamePanel.player.x += gamePanel.traps[i].solidArea.width + gamePanel.player.solidArea.width;
            case "left" -> gamePanel.player.x -= (gamePanel.traps[i].solidArea.width + gamePanel.player.solidArea.width);
            case "up" -> gamePanel.player.y -= (gamePanel.traps[i].solidArea.height + gamePanel.player.solidArea.height);
            case "down" -> gamePanel.player.y += gamePanel.traps[i].solidArea.height +gamePanel.player.solidArea.height;
        }

    }
}
