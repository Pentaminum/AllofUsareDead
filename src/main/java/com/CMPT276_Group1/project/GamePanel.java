package com.CMPT276_Group1.project;

import com.CMPT276_Group1.project.entity.*;
import com.CMPT276_Group1.project.object.*;
import com.CMPT276_Group1.project.tile.*;

import javax.swing.*;
import java.awt.*;

/**
 * The main interface for creating the game. Holds important variables and objects for running the game
 */
public class GamePanel extends JPanel implements Runnable {
    //Screen setting
    final int originalTitleSize = 16;//16 x 16 tile
    final int scale = 3;

    //world setting
    //non-static
    public final int tileSize = originalTitleSize * scale;//48 x 48 tile
    public final int maxScreenCol = 20;
    public final int maxScreenRow = 16;
    public final int screenWidth = tileSize * maxScreenCol;//960
    public final int screenHeight = tileSize * maxScreenRow;//768

    //FPS
    int FPS = 60;

    //System
    TileManager tileManager = new TileManager(this);
    KeyHandler keyHandler = new KeyHandler(this);
    Sound music = new Sound();
    Sound soundEffect = new Sound();
    public CollisionChecker collisionChecker = new CollisionChecker(this);
    public AssetSetter assetSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    Thread gameThread;

    //Entity and object
    public Player player = new Player(this, keyHandler);
    public ObjectSuper[] obj = new ObjectSuper[10];
    public Trap[] traps= new Trap[5];
    //number of zombies we can display at the same time
    public Zombie[] zombies =new Zombie[10];

    //Game state
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int finishState = 3;

    /**
     * Constructor for the game panel that actually creates the window and sets up a key press handler
     */
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    /**
     * Setting the objects onto the board and starting the game with music on the title screen
     */
    public void setupGameObject() {
        assetSetter.setObject();
        assetSetter.setTrap();
        assetSetter.setZombie();
        playMusic(6);
        gameState = titleState;
    }

    /**
     * Creates and starts the game thread
     */
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * Run the game. Creates the frame timing to only update and draw the game once per frame at 60 FPS
     */
    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while (gameThread != null) {
            //1.update information
            update();
            //2.display updated information on screen
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;
                if (remainingTime < 0) {
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Update the player and zombies with their movement
     */
    public void update() {
        if (gameState == playState) {
            player.update();
            // zombie npc
            for (Zombie zombie : zombies) {
                if (zombie != null) {
                    zombie.update();
                }
            }
        }
    }

    /**
     * Paint all components onto the screen. Goes through all objects, player, traps, zombies, and tiles
     * and draws them onto the screen.
     * @param g the graphics object we will use to draw onto the screen
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        if (gameState != titleState && gameState != finishState) {
            //Tile
            tileManager.draw(g2D);

            //Object
            for (ObjectSuper objectSuper : obj) {
                if (objectSuper != null) {
                    objectSuper.draw(g2D, this);
                }
            }

            //Trap
            for (Trap trap : traps) {
                if(trap != null){
                    trap.draw(g2D, this);
                }
            }


            //player
            player.draw(g2D);

            //Zombie
            for (Zombie zombie : zombies) {
                if (zombie != null) {
                    //zombie.draw(g2D, this);
                    zombie.draw(g2D);
                }
            }

            //UI
        }
        ui.draw(g2D);
        g2D.dispose();
    }

    /**
     * Play the music
     * @param i allows selection of the music to be played
     */
    public void playMusic(int i) {
        music.setFile(i);
        music.play();
        music.loop();
    }

    /**
     * Stop playing the current music
     */
    public void stopMusic() {
        music.stop();
    }

    /**
     * Play a certain sound effect
     * @param i allows selection of the soundEffect to be played
     */
    public void playSoundEffect(int i) {
        soundEffect.setFile(i);
        soundEffect.play();
    }
}
