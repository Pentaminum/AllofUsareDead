import com.CMPT276_Group1.project.*;
import com.CMPT276_Group1.project.entity.*;
import org.junit.jupiter.api.*;

import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private KeyHandler KH;
    private GamePanel GP;
    private Player player;
    @BeforeEach
    public void setUp(){
        GP=new GamePanel();
        KH=new KeyHandler(GP);
        player=new Player(GP,KH);
        GP.setupGameObject();
    }

    @Test
    public void getPlayerImageTest(){
        BufferedImage up1 = player.setImage("main_character_up_1");
        BufferedImage image;
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/player/main_character_up_1.png"));
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
    public void pickUpObjectTest(){
        for(int i=0;i<GP.obj.length;i++){
            if(GP.obj[i]!=null){
                player.pickUpObject(i);
            }
        }
        assertEquals(3,player.hasRegularReward,"asserts that player have the right amount of regular reward");
        assertEquals(2,player.hasSpecialReward,"asserts that player have the right amount of special reward");
        assertEquals(3,GP.gameState,"asserts that player reached the exit and finish the game");
    }

    @Test
    public void contactZombieTest(){
        player.contactZombie(0);
        assertEquals(5,player.life,"asserts that player take damage when contact zombie");
        assertTrue(player.invincible,"asserts that player becomes invincible after contact zombie");
        player.pickUpObject(3);
        player.contactZombie(0);
        assertNull(GP.zombies[0],"asserts that zombie become null if player contact zombie with special reward");
        assertEquals(5,player.life,"asserts that player life does not change if contact zombie with special reward");
        assertEquals(0,player.hasSpecialReward,"asserts that player loss special reward once contact zombie");
    }
}
