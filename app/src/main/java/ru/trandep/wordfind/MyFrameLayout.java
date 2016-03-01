package ru.trandep.wordfind;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by zhezlov on 27.02.2016.
 */

    //мой подкласс фраймлайаута для переопределения рисования (onDraw) и рисования
public class MyFrameLayout extends FrameLayout {

    public MyFrameLayout (Context context){
        super(context);
        this.setWillNotDraw(false);
    }
    public MyFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setWillNotDraw(false);
    }

    public MyFrameLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.setWillNotDraw(false);
    }
    Paint p = new Paint();
    @Override
    protected void onDraw(Canvas canvas){

        //TODO ВЫНЕСТИ В ОТДЕЛЬНЫЙ КЛАСС РИСОВАЛЬЩИКА И ЗДЕСЬ ВЫЗЫВАТЬ ТОЛЬКО ЕГО МЕТОД (или подумай что лучше здесь вызывать)
        //ТЕСТ прорисовки ЛИНИИ
        // настройка кисти
        // красный цвет
        p.setColor(Color.RED);
        // толщина линии = 10
        p.setStrokeWidth(10);
        p.setAlpha(50);
        // рисуем линию от (100,100) до (500,50)
        canvas.drawLine(000,000,100,150,p);

//        //ТЕСТ прорисовки
//        Painter painter = new Painter();
//        painter.drawColumn(canvas,0,00,20,20);


        super.onDraw(canvas);
    }

}
