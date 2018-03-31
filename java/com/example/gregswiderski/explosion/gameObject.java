package com.example.gregswiderski.explosion;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class gameObject {

    Bitmap bitmap;
    String name;
    Context context;

    int frame;
    int numberOfFrames;
    int x,y;
    boolean visible;

    //animation vars
    boolean loop;
    boolean moving;
    int direction; //1 = left, 2 = right

    public gameObject(Context con, String objectName, int xx, int yy){
        //System.out.println("Explosion constructor");
        this.context = con;
        this.name = objectName;
        this.x = xx;
        this.y = yy;
        initObject(name);
    }

    public void initObject(String name){
        if(name.equalsIgnoreCase("explosion1")){
            this.bitmap =  BitmapFactory.decodeResource(context.getResources(),R.drawable.bomb);
            this.frame = 1;
            this.numberOfFrames = 12;
            this.loop = false;
            this.moving = false;
            this.visible = false;


        }
        if(name.equalsIgnoreCase("hero")){
            this.bitmap =  BitmapFactory.decodeResource(context.getResources(),R.drawable.hero_idle_right_1);
            this.frame = 1;
            this.numberOfFrames = 8;
            this.loop = true;
            this.moving = true;
            this.direction = 2;
            this.visible = true;
        }
    }

    public void update(){
        updateObject();
        updateFrame();
        updateBitmap();

    }
    public void updateFrame(){
        if(frame>numberOfFrames && loop == true){
            frame = 1;
        }
        else{
            frame++;
        }
    }
    public void updateObject(){
        if(this.moving){
            if(direction==1){
                x = x - 10;
            }
            else if(direction==2){
                x = x + 10;
            }
        }
    }
    public void updateBitmap(){
        if (name.equalsIgnoreCase("explosion1")) {
            if (frame < 12) {
                int id = context.getResources().getIdentifier("explosion" + frame, "drawable", context.getPackageName());
                bitmap = BitmapFactory.decodeResource(context.getResources(), id);
            }

        } else if (name.equalsIgnoreCase("hero")) {
            if(frame < 8){
                int id = context.getResources().getIdentifier("hero_walking_right_" + frame, "drawable", context.getPackageName());
                bitmap = BitmapFactory.decodeResource(context.getResources(), id);

            }
        }
    }

    public Bitmap getBitmap(){
        return bitmap;
    }
    public int getFrame(){
        return frame;
    }
    public int getX(){
        return  x;
    }
    public int getY(){
        return y;
    }
    public String getName(){return name;}
}
