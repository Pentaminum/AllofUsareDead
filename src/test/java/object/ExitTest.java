package object;

import com.CMPT276_Group1.project.*;
import com.CMPT276_Group1.project.object.Exit;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ExitTest {
    private Exit E;
    private GamePanel GP;
    @BeforeEach
    void setUp(){
        GP = new GamePanel();
        E = new Exit(GP);
    }
    @Test
    public void constructorTest(){
        Exit TestE = new Exit(GP);
        assertNotNull(TestE, "The object should be constructed properly");
    }
}
