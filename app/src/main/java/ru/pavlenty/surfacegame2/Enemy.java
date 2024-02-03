package ru.pavlenty.surfacegame2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Log;

import java.util.Random;


public class Enemy {
    private int x;
    private int y;
    private int speed;
    private Bitmap bitmap;
    private int maxX;
    private int maxY;
    private int minX;
    private int minY;
    private Rect detectCollision;


    public Enemy(Context context, int screenX, int screenY) {
        maxX = screenX;
        maxY = screenY;
        minX = 300;
        minY = 0;
        Random generator = new Random();
        x = generator.nextInt(maxX);
        y = generator.nextInt(maxY);
        speed = 1;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy);
        Log.d("111", " " + x + " " + y +" "+ (bitmap.getWidth() - x) + " " + bitmap.getHeight());
        detectCollision =  new Rect(x, y, bitmap.getWidth(), bitmap.getHeight());
    }

    public void update(int playerSpeed) {

        x -= playerSpeed;
        x -= speed;

        if (x < 0) {

            x = maxX;
            Random generator = new Random();
            y = generator.nextInt(maxY);
            speed = generator.nextInt(15);
        }
        detectCollision.left = x;
        detectCollision.top = y;
        detectCollision.right = bitmap.getWidth() + x;
        detectCollision.bottom = bitmap.getHeight() + y;
    }

    public float getEnemyWidth() {

        float minX = 1.0f;
        float maxX = 4.0f;
        Random rand = new Random();
        float finalX = rand.nextFloat()* (maxX - minX) + minX;
        return finalX;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }
    public Rect getDetectCollision() {
        return detectCollision;
    }
}
