package com.example.gregswiderski.explosion;

import android.content.Context;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class readFile {
    // GLOBAL VARS
    StringBuilder text;
    String[] split;
    int totalT_P2;
    char[][] tiles;

    // CONSTRUCTOR
    public readFile(Context con,int totalT2) {
        totalT_P2 = totalT2;
        text = new StringBuilder();
        // READ FILE INTO ONE LONG STRING
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getAssets().open("level1.txt")));

            String line;
            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            br.close();
            System.out.println(text.toString());


        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: " + e);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException: " + e);
            e.printStackTrace();
        }

        //SEPERATE STRINGS BY A WHITE SPACE INTO AN ARRAY OF SEPERATE STRINGS
        seperateStrings(text.toString());
        seperateLetters();

    }

    public char[][] getTiles(){
        return tiles;
    }

    public void seperateStrings(String original){
        split = original.split("\\s+");

    }
    public void seperateLetters(){
        tiles = new char[totalT_P2][totalT_P2];
        int i = 0;
        for(String str :split ){
            tiles[i] = str.toCharArray();
            i++;
        }

    }

    public String getString(){
        return text.toString();
    }



}
