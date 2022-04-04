import com.CMPT276_Group1.project.*;
import com.CMPT276_Group1.project.GamePanel;
import org.junit.jupiter.api.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class GamePanelTest {
    private GamePanel GP;
    private Robot R;

    @BeforeEach
    public void setUp(){
        GP = new GamePanel();
    }

    @Test
    public void updateTest(){
        GP.setupGameObject();
        GP.startGameThread();
        GP.gameState = GP.playState;
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        GP.gameState = GP.pauseState;
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    @Test
    public void gameplayTest(){
        JFrame window =new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("All of Us are Dead 2D");
        window.add(GP);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        GP.setupGameObject();
        GP.startGameThread();
        try{
            R = new Robot();
        } catch (AWTException e) {
        }
        R.keyPress(KeyEvent.VK_ENTER);
        R.keyRelease(KeyEvent.VK_ENTER);
        try{
            Thread.sleep(1000);

        } catch (InterruptedException e) {
        }
        for(int i = 0; i <2; i++){
            R.keyPress(KeyEvent.VK_P);
            R.keyRelease(KeyEvent.VK_P);
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
            }
        }
        GP.gameState = GP.finishState;
        try{
            Thread.sleep(1000);

        } catch (InterruptedException e) {
        }
    }
}
