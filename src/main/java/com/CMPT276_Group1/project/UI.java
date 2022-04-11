package com.CMPT276_Group1.project;

import com.CMPT276_Group1.project.object.*;

import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;

/**
 * This class is to create and operate our User Interface for the game
 */
public class UI {
    GamePanel gamePanel;
    public BufferedImage heart_full,heart_half,heart_blank;
    public BufferedImage image1,image2;
    private Graphics2D graphic2D;
    public int commandNum=0;
    public int score=0;
    public int x=0,y=0;
    public String text="";

    /**
     * Constructor for the UI
     * @param gamePanel the game instance
     */
    public UI(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        RegularReward student = new RegularReward(gamePanel);
        //Create HUD object
        ObjectSuper heart=new OBJ_Heart(gamePanel);
        heart_full = heart.image;
        heart_half=heart.image2;
        heart_blank=heart.image3;

    }

    /**
     * Draw the UI onto the screen and take into account the different game states.
     * @param graphics2D the graphics object we will use to draw the UI
     */
    public void draw(Graphics2D graphics2D) {
        this.graphic2D = graphics2D;

        //Title screen
        if(gamePanel.gameState==gamePanel.titleState){
            drawTitleScreen();
        }

        //Play state{
        if(gamePanel.gameState==gamePanel.playState){
            drawPlayerLife();
            if(gamePanel.player.life==0){
                gamePanel.gameState=gamePanel.finishState;
                gamePanel.stopMusic();
                gamePanel.playSoundEffect(7);
            }
        }

        //Pause state
        if(gamePanel.gameState==gamePanel.pauseState){
            drawPlayerLife();
            drawPauseScreen();
        }

        //Finish state
        if(gamePanel.gameState==gamePanel.finishState){
            drawFinishScreen();
        }
    }

    /**
     * Preparing the screen to draw either the title screen or finish screen. This code was duplicated among two methods
     * so we turned it into its own method
     */
    public void prepareScreen(){
        try{
            image1= ImageIO.read(getClass().getResourceAsStream("/symbol/enterSymbol.png"));
            image2= ImageIO.read(getClass().getResourceAsStream("/background/title_background.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        graphic2D.setColor(new Color(0,0,0));
        graphic2D.drawImage(image2,0,0,gamePanel.screenWidth,gamePanel.screenHeight,null);

        //Setting font
        graphic2D.setFont(graphic2D.getFont().deriveFont(Font.BOLD,96F));
    }
    /**
     * Draws the title screen part by part onto the window
     */
    public void drawTitleScreen(){
        prepareScreen();
        text="All of Us are Dead";
        x=getXForCenterText(text);
        y=gamePanel.tileSize*3;

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
        text="Quit";
        x=getXForCenterText(text);
        y+=gamePanel.tileSize*2;
        graphic2D.drawString(text,x,y);
        if(commandNum==1){
            graphic2D.drawImage(image1,x+(int) graphic2D.getFontMetrics().getStringBounds(text, graphic2D).getWidth(),
                    y-gamePanel.tileSize,gamePanel.tileSize*2,(int)(gamePanel.tileSize*1.5),null);
        }
    }

    /**
     * Draws the player health bar depending on current life
     */
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

    /**
     * Draw the pause screen
     */
    public void drawPauseScreen() {
        String text = "PAUSED";
        int x = getXForCenterText(text);
        int y = gamePanel.screenHeight / 2;
        graphic2D.drawString(text, x, y);
    }

    /**
     * Draw the finish screen for either victory or defeat
     */
    public void drawFinishScreen(){
        prepareScreen();
        String text="All of Us are Dead";
        int x=getXForCenterText(text);
        int y=gamePanel.tileSize*3;

        //Shadow
        graphic2D.setColor(Color.gray);
        graphic2D.drawString(text,x+5,y+5);
        //Main color
        graphic2D.setColor(Color.white);
        graphic2D.drawString(text,x,y);

        //Menu
        graphic2D.setFont(graphic2D.getFont().deriveFont(Font.BOLD,48F));

        if(gamePanel.player.life==0){
            text="Game Over!!!";
            x=getXForCenterText(text);
            y+=gamePanel.tileSize*2;
            graphic2D.drawString(text,x,y);
            score=0;
        }else{
            text="Victory";
            x=getXForCenterText(text);
            y+=gamePanel.tileSize*2;
            graphic2D.drawString(text,x,y);
            score=(gamePanel.player.life*100+gamePanel.player.hasRegularReward*200+gamePanel.player.hasSpecialReward*500
            +gamePanel.player.zombieDefeated*700);
        }
        text="score: "+score;
        x=getXForCenterText(text);
        y+=gamePanel.tileSize*2;
        graphic2D.drawString(text,x,y);

        y+=gamePanel.tileSize;
        graphic2D.drawImage(image1,gamePanel.tileSize*8,y,gamePanel.tileSize*4,(gamePanel.tileSize*3),null);
    }

    /**
     * Useful function to get the x coordinate to center a text string
     * @param text the string we want to center
     * @return the x coordinate required to center it
     */
    public int getXForCenterText(String text) {
        int length = (int) graphic2D.getFontMetrics().getStringBounds(text, graphic2D).getWidth();
        return gamePanel.screenWidth / 2 - length / 2;

    }


}
