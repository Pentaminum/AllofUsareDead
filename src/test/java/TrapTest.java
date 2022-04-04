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


}

