import com.CMPT276_Group1.project.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class CollisionCheckerTest {
    private CollisionChecker CC;
    private GamePanel GP;
    @BeforeEach
    public void setUp(){
        GP=new GamePanel();
        CC=new CollisionChecker(GP);
        GP.setupGameObject();
    }

    @Test
    public void checkTileTest(){
        GP.player.x=GP.tileSize-GP.player.solidArea.x-1;
        GP.player.y=GP.tileSize;
        GP.player.direction="left";
        GP.player.update();
        CC.checkTile(GP.player);
        assertTrue(GP.player.collisionOn,"asserts that tile collision is working with player");
        GP.zombies[0].x= GP.tileSize-GP.zombies[0].solidArea.x-1;
        GP.zombies[0].y= GP.tileSize;
        GP.zombies[0].update();
        CC.checkTile(GP.zombies[0]);
        assertTrue(GP.zombies[0].collisionOn,"asserts that tile collision is working with zombie");
        GP.player.x=GP.tileSize+(GP.tileSize-GP.player.solidArea.width)+1;
        GP.player.direction="right";
        CC.checkTile(GP.player);
        assertTrue(GP.player.collisionOn,"asserts that tile collision is working with player");
        GP.zombies[0].x=GP.tileSize+(GP.tileSize-GP.zombies[0].solidArea.width)+1;
        CC.checkTile(GP.zombies[0]);
        assertTrue(GP.zombies[0].collisionOn,"asserts that tile collision is working with zombie");
        GP.player.y=GP.tileSize+(GP.tileSize-GP.player.solidArea.height)+1;
        GP.player.direction="up";
        CC.checkTile(GP.player);
        assertTrue(GP.player.collisionOn,"asserts that tile collision is working with player");
        GP.zombies[0].y=GP.tileSize+(GP.tileSize-GP.zombies[0].solidArea.height)+1;
        CC.checkTile(GP.zombies[0]);
        assertTrue(GP.zombies[0].collisionOn,"asserts that tile collision is working with zombie");
        GP.player.y=15*GP.tileSize-GP.player.solidArea.y-1;
        GP.player.direction="down";
        CC.checkTile(GP.player);
        assertTrue(GP.player.collisionOn,"asserts that tile collision is working with player");
        GP.zombies[0].y=15*GP.tileSize-GP.zombies[0].solidArea.y-1;
        CC.checkTile(GP.zombies[0]);
        assertTrue(GP.zombies[0].collisionOn,"asserts that tile collision is working with zombie");
    }

    @Test
    public void checkObjectTest(){
        GP.zombies[0].x=5*GP.tileSize;
        GP.zombies[0].y=7*GP.tileSize;
        CC.checkObject(GP.zombies[0],false);
        assertFalse(GP.zombies[0].collisionOn,"asserts that zombie does not interact with object");
        GP.player.x=19*GP.tileSize;
        GP.player.y=14*GP.tileSize;
        int i=CC.checkObject(GP.player,true);
        assertTrue(GP.player.collisionOn,"asserts that player interact with object once hit");
        assertEquals(5,i,"assert that check object is returning the correct index");
    }

    @Test
    public void checkZombieTest(){
        GP.zombies[0].x=GP.tileSize;
        GP.zombies[0].y=GP.tileSize;
        GP.zombies[1].x=GP.tileSize;
        GP.zombies[1].y=GP.tileSize;
        CC.checkZombie(GP.zombies[0],GP.zombies);
        assertTrue(GP.zombies[0].collisionOn,"asserts that zombie detect othe" +
                "r zombie and have collision");
    }
}
