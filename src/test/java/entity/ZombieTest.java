package entity;

import com.CMPT276_Group1.project.*;
import com.CMPT276_Group1.project.entity.*;
import org.junit.jupiter.api.*;

import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

import static org.junit.jupiter.api.Assertions.*;

public class ZombieTest extends JPanel {
    private GamePanel GP;
    private Zombie zombie;
    @BeforeEach
    public void setUp(){
        GP=new GamePanel();
        GP.setupGameObject();
        zombie=GP.zombies[0];
    }

    @Test
    public void getZombieImageTest(){
        zombie.getImage();
        BufferedImage image;
        try{

            image = ImageIO.read(getClass().getResourceAsStream("/zombie/zombie_up_1.png"));
            image = new BufferedImage(GP.tileSize,GP.tileSize,image.getType());
            Graphics2D graphics2D=image.createGraphics();
            graphics2D.drawImage(image,0,0,GP.tileSize,GP.tileSize,null);
            graphics2D.dispose();
            assertNotNull(zombie.up1,"asserts that the image file is not null");
            assertEquals(zombie.up1.getHeight(),image.getHeight(),"asserts that the image file height is correct");
            assertEquals(zombie.up1.getWidth(),image.getWidth(),"asserts that the image file width is correct");
            assertEquals(zombie.up1.getType(),image.getType(),"asserts that the image file type is correct");

            image = ImageIO.read(getClass().getResourceAsStream("/zombie/zombie_up_2.png"));
            image = new BufferedImage(GP.tileSize,GP.tileSize,image.getType());
            graphics2D=image.createGraphics();
            graphics2D.drawImage(image,0,0,GP.tileSize,GP.tileSize,null);
            graphics2D.dispose();
            assertNotNull( zombie.up2,"asserts that the image file is not null");
            assertEquals(zombie.up2.getHeight(),image.getHeight(),"asserts that the image file height is correct");
            assertEquals(zombie.up2.getWidth(),image.getWidth(),"asserts that the image file width is correct");
            assertEquals(zombie.up2.getType(),image.getType(),"asserts that the image file type is correct");

            image = ImageIO.read(getClass().getResourceAsStream("/zombie/zombie_down_1.png"));
            image = new BufferedImage(GP.tileSize,GP.tileSize,image.getType());
            graphics2D=image.createGraphics();
            graphics2D.drawImage(image,0,0,GP.tileSize,GP.tileSize,null);
            graphics2D.dispose();
            assertNotNull( zombie.down1,"asserts that the image file is not null");
            assertEquals(zombie.down1.getHeight(),image.getHeight(),"asserts that the image file height is correct");
            assertEquals(zombie.down1.getWidth(),image.getWidth(),"asserts that the image file width is correct");
            assertEquals(zombie.down1.getType(),image.getType(),"asserts that the image file type is correct");

            image = ImageIO.read(getClass().getResourceAsStream("/zombie/zombie_down_2.png"));
            image = new BufferedImage(GP.tileSize,GP.tileSize,image.getType());
            graphics2D=image.createGraphics();
            graphics2D.drawImage(image,0,0,GP.tileSize,GP.tileSize,null);
            graphics2D.dispose();
            assertNotNull( zombie.down2,"asserts that the image file is not null");
            assertEquals(zombie.down2.getHeight(),image.getHeight(),"asserts that the image file height is correct");
            assertEquals(zombie.down2.getWidth(),image.getWidth(),"asserts that the image file width is correct");
            assertEquals(zombie.down2.getType(),image.getType(),"asserts that the image file type is correct");

            image = ImageIO.read(getClass().getResourceAsStream("/zombie/zombie_left_1.png"));
            image = new BufferedImage(GP.tileSize,GP.tileSize,image.getType());
            graphics2D=image.createGraphics();
            graphics2D.drawImage(image,0,0,GP.tileSize,GP.tileSize,null);
            graphics2D.dispose();
            assertNotNull( zombie.left1,"asserts that the image file is not null");
            assertEquals(zombie.left1.getHeight(),image.getHeight(),"asserts that the image file height is correct");
            assertEquals(zombie.left1.getWidth(),image.getWidth(),"asserts that the image file width is correct");
            assertEquals(zombie.left1.getType(),image.getType(),"asserts that the image file type is correct");

            image = ImageIO.read(getClass().getResourceAsStream("/zombie/zombie_left_2.png"));
            image = new BufferedImage(GP.tileSize,GP.tileSize,image.getType());
            graphics2D=image.createGraphics();
            graphics2D.drawImage(image,0,0,GP.tileSize,GP.tileSize,null);
            graphics2D.dispose();
            assertNotNull( zombie.left2,"asserts that the image file is not null");
            assertEquals(zombie.left2.getHeight(),image.getHeight(),"asserts that the image file height is correct");
            assertEquals(zombie.left2.getWidth(),image.getWidth(),"asserts that the image file width is correct");
            assertEquals(zombie.left2.getType(),image.getType(),"asserts that the image file type is correct");

            image = ImageIO.read(getClass().getResourceAsStream("/zombie/zombie_right_1.png"));
            image = new BufferedImage(GP.tileSize,GP.tileSize,image.getType());
            graphics2D=image.createGraphics();
            graphics2D.drawImage(image,0,0,GP.tileSize,GP.tileSize,null);
            graphics2D.dispose();
            assertNotNull( zombie.right1,"asserts that the image file is not null");
            assertEquals(zombie.right1.getHeight(),image.getHeight(),"asserts that the image file height is correct");
            assertEquals(zombie.right1.getWidth(),image.getWidth(),"asserts that the image file width is correct");
            assertEquals(zombie.right1.getType(),image.getType(),"asserts that the image file type is correct");

            image = ImageIO.read(getClass().getResourceAsStream("/zombie/zombie_right_2.png"));
            image = new BufferedImage(GP.tileSize,GP.tileSize,image.getType());
            graphics2D=image.createGraphics();
            graphics2D.drawImage(image,0,0,GP.tileSize,GP.tileSize,null);
            graphics2D.dispose();
            assertNotNull( zombie.right2,"asserts that the image file is not null");
            assertEquals(zombie.right2.getHeight(),image.getHeight(),"asserts that the image file height is correct");
            assertEquals(zombie.right2.getWidth(),image.getWidth(),"asserts that the image file width is correct");
            assertEquals(zombie.right2.getType(),image.getType(),"asserts that the image file type is correct");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test
    public void contactPlayerTest(){
        zombie.contactPlayer(false,zombie);
        assertEquals(1,zombie.life,"asserts that zombie don't take damage from contacting other zombies");
        zombie.contactPlayer(true,zombie);
        assertTrue(GP.player.invincible,"asserts that player becomes invincible after contact zombie");
        assertEquals(5,GP.player.life,"asserts that player life does not change if contact zombie with special reward");
        GP.player.pickUpObject(3);
        zombie.contactPlayer(true,zombie);
        assertNull(GP.zombies[0],"asserts that zombie become null if player contact zombie with special reward");
        assertEquals(0,GP.player.hasSpecialReward,"asserts that player loss special reward once contact zombie");
    }

    @Test
    public void setActionTest(){
        GP.player.x=GP.tileSize;
        GP.player.y=GP.tileSize;
        zombie.x=GP.tileSize;
        zombie.y=4*GP.tileSize;
        zombie.spriteCounter=19;
        zombie.spriteNum=2;
        zombie.setAction();
        assertEquals("up",zombie.direction,"asserts that zombie going up toward player once distance<=3tile");
        assertEquals(3,zombie.speed,"asserts that zombie speeds up when player is in distance");
        assertEquals(1,zombie.spriteNum,"asserts that zombie sprite is changing");
        zombie.y=5*GP.tileSize;
        zombie.spriteCounter=19;
        zombie.spriteNum=2;
        zombie.setAction();
        assertEquals(2,zombie.speed,"asserts that zombie slows down when player is out of range");
        assertEquals(1,zombie.spriteNum,"asserts that zombie sprite is changing overtime");

        zombie.x=GP.tileSize;
        zombie.y=GP.tileSize;
        GP.player.x=GP.tileSize;
        GP.player.y=4*GP.tileSize;
        zombie.spriteCounter=19;
        zombie.setAction();
        assertEquals("down",zombie.direction,"asserts that zombie going down toward player once distance<=3tile");
        assertEquals(3,zombie.speed,"asserts that zombie speeds up when player is in distance");
        GP.player.y=5*GP.tileSize;
        zombie.spriteCounter=19;
        zombie.spriteNum=1;
        zombie.setAction();
        assertEquals(2,zombie.speed,"asserts that zombie slows down when player is out of range");
        assertEquals(2,zombie.spriteNum,"asserts that zombie sprite is changing");

        zombie.x=GP.tileSize;
        zombie.y=GP.tileSize;
        GP.player.x=4*GP.tileSize;
        GP.player.y=GP.tileSize;
        zombie.spriteCounter=19;
        zombie.setAction();
        assertEquals("right",zombie.direction,"asserts that zombie going down toward player once distance<=3tile");
        assertEquals(3,zombie.speed,"asserts that zombie speeds up when player is in distance");
        GP.player.x=5*GP.tileSize;
        zombie.spriteCounter=19;
        zombie.setAction();
        assertEquals(2,zombie.speed,"asserts that zombie slows down when player is out of range");

        GP.player.x=GP.tileSize;
        GP.player.y=GP.tileSize;
        zombie.x=4*GP.tileSize;
        zombie.y=GP.tileSize;
        zombie.spriteCounter=19;
        zombie.setAction();
        assertEquals("left",zombie.direction,"asserts that zombie going up toward player once distance<=3tile");
        assertEquals(3,zombie.speed,"asserts that zombie speeds up when player is in distance");
        zombie.x=5*GP.tileSize;
        zombie.spriteCounter=19;
        zombie.setAction();
        assertEquals(2,zombie.speed,"asserts that zombie slows down when player is out of range");
    }



}
