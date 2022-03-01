package main.java.tile;

import main.java.*;

import javax.imageio.*;
import java.awt.*;
import java.io.*;

public class TileManager {
    GamePanel gamePanel;
    public Tile[] tile;
    public int[][] mapTileNum;
    public TileManager(GamePanel gamePanel){
        this.gamePanel=gamePanel;
        tile=new Tile[10];
        mapTileNum=new int[gamePanel.maxScreenCol][gamePanel.maxScreenRow];

        getTileImage();
        loadMap("/maps/map_1.txt");
    }
    public void getTileImage(){
        try{
            tile[0]=new Tile();
            tile[0].image= ImageIO.read(getClass().getResourceAsStream("/tiles/floor.png"));

            tile[1]=new Tile();
            tile[1].image= ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
            tile[1].collision=true;

        }catch (IOException e){
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
            graphics2D.drawImage(tile[tileNum].image,x,y,gamePanel.tileSize, gamePanel.tileSize, null);
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
