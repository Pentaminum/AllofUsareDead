package com.CMPT276_Group1.project;

import javax.sound.sampled.*;
import java.net.*;

/**
 * Class to handle all sound for the game
 */
public class Sound {
    Clip clip;
    URL[] soundURL =new URL[9];

    /**
     * Constructor for the sound class that selects the sound effects and theme music
     */
    public Sound(){
        soundURL[0]=getClass().getResource("/sound/Dark-theme.wav");
        soundURL[1]=getClass().getResource("/sound/pick_up_regular_reward.wav");
        soundURL[2]=getClass().getResource("/sound/pick_up_regular_reward_2.wav");
        soundURL[3]=getClass().getResource("/sound/pick_up_regular_reward_3.wav");
        soundURL[4]=getClass().getResource("/sound/pick_up_special_reward.wav");
        soundURL[5]=getClass().getResource("/sound/fanfare.wav");
        soundURL[6]=getClass().getResource("/sound/title_screen_music.wav");
        soundURL[7]=getClass().getResource("/sound/defeated.wav");
        soundURL[8]=getClass().getResource("/sound/zombie_hit.wav");
    }

    /**
     * Wrapper for the clip isOpen function
     * @return boolean for whether there is an open clip or not
     */
    public boolean isOpen(){
        return clip.isOpen();
    }

    /**
     * Wrapper for the clip isRunning function
     * @return boolean for whether the clip is playing or not
     */
    public boolean isPlaying(){
        return clip.isRunning();
    }

    /**
     * Select which file we want to load into our current clip
     * @param i allow us to select the file
     */
    public void setFile(int i){
        try{
            AudioInputStream audioInputStream=AudioSystem.getAudioInputStream(soundURL[i]);
            clip=AudioSystem.getClip();
            clip.open(audioInputStream);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Play the current clip
     */
    public void play(){
        clip.start();
    }

    /**
     * Loop the current clip
     */
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    /**
     * Stop the current clip
     */
    public void stop(){
        clip.stop();
    }
}
