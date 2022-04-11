package entity;

import com.CMPT276_Group1.project.*;
import com.CMPT276_Group1.project.entity.*;
import org.junit.jupiter.api.*;

import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private KeyHandler KH;
    private GamePanel GP;
    private Player player;
    private UtilityTool tool;
    @BeforeEach
    public void setUp(){
        GP=new GamePanel();
        KH=new KeyHandler(GP);
        player=new Player(GP,KH);
        tool=new UtilityTool();
        GP.setupGameObject();
    }

    @Test
    public void getPlayerImageTest(){
        BufferedImage down1 = tool.setUp("main_character_down_1",GP,player);
        BufferedImage down2 = tool.setUp("main_character_down_2",GP,player);
        BufferedImage left1 = tool.setUp("main_character_left_1",GP,player);
        BufferedImage left2 = tool.setUp("main_character_left_2",GP,player);
        BufferedImage right1 = tool.setUp("main_character_right_1",GP,player);
        BufferedImage right2 = tool.setUp("main_character_right_2",GP,player);
        BufferedImage up1 = tool.setUp("main_character_up_1",GP,player);
        BufferedImage up2 = tool.setUp("main_character_up_2",GP,player);
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

            image = ImageIO.read(getClass().getResourceAsStream("/player/main_character_up_2.png"));
            image = new BufferedImage(GP.tileSize,GP.tileSize,image.getType());
            graphics2D=image.createGraphics();
            graphics2D.drawImage(image,0,0,GP.tileSize,GP.tileSize,null);
            graphics2D.dispose();
            assertNotNull( up2,"asserts that the image file is not null");
            assertEquals(up2.getHeight(),image.getHeight(),"asserts that the image file height is correct");
            assertEquals(up2.getWidth(),image.getWidth(),"asserts that the image file width is correct");
            assertEquals(up2.getType(),image.getType(),"asserts that the image file type is correct");

            image = ImageIO.read(getClass().getResourceAsStream("/player/main_character_down_1.png"));
            image = new BufferedImage(GP.tileSize,GP.tileSize,image.getType());
            graphics2D=image.createGraphics();
            graphics2D.drawImage(image,0,0,GP.tileSize,GP.tileSize,null);
            graphics2D.dispose();
            assertNotNull( down1,"asserts that the image file is not null");
            assertEquals(down1.getHeight(),image.getHeight(),"asserts that the image file height is correct");
            assertEquals(down1.getWidth(),image.getWidth(),"asserts that the image file width is correct");
            assertEquals(down1.getType(),image.getType(),"asserts that the image file type is correct");

            image = ImageIO.read(getClass().getResourceAsStream("/player/main_character_down_2.png"));
            image = new BufferedImage(GP.tileSize,GP.tileSize,image.getType());
            graphics2D=image.createGraphics();
            graphics2D.drawImage(image,0,0,GP.tileSize,GP.tileSize,null);
            graphics2D.dispose();
            assertNotNull( down2,"asserts that the image file is not null");
            assertEquals(down2.getHeight(),image.getHeight(),"asserts that the image file height is correct");
            assertEquals(down2.getWidth(),image.getWidth(),"asserts that the image file width is correct");
            assertEquals(down2.getType(),image.getType(),"asserts that the image file type is correct");

            image = ImageIO.read(getClass().getResourceAsStream("/player/main_character_left_1.png"));
            image = new BufferedImage(GP.tileSize,GP.tileSize,image.getType());
            graphics2D=image.createGraphics();
            graphics2D.drawImage(image,0,0,GP.tileSize,GP.tileSize,null);
            graphics2D.dispose();
            assertNotNull( left1,"asserts that the image file is not null");
            assertEquals(left1.getHeight(),image.getHeight(),"asserts that the image file height is correct");
            assertEquals(left1.getWidth(),image.getWidth(),"asserts that the image file width is correct");
            assertEquals(left1.getType(),image.getType(),"asserts that the image file type is correct");

            image = ImageIO.read(getClass().getResourceAsStream("/player/main_character_left_2.png"));
            image = new BufferedImage(GP.tileSize,GP.tileSize,image.getType());
            graphics2D=image.createGraphics();
            graphics2D.drawImage(image,0,0,GP.tileSize,GP.tileSize,null);
            graphics2D.dispose();
            assertNotNull( left2,"asserts that the image file is not null");
            assertEquals(left2.getHeight(),image.getHeight(),"asserts that the image file height is correct");
            assertEquals(left2.getWidth(),image.getWidth(),"asserts that the image file width is correct");
            assertEquals(left2.getType(),image.getType(),"asserts that the image file type is correct");

            image = ImageIO.read(getClass().getResourceAsStream("/player/main_character_right_1.png"));
            image = new BufferedImage(GP.tileSize,GP.tileSize,image.getType());
            graphics2D=image.createGraphics();
            graphics2D.drawImage(image,0,0,GP.tileSize,GP.tileSize,null);
            graphics2D.dispose();
            assertNotNull( right1,"asserts that the image file is not null");
            assertEquals(right1.getHeight(),image.getHeight(),"asserts that the image file height is correct");
            assertEquals(right1.getWidth(),image.getWidth(),"asserts that the image file width is correct");
            assertEquals(right1.getType(),image.getType(),"asserts that the image file type is correct");

            image = ImageIO.read(getClass().getResourceAsStream("/player/main_character_right_2.png"));
            image = new BufferedImage(GP.tileSize,GP.tileSize,image.getType());
            graphics2D=image.createGraphics();
            graphics2D.drawImage(image,0,0,GP.tileSize,GP.tileSize,null);
            graphics2D.dispose();
            assertNotNull( right2,"asserts that the image file is not null");
            assertEquals(right2.getHeight(),image.getHeight(),"asserts that the image file height is correct");
            assertEquals(right2.getWidth(),image.getWidth(),"asserts that the image file width is correct");
            assertEquals(right2.getType(),image.getType(),"asserts that the image file type is correct");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void pickUpObjectTest(){
        for(int i=0;i<GP.obj.length;i++){
            if(GP.obj[i]!=null){
                player.pickUpObject(i);
            }else{
                final int a=i;
                assertThrows(NullPointerException.class,()->player.pickUpObject(a));
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
        player.invincible=false;
        player.pickUpObject(3);
        player.contactZombie(0);
        assertNull(GP.zombies[0],"asserts that zombie become null if player contact zombie with special reward");
        assertEquals(5,player.life,"asserts that player life does not change if contact zombie with special reward");
        assertEquals(0,player.hasSpecialReward,"asserts that player loss special reward once contact zombie");
        assertEquals(1, player.zombieDefeated,"asserts that player killed one zombie with special reward");
        assertFalse(player.invincible,"asserts that player does not turn invincible when killing zombie");
        player.contactZombie(1);
        player.invincible=false;
        player.contactZombie(1);
        player.invincible=false;
        player.contactZombie(1);
        player.invincible=false;
        player.contactZombie(1);
        player.invincible=false;
        player.contactZombie(1);
        player.invincible=false;
        assertFalse(player.invincible,"asserts that player does not turn invincible when life=0");
        assertEquals(0,player.life,"asserts that player take damage when contact zombie");
        player.contactZombie(1);
        assertEquals(GP.finishState,GP.gameState,"asserts that player go to finish state if life=0");
        assertEquals(0,player.life,"asserts that player will stop taking damage when life is 0");

    }

    @Test
    public void updateTest(){
        KH.downPressed=true;
        player.update();
        KH.downPressed=false;
        assertEquals(player.direction,"down","asserts that player is going the right direction");

        KH.upPressed=true;
        player.update();
        KH.upPressed=false;
        assertEquals("up",player.direction,"asserts player is going up");

        KH.leftPressed=true;
        player.update();
        KH.leftPressed=false;
        assertEquals("left",player.direction,"asserts that player is going left");

        KH.rightPressed=true;
        player.update();
        KH.rightPressed=false;
        assertEquals("right",player.direction,"asserts that player is going right");

        player.x=GP.tileSize;
        player.y=GP.tileSize;
        player.update();
        assertFalse(player.collisionOn,"asserts that player is not colliding with anything when initialized");
        player.x=GP.tileSize-player.solidArea.x-1;
        KH.leftPressed=true;
        player.update();
        KH.leftPressed=false;
        assertTrue(player.collisionOn,"asserts that player will detect wall collision");
        player.x=8*GP.tileSize;
        player.y=8*GP.tileSize-(GP.tileSize-player.solidArea.height)-player.solidArea.x-1;
        player.update();
        assertTrue(player.collisionOn,"asserts that player will detect zombie once collide");
        player.x=GP.tileSize;
        player.y=14*GP.tileSize;
        player.update();
        assertTrue(player.collisionOn,"asserts that player will detect object once collide");
        player.x=6*GP.tileSize+GP.traps[0].solidArea.x+GP.traps[0].solidArea.width-1;
        player.y=7*GP.tileSize;
        player.update();
        assertTrue(player.collisionOn,"asserts that player will detect trap once collide");
    }
}
