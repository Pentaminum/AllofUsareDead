import com.CMPT276_Group1.project.*;
import org.junit.jupiter.api.*;

import java.awt.event.*;

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
        KH.keyReleasedAction(KeyEvent.VK_W);
        assertFalse(KH.upPressed, "When the W key is released, upPressed should be false");
        KH.keyReleasedAction(KeyEvent.VK_A);
        assertFalse(KH.leftPressed, "When the A key is released, leftPressed should be false");
        KH.keyReleasedAction(KeyEvent.VK_S);
        assertFalse(KH.downPressed, "When the S key is released, downPressed should be false");
        KH.keyReleasedAction(KeyEvent.VK_D);
        assertFalse(KH.rightPressed, "When the D key is released, rightPressed should be false");
    }
    @Test
    public void keyTypedTest() {
        GP.gameState = GP.playState;
        KH.keyPressedAction(KeyEvent.VK_W);
        assertTrue(KH.upPressed, "When the W key is pressed, upPressed should be true");
        KH.keyPressedAction(KeyEvent.VK_A);
        assertTrue(KH.leftPressed, "When the A key is pressed, leftPressed should be true");
        KH.keyPressedAction(KeyEvent.VK_S);
        assertTrue(KH.downPressed, "When the S key is pressed, downPressed should be true");
        KH.keyPressedAction(KeyEvent.VK_D);
        assertTrue(KH.rightPressed, "When the D key is pressed, rightPressed should be true");
    }

}