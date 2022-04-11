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
    public void constructorTest(){
        KeyHandler TestKH = new KeyHandler(GP);
        assertNotNull(TestKH, "Check that the object is constructed correctly");
    }

    @Test
    public void keyReleasedTest() {
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
    public void keyPressedPlayStateTest() {
        GP.gameState = GP.playState;
        KH.keyPressedAction(KeyEvent.VK_W);
        assertTrue(KH.upPressed, "When the W key is pressed, upPressed should be true");
        KH.keyPressedAction(KeyEvent.VK_A);
        assertTrue(KH.leftPressed, "When the A key is pressed, leftPressed should be true");
        KH.keyPressedAction(KeyEvent.VK_S);
        assertTrue(KH.downPressed, "When the S key is pressed, downPressed should be true");
        KH.keyPressedAction(KeyEvent.VK_D);
        assertTrue(KH.rightPressed, "When the D key is pressed, rightPressed should be true");
        KH.keyPressedAction(KeyEvent.VK_P);
        assertEquals(GP.gameState, GP.pauseState
                , "When the P key is pressed, game should pause");
        KH.keyPressedAction(KeyEvent.VK_P);
        assertEquals(GP.gameState, GP.playState
                , "When the P key is pressed, game should unpause");
    }

    @Test
    public void upDownTitleStateTest(){
        GP.gameState = GP.titleState;
        KH.keyPressedAction(KeyEvent.VK_W);
        assertEquals(GP.ui.commandNum, 1
                , "When the W key is pressed, we go up on the menu. Wrapping if at the top");
        KH.keyPressedAction(KeyEvent.VK_S);
        assertEquals(GP.ui.commandNum, 0
                , "When the A key is pressed, we go down on the menu wrapping if at the bottom");
        GP.ui.commandNum = 0;
    }

    @Test
    public void enterTitleStateTest() {
        GP.gameState = GP.titleState;
        GP.ui.commandNum = 0;
        GP.playMusic(0);
        KH.keyPressedAction(KeyEvent.VK_ENTER);
        assertEquals(GP.gameState, GP.playState, "When the enter key is pressed, we should open the game");

        GP.ui.commandNum = 1;
        assertDoesNotThrow(()->KH.keyPressedAction(KeyEvent.VK_ENTER), "Do not throw an exception when exiting");
    }

    @Test
    public void enterFinishStateTest(){
        GP.gameState = GP.finishState;
        KH.keyPressedAction(KeyEvent.VK_ENTER);
        assertEquals(GP.gameState, GP.titleState, "On finish screen enter takes us back to title screen");
    }

}