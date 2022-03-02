package main.java;

import main.java.entity.*;
import main.java.object.*;
import main.java.tile.*;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    //Screen setting
    final int originalTitleSize = 16;//16 x 16 tile
    final int scale = 3;

    //world setting
    public final int tileSize = originalTitleSize * scale;//48 x 48 tile
    public final int maxScreenCol = 20;
    public final int maxScreenRow = 16;
    public final int screenWidth = tileSize * maxScreenCol;//960
    public final int screenHeight = tileSize * maxScreenRow;//768

    //FPS
    int FPS = 60;

    //System
    TileManager tileManager=new TileManager(this);
    KeyHandler keyHandler = new KeyHandler();
    Sound music =new Sound();
    Sound soundEffect=new Sound();
    public CollisionChecker collisionChecker=new CollisionChecker(this);
    public AssetSetter assetSetter=new AssetSetter(this);
    public UI ui=new UI(this);
    Thread gameThread;

    //Entity and object
    Player player=new Player(this,keyHandler);
    public Location[] obj =new Location[10];



    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void setupGameObject(){
        assetSetter.setObject();
        playMusic(0);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

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

    public void update() {
        player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        //Tile
        tileManager.draw(g2D);

        //Object
        for (Location location : obj) {
            if (location != null) {
                location.draw(g2D, this);
            }
        }

        //player
        player.draw(g2D);

        //UI
        ui.draw(g2D);

        g2D.dispose();
    }

    public void playMusic(int i){
        music.setFile(i);
        music.play();
        music.loop();
    }

    public void stopMusic(){
        music.stop();
    }

    public void playSoundEffect(int i){
        soundEffect.setFile(i);
        soundEffect.play();
    }
}
