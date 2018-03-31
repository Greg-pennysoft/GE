package com.example.gregswiderski.explosion;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

//Surface view that will clearScreen our game objects

public class gameView extends SurfaceView implements  SurfaceHolder.Callback {

    //Global Vars
    SurfaceHolder holder;
    Paint paint;
    Canvas canvas;
    Context con;



    public gameView(Context context, AttributeSet attrs) {
        super(context,attrs);
        this.con = context;
        initView();
    }
    public void initView(){
        holder = this.getHolder();
        holder.addCallback(this);
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        this.setZOrderOnTop(true);
        paint = new Paint();

    }




    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        clearScreen();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }

    public void clearScreen(){
        if(holder.getSurface().isValid()){
            System.out.println("surface holder is valid");
            //First we lock the area of memory we will be drawing to
            canvas = holder.lockCanvas();
            // Rub out the last frame
            canvas.drawColor(Color.LTGRAY);
            // Unlock canvas and post to screen

            holder.unlockCanvasAndPost(canvas);

        }
    }

    public void drawScreen(gameObject[] object, levelTiles[] tile,String read){
        if(holder.getSurface().isValid()){
            canvas = holder.lockCanvas();
            // Rub out the last frame
            canvas.drawColor(Color.BLACK);
            // Draw something
            for(gameObject o : object){
                if(o.visible) {
                    canvas.drawBitmap(o.getBitmap(), o.getX(), o.getY(), paint);
                }
            }
            for(levelTiles til : tile) {
                if(til.visible) {
                    canvas.drawBitmap(til.getBitmap(), til.getX(), til.getY(), paint);
                    //System.out.println(til.x+" "+til.y);
                }
            }
                canvas.drawText(read,300,300,paint);
            //canvas.drawBitmap(object.getBitmap(), object.getX(), object.getY(), paint);
            // Unlock canvas and post to screen
            holder.unlockCanvasAndPost(canvas);
        }
    }
}
