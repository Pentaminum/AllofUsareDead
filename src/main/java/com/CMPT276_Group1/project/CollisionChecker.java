package com.CMPT276_Group1.project;


import com.CMPT276_Group1.project.entity.*;

/**
 * Class used to check for collisions between entities and other objects
 */
public class CollisionChecker {
    GamePanel gamePanel;

    /**
     * Constructor for the CollisionChecker instance
     * @param gamePanel the current gamePanel describing the game state
     */
    public CollisionChecker(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    /**
     * Check if the direction the entity is taking will cause collision with a tile, namely a wall
     * @param entity the entity for which we are checking collision
     */
    public void checkTile(Entity entity) {
        int entityPublicLeftX = entity.x + entity.solidArea.x;
        int entityPublicRightX = entity.x + entity.solidArea.x + entity.solidArea.width;
        int entityPublicTopY = entity.y + entity.solidArea.y;
        int entityPublicDownY = entity.y + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityPublicLeftX / gamePanel.tileSize;
        int entityRightCol = entityPublicRightX / gamePanel.tileSize;
        int entityTopRow = entityPublicTopY / gamePanel.tileSize;
        int entityBottomRow = entityPublicDownY / gamePanel.tileSize;

        int tileNum1, tileNum2;
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

    /**
     * Check if the entity makes contact with an object, if it is the player then we return the index of the object
     * @param entity the entity for which we are checking collision
     * @param player boolean describing if the entity is a player or not
     * @return returns the object index of the object if it was picked up by the player
     */
    public int checkObject(Entity entity, boolean player) {
        int index = 999;

        for (int i = 0; i < gamePanel.obj.length; i++) {
            if (gamePanel.obj[i] != null) {
                entity.solidArea.x = entity.x + entity.solidArea.x;
                entity.solidArea.y = entity.y + entity.solidArea.y;
                gamePanel.obj[i].solidArea.x = gamePanel.obj[i].x + gamePanel.obj[i].solidArea.x;
                gamePanel.obj[i].solidArea.y = gamePanel.obj[i].y + gamePanel.obj[i].solidArea.y;
                stopEntity(entity);
                if (entity.solidArea.intersects(gamePanel.obj[i].solidArea)) {
                    if (gamePanel.obj[i].collision) {
                        entity.collisionOn = true;
                    }
                    if (player) {
                        index = i;
                    }
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gamePanel.obj[i].solidArea.x = gamePanel.obj[i].solidAreaDefaultX;
                gamePanel.obj[i].solidArea.y = gamePanel.obj[i].solidAreaDefaultY;
            }
        }

        return index;
    }

    /**
     * If we encountered something we cannot move through then we will move the player back before the frame is drawn
     * @param entity the entity for which we are checking collision
     */
    private void stopEntity(Entity entity) {
        switch (entity.direction) {
            case "up" -> entity.solidArea.y -= entity.speed;
            case "down" -> entity.solidArea.y += entity.speed;
            case "left" -> entity.solidArea.x -= entity.speed;
            case "right" -> entity.solidArea.x += entity.speed;
        }
    }

    /**
     * Check if the player made contact with the given entity
     * @param entity the entity for which we are checking collision
     * @return whether the player made contact or not
     */
    public boolean checkPlayer(Entity entity) {
        boolean contactPlayer=false;
        entity.solidArea.x = entity.x + entity.solidArea.x;
        entity.solidArea.y = entity.y + entity.solidArea.y;
        gamePanel.player.solidArea.x = gamePanel.player.x + gamePanel.player.solidArea.x;
        gamePanel.player.solidArea.y = gamePanel.player.y + gamePanel.player.solidArea.y;
        stopEntity(entity);
        if (entity.solidArea.intersects(gamePanel.player.solidArea)) {
            entity.collisionOn = true;
            contactPlayer=true;
        }
        entity.solidArea.x = entity.solidAreaDefaultX;
        entity.solidArea.y = entity.solidAreaDefaultY;
        gamePanel.player.solidArea.x = gamePanel.player.solidAreaDefaultX;
        gamePanel.player.solidArea.y = gamePanel.player.solidAreaDefaultY;
        return contactPlayer;
    }

    /**
     * Check if any of the zombies made contact with the current entity
     * @param entity the entity for which we are checking collision
     * @param target the array of zombies created by the game
     * @return the index of the zombie that made contact with the entity
     */
    public int checkZombie(Entity entity, Entity[] target) {
        int index = 999;

        for (int i = 0; i < target.length; i++) {
            if (target[i] != null) {
                entity.solidArea.x = entity.x + entity.solidArea.x;
                entity.solidArea.y = entity.y + entity.solidArea.y;
                target[i].solidArea.x = target[i].x + target[i].solidArea.x;
                target[i].solidArea.y = target[i].y + target[i].solidArea.y;
                stopEntity(entity);
                if (entity.solidArea.intersects(target[i].solidArea)) {
                    if (target[i] != entity) {
                        entity.collisionOn = true;
                        index = i;
                    }
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                target[i].solidArea.x = target[i].solidAreaDefaultX;
                target[i].solidArea.y = target[i].solidAreaDefaultY;
            }
        }

        return index;
    }
}
