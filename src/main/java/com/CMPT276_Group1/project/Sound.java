package com.CMPT276_Group1.project;

import javax.sound.sampled.*;
import java.net.*;

public class Sound {
    Clip clip;
    URL[] soundURL =new URL[30];
    public Sound(){
        soundURL[0]=getClass().getResource("/sound/Dark-theme.wav");
        soundURL[1]=getClass().getResource("/sound/pick_up_regular_reward.wav");
        soundURL[2]=getClass().getResource("/sound/pick_up_special_reward.wav");
        soundURL[3]=getClass().getResource("/sound/fanfare.wav");
        soundURL[4]=getClass().getResource("/sound/title_screen_music.wav");
    }
    public void setFile(int i){
        try{
            AudioInputStream audioInputStream=AudioSystem.getAudioInputStream(soundURL[i]);
            clip=AudioSystem.getClip();
            clip.open(audioInputStream);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void play(){
        clip.start();
    }

    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop(){
        clip.stop();
    }
}
