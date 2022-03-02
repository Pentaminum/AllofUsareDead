package main.java.object;

import main.java.object.*;

import javax.imageio.*;
import java.io.*;

public class Trap extends Location {
    public Trap(){
        name="Trap";
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/objects/trap.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
