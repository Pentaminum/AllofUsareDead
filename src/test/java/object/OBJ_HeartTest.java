package object;

import com.CMPT276_Group1.project.GamePanel;
import com.CMPT276_Group1.project.object.OBJ_Heart;
import org.junit.jupiter.api.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class OBJ_HeartTest {
    private GamePanel GP;
    private OBJ_Heart r;
    @BeforeEach
    public void setUp(){
        GP=new GamePanel();
        GP.setupGameObject();
        r= new OBJ_Heart(GP);
    }
    @Test
    public void testImage() {
        BufferedImage test,test2,test3;
        try {
            test = ImageIO.read(getClass().getResourceAsStream("/objects/heart_full.png"));
            assertEquals("Heart",r.name,"asserts that heart constructor sets the name properly");
            assertNotNull(test,"asserts that the image file is not null");
            assertEquals(test.getHeight()*3,r.image.getHeight(),"asserts that the image file height is correct");
            assertEquals(test.getWidth()*3,r.image.getWidth(),"asserts that the image file width is correct");
            assertEquals(test.getType(),r.image.getType(),"asserts that the image file type is correct");
            test2 = ImageIO.read(getClass().getResourceAsStream("/objects/heart_half.png"));
            assertNotNull(test2,"asserts that the image file is not null");
            assertEquals(test2.getHeight()*3,r.image.getHeight(),"asserts that the image file height is correct");
            assertEquals(test2.getWidth()*3,r.image.getWidth(),"asserts that the image file width is correct");
            assertEquals(test2.getType(),r.image.getType(),"asserts that the image file type is correct");
            test3 = ImageIO.read(getClass().getResourceAsStream("/objects/heart_blank.png"));
            assertNotNull(test3,"asserts that the image file is not null");
            assertEquals(test3.getHeight()*3,r.image.getHeight(),"asserts that the image file height is correct");
            assertEquals(test3.getWidth()*3,r.image.getWidth(),"asserts that the image file width is correct");
            assertEquals(test3.getType(),r.image.getType(),"asserts that the image file type is correct");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


