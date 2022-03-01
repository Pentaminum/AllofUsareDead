package main.java;

import main.java.entity.*;

public class CollisionChecker {
    GamePanel gamePanel;
    public CollisionChecker(GamePanel gamePanel){
        this.gamePanel=gamePanel;
    }

    public void checkTile(Entity entity){
        int entityPublicLeftX=entity.x+entity.solidArea.x;
        int entityPublicRightX=entity.x+entity.solidArea.x+entity.solidArea.width;
        int entityPublicTopY=entity.y+entity.solidArea.y;
        int entityPublicDownY=entity.y+entity.solidArea.y+entity.solidArea.height;

        int entityLeftCol=entityPublicLeftX/gamePanel.tileSize;
        int entityRightCol=entityPublicRightX/gamePanel.tileSize;
        int entityTopRow=entityPublicTopY/gamePanel.tileSize;
        int entityBottomRow=entityPublicDownY/gamePanel.tileSize;

        int tileNum1,tileNum2;
        switch (entity.direction) {
            case "up" -> {
                entityTopRow = (entityPublicTopY - entity.speed) / gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gamePanel.tileManager.mapTileNum[entityRightCol][entityTopRow];
                if (gamePanel.tileManager.tile[tileNum1].collision || gamePanel.tileManager.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
            }
            case "down" -> {
                entityBottomRow = (entityPublicDownY + entity.speed) / gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gamePanel.tileManager.mapTileNum[entityRightCol][entityBottomRow];
                if (gamePanel.tileManager.tile[tileNum1].collision || gamePanel.tileManager.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
            }
            case "left" -> {
                entityLeftCol = (entityPublicLeftX - entity.speed) / gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                if (gamePanel.tileManager.tile[tileNum1].collision || gamePanel.tileManager.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
            }
            case "right" -> {
                entityRightCol = (entityPublicRightX + entity.speed) / gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gamePanel.tileManager.mapTileNum[entityRightCol][entityBottomRow];
                if (gamePanel.tileManager.tile[tileNum1].collision || gamePanel.tileManager.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
            }
        }
    }
}
