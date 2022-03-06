package com.CMPT276_Group1.project;

import com.CMPT276_Group1.project.object.*;

import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;

public class UI {
    GamePanel gamePanel;
    Font arial_40, arial_80B;
    BufferedImage studentImage;
    BufferedImage heart_full,heart_half,heart_blank;
    public boolean gameFinished = false;
    private Graphics2D graphic2D;
    public int commandNum=0;

    public UI(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);
        RegularReward student = new RegularReward(gamePanel);
        studentImage = student.image;

        //Create HUD object
        ObjectSuper heart=new OBJ_Heart(gamePanel);
        heart_full = heart.image;
        heart_half=heart.image2;
        heart_blank=heart.image3;

    }

    public void draw(Graphics2D graphics2D) {
        this.graphic2D = graphics2D;

        //Title screen
        if(gamePanel.gameState==gamePanel.titleState){
            drawTitleScreen();
        }

        //Play state{
        if(gamePanel.gameState==gamePanel.playState){
            drawPlayerLife();
        }

        //Pause state
        if(gamePanel.gameState==gamePanel.pauseState){
            drawPlayerLife();
            drawPauseScreen();
        }

        /*if (gamePanel.gameState == gamePanel.titleState) {
            drawTitleScreen();
        } else {
            if (gameFinished) {
                gamePanel.stopMusic();
                graphics2D.setFont(arial_40);
                graphics2D.setColor(Color.WHITE);
                String text;
                int textlength;
                text = "You and your friends survived!";
                textlength = (int) graphics2D.getFontMetrics().getStringBounds(text, graphics2D).getWidth();
                int x = gamePanel.screenWidth / 2 - textlength / 2;
                int y = gamePanel.screenHeight / 2 - (gamePanel.tileSize * 3);
                graphics2D.drawString(text, x, y);

                graphics2D.setFont(arial_80B);
                graphics2D.setColor(Color.YELLOW);

                text = "Congratulations!";
                textlength = (int) graphics2D.getFontMetrics().getStringBounds(text, graphics2D).getWidth();
                x = gamePanel.screenWidth / 2 - textlength / 2;
                y = gamePanel.screenHeight / 2 + (gamePanel.tileSize * 2);
                graphics2D.drawString(text, x, y);
                gamePanel.gameThread = null;
            } else {
                graphics2D.setFont(arial_40);
                graphics2D.setColor(Color.WHITE);
                graphics2D.drawImage(studentImage, 0, 0, gamePanel.tileSize, gamePanel.tileSize, null);
                graphics2D.drawString("x " + gamePanel.player.hasRegularReward, 50, 35);
                if (gamePanel.gameState == gamePanel.playState) {

                }
                if (gamePanel.gameState == gamePanel.pauseState) {
                    drawPauseScreen();
                }
            }
        }*/
    }

    public void drawTitleScreen(){
        BufferedImage image1=null,image2=null;
        try{
            image1= ImageIO.read(getClass().getResourceAsStream("/symbol/enterSymbol.png"));
            image2= ImageIO.read(getClass().getResourceAsStream("/background/title_background.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        graphic2D.setColor(new Color(0,0,0));
        graphic2D.drawImage(image2,0,0,gamePanel.screenWidth,gamePanel.screenHeight,null);


        //Title name
        graphic2D.setFont(graphic2D.getFont().deriveFont(Font.BOLD,96F));
        String text="All of Us are Dead";
        int x=getXForCenterText(text);
        int y=gamePanel.tileSize*3;

        //Shadow
        graphic2D.setColor(Color.gray);
        graphic2D.drawString(text,x+5,y+5);
        //Main color
        graphic2D.setColor(Color.white);
        graphic2D.drawString(text,x,y);

        //Main character image
        x=gamePanel.screenWidth/2-(gamePanel.tileSize*2)/2;
        y+= gamePanel.tileSize*2;
        graphic2D.drawImage(gamePanel.player.down1,x,y, gamePanel.tileSize*2,gamePanel.tileSize*2,null);

        //Menu
        graphic2D.setFont(graphic2D.getFont().deriveFont(Font.BOLD,48F));

        text="New Game";
        x=getXForCenterText(text);
        y+=gamePanel.tileSize*4;
        graphic2D.drawString(text,x,y);
        if(commandNum==0){
            graphic2D.drawImage(image1,x+(int) graphic2D.getFontMetrics().getStringBounds(text, graphic2D).getWidth(),
                    y-gamePanel.tileSize,gamePanel.tileSize*2,(int)(gamePanel.tileSize*1.5),null);
        }

        text="Load Game";
        x=getXForCenterText(text);
        y+=gamePanel.tileSize*1.5;
        graphic2D.drawString(text,x,y);
        if(commandNum==1){
            graphic2D.drawImage(image1,x+(int) graphic2D.getFontMetrics().getStringBounds(text, graphic2D).getWidth(),
                    y-gamePanel.tileSize,gamePanel.tileSize*2,(int)(gamePanel.tileSize*1.5),null);
        }
        text="Quit";
        x=getXForCenterText(text);
        y+=gamePanel.tileSize*1.5;
        graphic2D.drawString(text,x,y);
        if(commandNum==2){
            graphic2D.drawImage(image1,x+(int) graphic2D.getFontMetrics().getStringBounds(text, graphic2D).getWidth(),
                    y-gamePanel.tileSize,gamePanel.tileSize*2,(int)(gamePanel.tileSize*1.5),null);
        }
    }

    public void drawPlayerLife(){
        int x=17*gamePanel.tileSize;
        int y=0;
        int i=0;

        //Draw max life
        while(i<gamePanel.player.maxLife/2){
            graphic2D.drawImage(heart_blank,x,y,null);
            i++;
            x+= gamePanel.tileSize;
        }

        //Reset
        x=17*gamePanel.tileSize;
        y=0;
        i=0;

        //Draw current life
        while(i< gamePanel.player.life){
            graphic2D.drawImage(heart_half,x,y,null);
            i++;
            if(i< gamePanel.player.life){
                graphic2D.drawImage(heart_full,x,y,null);
            }
            i++;
            x+=gamePanel.tileSize;
        }
    }

    public void drawPauseScreen() {
        String text = "PAUSED";
        int x = getXForCenterText(text);
        int y = gamePanel.screenHeight / 2;
        graphic2D.drawString(text, x, y);
    }

    public int getXForCenterText(String text) {
        int length = (int) graphic2D.getFontMetrics().getStringBounds(text, graphic2D).getWidth();
        return gamePanel.screenWidth / 2 - length / 2;

    }
}
