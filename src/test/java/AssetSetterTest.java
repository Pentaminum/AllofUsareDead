import com.CMPT276_Group1.project.*;
import org.junit.jupiter.api.*;

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
        assertNotNull(TestAS, "Check that the object is constructed");
    }

    @Test
    public void setObjectTest(){
        AS.setObject();
        assertNotNull(GP.obj[0], "Check that object 0 was set");
        assertEquals(GP.obj[0].x,GP.tileSize, "Check that object 0 is in the correct x position");
        assertEquals(GP.obj[0].y,14*GP.tileSize, "Check that object 0 is in the correct y position");
        assertNotNull(GP.obj[1], "Check that object 1 was set");
        assertEquals(GP.obj[1].x,10*GP.tileSize, "Check that object 1 is in the correct x position");
        assertEquals(GP.obj[1].y,2*GP.tileSize, "Check that object 1 is in the correct y position");
        assertNotNull(GP.obj[2], "Check that object 2 was set");
        assertEquals(GP.obj[2].x,5*GP.tileSize, "Check that object 2 is in the correct x position");
        assertEquals(GP.obj[2].y,7*GP.tileSize, "Check that object 2 is in the correct y position");
        assertNotNull(GP.obj[3], "Check that object 3 was set");
        assertEquals(GP.obj[3].x,13*GP.tileSize, "Check that object 3 is in the correct x position");
        assertEquals(GP.obj[3].y,3*GP.tileSize, "Check that object 3 is in the correct y position");
        assertNotNull(GP.obj[4], "Check that object 4 was set");
        assertEquals(GP.obj[4].x,8*GP.tileSize, "Check that object 4 is in the correct x position");
        assertEquals(GP.obj[4].y,GP.tileSize, "Check that object 4 is in the correct y position");
        assertNotNull(GP.obj[5], "Check that object 5 was set");
        assertEquals(GP.obj[5].x,19*GP.tileSize, "Check that object 5 is in the correct x position");
        assertEquals(GP.obj[5].y,14*GP.tileSize, "Check that object 5 is in the correct y position");
    }

    @Test
    public void setTrapTest(){
        AS.setTrap();
        assertNotNull(GP.traps[0], "Check that trap 0 was set");
        assertEquals(GP.traps[0].x,6*GP.tileSize, "Check that trap 0 is in the correct x position");
        assertEquals(GP.traps[0].y,7*GP.tileSize, "Check that trap 0 is in the correct y position");
        assertNotNull(GP.traps[1], "Check that trap 1 was set");
        assertEquals(GP.traps[1].x,11*GP.tileSize, "Check that trap 1 is in the correct x position");
        assertEquals(GP.traps[1].y,12*GP.tileSize, "Check that trap 1 is in the correct y position");
        assertNotNull(GP.traps[2], "Check that trap 2 was set");
        assertEquals(GP.traps[2].x,13*GP.tileSize, "Check that trap 2 is in the correct x position");
        assertEquals(GP.traps[2].y,5*GP.tileSize, "Check that trap 2 is in the correct y position");
        assertNotNull(GP.traps[3], "Check that trap 3 was set");
        assertEquals(GP.traps[3].x,4*GP.tileSize, "Check that trap 3 is in the correct x position");
        assertEquals(GP.traps[3].y,9*GP.tileSize, "Check that trap 3 is in the correct y position");
        assertNotNull(GP.traps[4], "Check that trap 4 was set");
        assertEquals(GP.traps[4].x,17*GP.tileSize, "Check that trap 4 is in the correct x position");
        assertEquals(GP.traps[4].y,12*GP.tileSize, "Check that trap 4 is in the correct y position");
    }

    @Test
    public void setZombieTest(){
        AS.setZombie();
        assertNotNull(GP.zombies[0], "Check that zombie 0 was set");
        assertEquals(GP.zombies[0].x,14*GP.tileSize, "Check that zombie 0 is in the correct x position");
        assertEquals(GP.zombies[0].y,3*GP.tileSize, "Check that zombie 0 is in the correct y position");
        assertNotNull(GP.zombies[1], "Check that zombie 1 was set");
        assertEquals(GP.zombies[1].x,8*GP.tileSize, "Check that zombie 1 is in the correct x position");
        assertEquals(GP.zombies[1].y,7*GP.tileSize, "Check that zombie 1 is in the correct y position");
        assertNotNull(GP.zombies[2], "Check that zombie 2 was set");
        assertEquals(GP.zombies[2].x,17*GP.tileSize, "Check that zombie 0 is in the correct x position");
        assertEquals(GP.zombies[2].y,12*GP.tileSize, "Check that zombie 0 is in the correct y position");
    }
}
