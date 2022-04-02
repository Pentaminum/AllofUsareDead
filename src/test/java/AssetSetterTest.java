import com.CMPT276_Group1.project.*;
import org.junit.jupiter.api.*;

import java.awt.event.*;

import static org.junit.jupiter.api.Assertions.*;

public class AssetSetterTest {
    private AssetSetter AS;
    private GamePanel GP;

    @BeforeEach
    void setUp() {
        GP = new GamePanel();
        AS = new AssetSetter(GP);
    }

    @Test
    public void constructorTest(){
        AssetSetter TestAS = new AssetSetter(GP);
        assertNotNull(TestAS, "Check that the object is constructed correctly");
    }

    @Test
    public void setObjectTest(){
        AS.setObject();

    }

    @Test
    public void setTrapTest(){
        AS.setTrap();
    }

    @Test
    public void setZombieTest(){
        AS.setZombie();
    }
}
