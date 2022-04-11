package object;

import com.CMPT276_Group1.project.GamePanel;
import com.CMPT276_Group1.project.object.RegularReward;
import org.junit.jupiter.api.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class RegularReward3Test {
    private GamePanel GP;
    private RegularReward r;
    @BeforeEach
    public void setUp(){
        GP=new GamePanel();
        GP.setupGameObject();
        r= (RegularReward) GP.obj[2];
    }
    @Test
    public void testImage() {
        BufferedImage test;
        try {
            test = ImageIO.read(getClass().getResourceAsStream("/objects/regular_reward_3.png"));
            assertEquals("Regular Reward 3",r.name,"asserts that regular reward constructor set name properly");
            //BufferedImage test = ImageIO.read(new File("/objects/regular_reward.png"));
            assertNotNull(test,"asserts that the image file is not null");
            assertEquals(test.getHeight(),r.image.getHeight(),"asserts that the image file height is correct");
            assertEquals(test.getWidth(),r.image.getWidth(),"asserts that the image file width is correct");
            assertEquals(test.getType(),r.image.getType(),"asserts that the image file type is correct");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

