package com.CMPT276_Group1.project.object;

import com.CMPT276_Group1.project.*;

import javax.imageio.*;
import java.awt.*;
import java.io.*;

public class Trap extends ObjectSuper {
    GamePanel gamePanel;
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
    public void checkEvent(){
        if(hit(gamePanel.trap.x/gamePanel.tileSize,gamePanel.trap.y/gamePanel.tileSize,"left")){
            trapDamage(gamePanel.playState, "left");
        }else if(hit(gamePanel.trap.x/gamePanel.tileSize,gamePanel.trap.y/gamePanel.tileSize,"right")){
            trapDamage(gamePanel.playState, "right");
        }else if(hit(gamePanel.trap.x/gamePanel.tileSize,gamePanel.trap.y/gamePanel.tileSize,"up")){
            trapDamage(gamePanel.playState, "up");
        }else if(hit(gamePanel.trap.x/gamePanel.tileSize,gamePanel.trap.y/gamePanel.tileSize,"down")){
            trapDamage(gamePanel.playState, "down");
        }
    }
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

    public void trapDamage(int gameState, String direction){
        gamePanel.gameState=gameState;
        gamePanel.player.life-=1;
        switch ((direction)) {
            case "right" -> gamePanel.player.x += gamePanel.trap.solidArea.width + gamePanel.player.solidArea.width;
            case "left" -> gamePanel.player.x -= (gamePanel.trap.solidArea.width + gamePanel.player.solidArea.width);
            case "up" -> gamePanel.player.y -= (gamePanel.trap.solidArea.height + gamePanel.player.solidArea.height);
            case "down" -> gamePanel.player.y += gamePanel.trap.solidArea.height +gamePanel.player.solidArea.height;
        }

    }
}
