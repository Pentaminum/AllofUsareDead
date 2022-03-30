import org.junit.Test;
import com.CMPT276_Group1.project.entity.*;
import java.awt.event.*;
public class KeyHandlerTest {

    private KeyHandler KH;
    private GamePanel GP;
    @BeforeEach
    void setUp() {
        GP = new GamePanel();
        KH = new KeyHandler(GP);
    }

    @Test
    public void keyReleasedTest() {
        keyReleasedAction(KeyEvent.VK_W);
        assertEquals(KH.upPressed, false,  "When the W key is released, upPressed should be false");
        keyReleasedAction(KeyEvent.VK_A);
        assertEquals(KH.leftPressed, false,  "When the A key is released, leftPressed should be false");
        keyReleasedAction(KeyEvent.VK_S);
        assertEquals(KH.downPressed, false,  "When the S key is released, downPressed should be false");
        keyReleasedAction(KeyEvent.VK_D);
        assertEquals(KH.rightPressed, false,  "When the D key is released, rightPressed should be false");
    }
    @Test
    public void keyTypedTest() {

    }

}