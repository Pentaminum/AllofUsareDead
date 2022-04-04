package object;

import com.CMPT276_Group1.project.GamePanel;
import com.CMPT276_Group1.project.object.SpecialReward;
import org.junit.jupiter.api.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class SpecialRewardTest {
    private GamePanel GP;
    private SpecialReward s;
    @BeforeEach
    public void setUp(){
        GP=new GamePanel();
        GP.setupGameObject();
        s= (SpecialReward) GP.obj[3];
    }
    @Test
    public void testImage() {
        BufferedImage test;
        try {
            test = ImageIO.read(getClass().getResourceAsStream("/objects/special_reward.png"));
            assertEquals("Special Reward",s.name,"asserts that special reward constructor sets the name properly");
            assertNotNull(test,"asserts that the image file is not null");
            assertEquals(test.getHeight(),s.image.getHeight(),"asserts that the image file height is correct");
            assertEquals(test.getWidth(),s.image.getWidth(),"asserts that the image file width is correct");
            assertEquals(test.getType(),s.image.getType(),"asserts that the image file type is correct");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

