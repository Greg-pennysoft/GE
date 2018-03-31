package com.example.gregswiderski.explosion;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class levelTiles {

    Context context;
    Bitmap bitmap;
    char tile2;
    char tile;


    boolean visible;

    int x,y;
    int xPosition;
    int yPosition;

    public levelTiles(Context con, char t,int posX, int posY){
        this.context = con;
        this.tile = t;
        this.xPosition = posX;
        this.yPosition = posY;
        initTile();
    }

    public void initTile(){
        if(tile=='1'){
            this.bitmap =  BitmapFactory.decodeResource(context.getResources(),R.drawable.tile1);
            this.y = 1040;
            this.visible = true;

        }
        else{
            this.visible = false;
        }
        this.x = this.xPosition * 80;
        this.y = this.yPosition * 80;
        System.out.println("Tile: x & y:  "+this.x+" "+this.y);

    }//1040
    public Bitmap getBitmap(){
        return this.bitmap;
    }

    public void setTile (char t){
        this.tile = t;
    }
    public void setX (int xx) {
        this.x = xx;
    }
    public void setY (int yy) {
        this.y = yy;
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

}
