package com.CMPT276_Group1.project.tile;


import com.CMPT276_Group1.project.*;

import javax.imageio.*;
import java.awt.*;
import java.io.*;

public class TileManager {
    GamePanel gamePanel;
    public Tile[] tile;
    public int[][] mapTileNum;
    public TileManager(GamePanel gamePanel){
        this.gamePanel=gamePanel;
        tile=new Tile[3];
        mapTileNum=new int[gamePanel.maxScreenCol][gamePanel.maxScreenRow];

        getTileImage();
        loadMap("/maps/map_1.txt");
    }
    public void getTileImage(){
            setUp(0, "floor_1",false);
            setUp(1, "floor_2",false);
            setUp(2, "wall",true);
    }

    public void setUp(int index, String imageName,boolean collision){
        UtilityTool utilityTool=new UtilityTool();
        try{
            tile[index]=new Tile();
            tile[index].image=ImageIO.read(getClass().getResourceAsStream("/tiles/"+imageName+".png"));
            tile[index].image= utilityTool.scaleImage(tile[index].image,gamePanel.tileSize,gamePanel.tileSize);
            tile[index].collision=collision;
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void loadMap(String filePath){
        try{
            InputStream inputStream=getClass().getResourceAsStream(filePath);
            BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
            int col=0;
            int row=0;
            while(col< gamePanel.maxScreenCol&&row< gamePanel.maxScreenRow){
                String line=br.readLine();
                while(col< gamePanel.maxScreenCol){
                    String[] numbers =line.split(" ");
                    int num=Integer.parseInt(numbers[col]);
                    mapTileNum[col][row]=num;
                    col++;
                }
                if(col== gamePanel.maxScreenCol){
                    col=0;
                    row++;
                }
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D graphics2D){
        int col=0;
        int row=0;
        int x=0;
        int y=0;
        while(col<gamePanel.maxScreenCol&&row< gamePanel.maxScreenRow){
            int tileNum=mapTileNum[col][row];
            graphics2D.drawImage(tile[tileNum].image,x,y, null);
            col++;
            x+= gamePanel.tileSize;
            if(col== gamePanel.maxScreenCol){
                col=0;
                x=0;
                row++;
                y+= gamePanel.tileSize;
            }
        }
    }
}
