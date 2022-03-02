package main.java.object;

import main.java.object.*;

import javax.imageio.*;
import java.io.*;

public class RegularReward extends Location {
    public RegularReward(){
        name="Regular Reward";
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/objects/regular_reward.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
