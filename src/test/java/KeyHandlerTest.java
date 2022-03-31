import com.CMPT276_Group1.project.*;
import org.junit.jupiter.api.*;

import java.awt.event.*;

import static com.CMPT276_Group1.project.KeyHandler.keyReleasedAction;
import static com.CMPT276_Group1.project.KeyHandler.keyPressedAction;
import static org.junit.jupiter.api.Assertions.*;

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
        System.out.println("Testing if JUnit is working");
        keyReleasedAction(KeyEvent.VK_W);
        assertFalse(KeyHandler.upPressed, "When the W key is released, upPressed should be false");
        keyReleasedAction(KeyEvent.VK_A);
        assertFalse(KeyHandler.leftPressed, "When the A key is released, leftPressed should be false");
        keyReleasedAction(KeyEvent.VK_S);
        assertFalse(KeyHandler.downPressed, "When the S key is released, downPressed should be false");
        keyReleasedAction(KeyEvent.VK_D);
        assertFalse(KeyHandler.rightPressed, "When the D key is released, rightPressed should be false");
    }
    @Test
    public void keyTypedTest() {
        GP.gameState = GP.playState;
        keyPressedAction(KeyEvent.VK_W);
        assertTrue(KeyHandler.upPressed, "When the W key is pressed, upPressed should be true");
        keyPressedAction(KeyEvent.VK_A);
        assertTrue(KeyHandler.leftPressed, "When the A key is pressed, leftPressed should be true");
        keyPressedAction(KeyEvent.VK_S);
        assertTrue(KeyHandler.downPressed, "When the S key is pressed, downPressed should be true");
        keyPressedAction(KeyEvent.VK_D);
        assertTrue(KeyHandler.rightPressed, "When the D key is pressed, rightPressed should be true");
    }

}