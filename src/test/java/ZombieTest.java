import com.CMPT276_Group1.project.*;
import com.CMPT276_Group1.project.entity.*;
import org.junit.jupiter.api.*;

import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        BufferedImage up1 = zombie.setUp("zombie_up_1");
        BufferedImage image;
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/zombie/zombie_up_1.png"));
            image = new BufferedImage(GP.tileSize,GP.tileSize,image.getType());
            Graphics2D graphics2D=image.createGraphics();
            graphics2D.drawImage(image,0,0,GP.tileSize,GP.tileSize,null);
            graphics2D.dispose();
            assertNotNull( up1,"asserts that the image file is not null");
            assertEquals(up1.getHeight(),image.getHeight(),"asserts that the image file height is correct");
            assertEquals(up1.getWidth(),image.getWidth(),"asserts that the image file width is correct");
            assertEquals(up1.getType(),image.getType(),"asserts that the image file type is correct");
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
        zombie.setAction();
        assertEquals("down",zombie.direction,"asserts that zombie going up toward player once distance<=3tile");
        assertEquals(3,zombie.speed,"asserts that zombie speeds up when player is in distance");
        zombie.y=5*GP.tileSize;
        zombie.setAction();
        assertEquals(2,zombie.speed,"asserts that zombie slows down when player is out of range");
    }

    @Test
    public void updateTest(){
        zombie.update();
        assertFalse(zombie.collisionOn,"asserts that zombie is not colliding with anything when initialized");
        zombie.x=GP.tileSize-zombie.solidArea.x-1;
        zombie.y=2*GP.tileSize;
        zombie.update();
        assertTrue(zombie.collisionOn,"asserts that zombie will detect wall collision");
        zombie.x=8*GP.tileSize;
        zombie.y=8*GP.tileSize-(GP.tileSize-zombie.solidArea.height)-zombie.solidArea.x-1;
        zombie.update();
        assertTrue(zombie.collisionOn,"asserts that zombie will detect other zombie once collide");
        zombie.x=GP.tileSize;
        zombie.y=2*GP.tileSize-(GP.tileSize-zombie.solidArea.height)-GP.player.solidArea.x-1;
        zombie.update();
        assertTrue(zombie.collisionOn,"asserts that zombie will detect player once collide");
    }

}
