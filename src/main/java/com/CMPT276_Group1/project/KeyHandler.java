package com.CMPT276_Group1.project;

import com.CMPT276_Group1.project.entity.*;

import java.awt.event.*;

/**
 * Our KeyHandler class to handle keyboard input
 */
public class KeyHandler implements KeyListener {
    public boolean upPressed,downPressed,leftPressed, rightPressed;
    static GamePanel gamePanel;
    //Debug
    static boolean checkDrawTime=false;

    /**
     * Constructor to set up a KeyHandler for the given game panel
     * @param gamePanel the current game instance
     */
    public KeyHandler(GamePanel gamePanel){
        KeyHandler.gamePanel =gamePanel;
    }

    /**
     * This is to override the standard KeyTyped method in KeyListener, as we want it to do nothing
     * @param e the key that was pressed
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Depending on what key is pressed and what state we are in, we do different things in the game.
     * @param e The key that was pressed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        keyPressedAction(code);
    }

    /**
     * Depending on what key is pressed and what state we are in, we do different things in the game.
     * @param code The integer code of the key that was pressed
     */
    public void keyPressedAction(int code){
        //Title state
        if(gamePanel.gameState==gamePanel.titleState){
            if(code==KeyEvent.VK_W){
                gamePanel.ui.commandNum--;
                if(gamePanel.ui.commandNum<0){
                    gamePanel.ui.commandNum=1;
                }
            }
            if(code==KeyEvent.VK_S){
                gamePanel.ui.commandNum++;
                if(gamePanel.ui.commandNum>1){
                    gamePanel.ui.commandNum=0;
                }
            }
            if(code==KeyEvent.VK_ENTER){
                if(gamePanel.ui.commandNum==0){
                    gamePanel.gameState= gamePanel.playState;
                    gamePanel.stopMusic();
                    gamePanel.playMusic(0);
                }
                if(gamePanel.ui.commandNum==1){
                    System.exit(0);
                }
            }
        }

        //Play state
        if(gamePanel.gameState== gamePanel.playState){
            if(code==KeyEvent.VK_W){
                upPressed=true;
            }
            if(code==KeyEvent.VK_S){
                downPressed=true;
            }
            if(code==KeyEvent.VK_A){
                leftPressed=true;
            }
            if(code==KeyEvent.VK_D){
                rightPressed=true;
            }
            if(code==KeyEvent.VK_P){
                gamePanel.gameState=gamePanel.pauseState;
            }
        }else if(gamePanel.gameState== gamePanel.pauseState){
            if(code==KeyEvent.VK_P){
                gamePanel.gameState=gamePanel.playState;
            }
        }

        //Finish state
        if(gamePanel.gameState==gamePanel.finishState){
            if(code==KeyEvent.VK_ENTER){
                gamePanel.setupGameObject();
                gamePanel.player=new Player(gamePanel, gamePanel.keyHandler);
            }
        }
    }

    /**
     * When the movement key is released we need to stop moving
     * @param e the key that was pressed
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        keyReleasedAction(code);
    }

    /**
     * When the movement key is released we need to stop moving
     * @param code the integer code of the key that was pressed
     */
    public void keyReleasedAction(int code) {
        if(code==KeyEvent.VK_W){
            upPressed=false;
        }
        if(code==KeyEvent.VK_S){
            downPressed=false;
        }
        if(code==KeyEvent.VK_A){
            leftPressed=false;
        }
        if(code==KeyEvent.VK_D){
            rightPressed=false;
        }
    }
}
