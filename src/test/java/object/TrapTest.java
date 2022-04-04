package object;

import com.CMPT276_Group1.project.GamePanel;
import com.CMPT276_Group1.project.object.SpecialReward;
import com.CMPT276_Group1.project.object.Trap;
import org.junit.jupiter.api.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TrapTest {
    private GamePanel GP;
    private Trap s;
    @BeforeEach
    public void setUp(){
        GP=new GamePanel();
        GP.setupGameObject();
        s= GP.traps[0];
    }
    @Test
    public void testImage() {
        BufferedImage test;
        try {
            test = ImageIO.read(getClass().getResourceAsStream("/objects/trap.png"));
            assertEquals("Trap",s.name,"asserts that trap constructor sets the name properly");
            assertNotNull(test,"asserts that the image file is not null");
            assertEquals(test.getHeight(),s.image.getHeight(),"asserts that the image file height is correct");
            assertEquals(test.getWidth(),s.image.getWidth(),"asserts that the image file width is correct");
            assertEquals(test.getType(),s.image.getType(),"asserts that the image file type is correct");
            assertEquals(5, GP.traps.length, "asserts that the number of traps is correct");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testHit() {
        for(int i=0;i<5;i++)
        {
            if(i == 0) {
                GP.player.x = 6 * GP.tileSize;
                GP.player.y = 7 * GP.tileSize;
            }
            else if(i==1) {
                GP.player.x = 11 * GP.tileSize;
                GP.player.y = 12 * GP.tileSize;
            }
            else if(i==2) {
                GP.player.x = 13 * GP.tileSize;
                GP.player.y = 5 * GP.tileSize;
            }
            else if(i==3) {
                GP.player.x = 4 * GP.tileSize;
                GP.player.y = 9 * GP.tileSize;
            }
            else if(i==4) {
                GP.player.x = 17 * GP.tileSize;
                GP.player.y = 12 * GP.tileSize;
            }
            GP.player.direction = "left";
            assertTrue(GP.traps[i].hit(GP.traps[i].x/GP.tileSize,GP.traps[i].y/GP.tileSize,"left"),"asserts that player is hitting the trap from left");
            GP.player.direction = "right";
            assertTrue(GP.traps[i].hit(GP.traps[i].x/GP.tileSize,GP.traps[i].y/GP.tileSize,"right"),"asserts that player is hitting the trap from right");
            GP.player.direction = "up";
            assertTrue(GP.traps[i].hit(GP.traps[i].x/GP.tileSize,GP.traps[i].y/GP.tileSize,"up"),"asserts that player is hitting the trap from up");
            GP.player.direction = "down";
            assertTrue(GP.traps[i].hit(GP.traps[i].x/GP.tileSize,GP.traps[i].y/GP.tileSize,"down"),"asserts that player is hitting the trap from down");
        }
    }

    @Test
    public void TestDamage() {
        for(int i=0;i<5;i++)
        {
            if(i == 0) {
                GP.player.x = 6 * GP.tileSize;
                GP.player.y = 7 * GP.tileSize;
            }
            else if(i==1) {
                GP.player.x = 11 * GP.tileSize;
                GP.player.y = 12 * GP.tileSize;
            }
            else if(i==2) {
                GP.player.x = 13 * GP.tileSize;
                GP.player.y = 5 * GP.tileSize;
            }
            else if(i==3) {
                GP.player.x = 4 * GP.tileSize;
                GP.player.y = 9 * GP.tileSize;
            }
            else if(i==4) {
                GP.player.x = 17 * GP.tileSize;
                GP.player.y = 12 * GP.tileSize;
            }
            int before = GP.player.life;
            GP.traps[i].checkEvent(i);
            int after = GP.player.life;
            assertEquals(before - 1, after, "asserts that trap hitting decreases one health");
        }
    }
}

