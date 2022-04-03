import org.junit.jupiter.api.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class RegularRewardTest {
    /*private GamePanel GP;
    private RegularReward r;
    @BeforeEach
    public void setUp(){
        GP=new GamePanel();
        GP.setupGameObject();
        r= (RegularReward) GP.obj[0];
    }*/
    @Test
    public void testImage() {
        /*File file = new File("regular_reward.png");
        assertNotNull(file,"asserts that the image file is not null");
        assertEquals("regular_reward.png",file.getName(),"asserts that the image file is correct");*/
        BufferedImage image;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/regular_reward.png"));
            BufferedImage test = ImageIO.read(new File("src/main/resources/objects/regular_reward.png"));
            assertNotNull(test,"asserts that the image file is not null");
            assertEquals(test.getHeight(),image.getHeight(),"asserts that the image file height is correct");
            assertEquals(test.getWidth(),image.getWidth(),"asserts that the image file width is correct");
            assertEquals(test.getType(),image.getType(),"asserts that the image file type is correct");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

