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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testHit() {
        assertEquals(5, GP.traps.length, "asserts that the number of traps is correct");
        for(int i=0;i<1;i++)
        {
            if(i == 0) {
                GP.player.x = 6 * GP.tileSize;
                GP.player.y = 7 * GP.tileSize;
                GP.player.direction = "left";
                GP.traps[i].checkEvent(i);
                //GP.traps[i].hit(6/GP.tileSize,7/GP.tileSize
                assertEquals(5, GP.player.life, "asserts that trap hit was spotted in the first trap");
            }
            /*
            if(i == 0)
            {
                assertTrue(GP.traps[i].hit(6/GP.tileSize,7/GP.tileSize, "ed"), "asserts that trap hit was spotted in the first trap");
            }
            else if(i == 1){
                assertTrue(GP.traps[i].hit(11/GP.tileSize,12/GP.tileSize, "asserts that trap hit was spotted");
            }
            else if(i == 2){
                assertTrue(GP.traps[i].hit(13/GP.tileSize,5/GP.tileSize, "asserts that trap hit was spotted");
            }
            else if(i == 3){
                assertTrue(GP.traps[i].hit(4/GP.tileSize,9/GP.tileSize, "asserts that trap hit was spotted");
            }
            else if(i == 4){
                assertTrue(GP.traps[i].hit(17/GP.tileSize,12/GP.tileSize, "asserts that trap hit was spotted");
            }
             */
        }
    }

    @Test
    public void testDamage() {

    }

}

