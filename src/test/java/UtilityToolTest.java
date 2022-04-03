import com.CMPT276_Group1.project.*;
import org.junit.jupiter.api.*;

import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class UtilityToolTest {
    private GamePanel GP;
    private UtilityTool UT;
    @BeforeEach
    public void setUp(){
        GP=new GamePanel();
        UT=new UtilityTool();
    }

    @Test
    public void scaleImageTest() {
        try {
            BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/player/main_character_up_1.png"));
            BufferedImage image1 = new BufferedImage(GP.tileSize, GP.tileSize, image.getType());
            BufferedImage image2= UT.scaleImage(image,GP.tileSize,GP.tileSize);
            boolean test=false;
            if(image1.getType()==image2.getType()&&image1.getHeight()==image2.getHeight()&&image1.getWidth()==image2.getWidth()){
                    test=true;
            }
            assertTrue(test,"asserts that scaled image is correct");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
