package com.example.ballsgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

public class Player {
    private static final double SPPED_PIXELS_PER_SECOND = 400;
    private static final double MAX_SPEED = SPPED_PIXELS_PER_SECOND / GameLoop.MAX_UPS;
    private double positionX;
    private double positionY;
    private double radius;
    private Paint paint;
    private double velosityX;
    private double velosityY;

    public Player(Context context, double positionX, double positionY, double radius) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.radius = radius;

        paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.player);
        paint.setColor(color);
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle((float)positionX, (float)positionY, (float)radius, paint);
    }

    public void update(Joystick joystick) {
        velosityX = joystick.getActuatorX()*MAX_SPEED;
        velosityY = joystick.getActuatorY()*MAX_SPEED;
        positionX += velosityX;
        positionY += velosityY;


    }

    public void setPosition(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }
}
