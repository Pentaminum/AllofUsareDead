package com.CMPT276_Group1.project;

import com.CMPT276_Group1.project.entity.*;

import java.awt.*;
import java.awt.image.*;

/**
 * Class that includes utilities we may use
 */
public class UtilityTool {
    /**
     * Utility to scale image to a new size
     * @param original Original image
     * @param width new width
     * @param height new height
     * @return the scaled image
     */
    public BufferedImage scaleImage(BufferedImage original,int width, int height){
        BufferedImage scaledImage=new BufferedImage(width,height,original.getType());
        Graphics2D graphics2D=scaledImage.createGraphics();
        graphics2D.drawImage(original,0,0,width,height,null);
        graphics2D.dispose();
        return scaledImage;
    }

    /**
     * Utility to check if entity can move when collision is false
     * @param entity Original entity
     */
    public void moveConsideringCollision( Entity entity){
        if(!entity.collisionOn){
            switch (entity.direction) {
                case "up" -> entity.y -= entity.speed;
                case "down" -> entity.y += entity.speed;
                case "left" -> entity.x -= entity.speed;
                case "right" -> entity.x += entity.speed;
            }
        }
    }
}
