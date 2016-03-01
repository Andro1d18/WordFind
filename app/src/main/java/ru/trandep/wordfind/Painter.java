package ru.trandep.wordfind;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by zhezlov on 27.02.2016.
 */
//КЛАСС-РИСОВАЛЬЩИК
public class Painter {
    Paint p = new Paint();

    //ТЕСТОВЫЕ ПЕРЕМЕННЫЕ И ЗНАЧЕНИЯ ДЛЯ ПОНИМАНИЯ КАК РАБОТАЕТ РИСОВАНИЕ
    public void drawColumn(Canvas c, float left, float top, float width, float height){
        // автовычисляемые поля
        float rightMargin = left + width;
        float bottomMargin = top + height;
        //задаём цвет линии
        p.setColor(Color.RED);
        // толщина линии = 10
        p.setStrokeWidth(10);
        // рисуем прямоугольник
        c.drawRect(left, top, rightMargin, bottomMargin, p);
    }
}
