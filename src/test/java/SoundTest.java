import com.CMPT276_Group1.project.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class SoundTest {
    Sound S;

    @BeforeEach
    public void setUp(){
        S = new Sound();
    }
    @Test
    public void constructorTest(){
        Sound STest = new Sound();
        assertNotNull(S, "Check that the object is constructed");
    }

    @Test
    public void setFileTest(){
        S.setFile(3);
        assertTrue(S.isOpen(), "Clip should be open");
    }

    @Test
    public void playTest(){
        S.setFile(0);
        S.play();
        try{
            Thread.sleep(100);
        }catch(InterruptedException e) {
            throw new RuntimeException("Unexpected Interrupt", e);
        }
        assertTrue(S.isPlaying(), "Clip should be playing");
        S.stop();
    }

    @Test
    public void loopTest(){
        S.setFile(1);
        S.play();
        S.loop();
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e) {
            throw new RuntimeException("Unexpected Interrupt", e);
        }
        assertTrue(S.isPlaying());
        S.stop();
    }

    @Test
    public void stopTest(){
        S.setFile(1);
        S.play();
        S.stop();
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e) {
            throw new RuntimeException("Unexpected Interrupt", e);
        }
        assertFalse(S.isPlaying());
    }
}
