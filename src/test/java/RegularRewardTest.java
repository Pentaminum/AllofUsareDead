import com.CMPT276_Group1.project.*;
import org.junit.jupiter.api.*;

import java.awt.event.*;
import java.io.File;

import static com.CMPT276_Group1.project.KeyHandler.keyReleasedAction;
import static com.CMPT276_Group1.project.KeyHandler.keyPressedAction;
import static org.junit.jupiter.api.Assertions.*;

public class RegularRewardTest {
    @Test
    public void testImage() {
        File file = new File("regular_reward.png");
        assertNotNull(file,"asserts that the image file is not null");
        assertEquals("regular_reward.png",file.getName(),"asserts that the image file is correct");
    }

}

