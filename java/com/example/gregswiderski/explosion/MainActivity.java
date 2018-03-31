package com.example.gregswiderski.explosion;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.*;

public class MainActivity extends Activity {

    //Global vars

    gameObject[] object;
    gameView gameView;
    levelTiles[] tile;
    readFile read;
    String[] split;

    int totalT_P2 = 14;
    int time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameView = findViewById(R.id.GameView);
        initGame();
        th.start();
        //Toast.makeText(getApplicationContext(),"Hello Greg",Toast.LENGTH_SHORT).show();



    }
    public void initGame(){
        System.out.println("Init game in MainActivity");
        //Load level
        loadLevel(1);
        //Load gameObjects
        object = new gameObject[2];
        object[0] = new gameObject(this,"hero",100,930);
        object[1] =  new gameObject(this,"explosion1",200,100);

        time = 0;

    }
    public void loadLevel(int level){
        //Read file
        read = new readFile(this,totalT_P2);
        split = read.split;
        //read.getTiles();
        char[][] fileTiles;
        fileTiles = read.getTiles();
        //Toast.makeText(getApplicationContext(),split[0],Toast.LENGTH_SHORT).show();


        //225 tiles in total per screen
        int tilesCounter = 0; // count number of TOTAL tiles per screen
        tile = new levelTiles[totalT_P2*totalT_P2];
        for(int r=0;r<totalT_P2;r++){
            for(int c=0;c<totalT_P2;c++){
            tile[tilesCounter] = new levelTiles(this,read.getTiles()[c][r],r,c);
            tilesCounter++;
            }
        }



    }


    final Thread th = new Thread(new Runnable() {
        @Override
        public void run() {
            while(true){
                try {

                    // control
                    Thread.sleep(20);
                    time++;

                    // update
                        if(time>100) {
                            for(gameObject ob : object){
                                ob.update();
                            }
                        }


                    // Draw screen
                    gameView.drawScreen(object,tile,split[0]);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    });
}


