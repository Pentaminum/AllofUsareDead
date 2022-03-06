package com.CMPT276_Group1.project;

import com.CMPT276_Group1.project.object.*;

public class AssetSetter {
    GamePanel gamePanel;

    public AssetSetter(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void setObject(){
        gamePanel.obj[0]=new RegularReward(gamePanel);
        gamePanel.obj[0].x=gamePanel.tileSize;
        gamePanel.obj[0].y=14*gamePanel.tileSize;
        gamePanel.obj[1]=new SpecialReward(gamePanel);
        gamePanel.obj[1].x=8*gamePanel.tileSize;
        gamePanel.obj[1].y=8*gamePanel.tileSize;
        gamePanel.obj[3]=new Exit(gamePanel);
        gamePanel.obj[3].x=19*gamePanel.tileSize;
        gamePanel.obj[3].y=14*gamePanel.tileSize;
        gamePanel.obj[3].collision=true;
    }
    public void setTrap(){
        gamePanel.trap.x=10*gamePanel.tileSize;
        gamePanel.trap.y=5*gamePanel.tileSize;
    }
}
