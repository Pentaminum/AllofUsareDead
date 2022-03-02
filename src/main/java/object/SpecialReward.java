package main.java.object;

import main.java.object.*;

import javax.imageio.*;
import java.io.*;

public class SpecialReward extends Location {
    public SpecialReward(){
        name="Special Reward";
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/objects/special_reward.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
