package main.java;

import main.java.object.*;

import java.awt.*;
import java.awt.image.*;

public class UI {
    GamePanel gamePanel;
    Font arial_40;
    BufferedImage studentImage;
    public boolean messageIb=false;
    public String message="";

    public UI(GamePanel gamePanel){
        this.gamePanel=gamePanel;
        arial_40=new Font("Arial",Font.PLAIN,40);
        RegularReward student=new RegularReward();
        studentImage= student.image;
    }

    public void draw(Graphics2D graphics2D){
        graphics2D.setFont(arial_40);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawImage(studentImage,0,0,gamePanel.tileSize,gamePanel.tileSize,null);
        graphics2D.drawString("x "+gamePanel.player.hasRegularReward,50,35);
    }
}
