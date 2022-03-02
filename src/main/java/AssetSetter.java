package main.java;

import main.java.object.*;

public class AssetSetter {
    GamePanel gamePanel;

    public AssetSetter(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void setObject(){
        gamePanel.obj[0]=new RegularReward();
        gamePanel.obj[0].x=gamePanel.tileSize;
        gamePanel.obj[0].y=14*gamePanel.tileSize;
        gamePanel.obj[1]=new SpecialReward();
        gamePanel.obj[1].x=8*gamePanel.tileSize;
        gamePanel.obj[1].y=8*gamePanel.tileSize;
        gamePanel.obj[2]=new Trap();
        gamePanel.obj[2].x=18*gamePanel.tileSize;
        gamePanel.obj[2].y=gamePanel.tileSize;

    }
}
