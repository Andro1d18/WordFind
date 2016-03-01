package ru.trandep.wordfind;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by zhezlov on 27.02.2016.
 */
//ТЕСТОВЫЙ КЛАСС ДЛЯ ПОНИАНИЯ КАК РИСОВАТЬ и ПЕРЕОПРЕДЕЛЯТЬ ВЕРХНЕУРОВНЕВЫЕ КЛАССЫ!
public class MyButton extends Button {


        public MyButton(Context context) {
            super(context);

        }

        public MyButton(Context context, AttributeSet attrs) {
            super(context, attrs);

        }

        public MyButton(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);

        }

        @Override
        protected void onDraw(Canvas canvas) {


//                Paint paint = new Paint();
//                paint.setColor(Color.BLUE);
//                paint.setStrokeWidth(10);
//                paint.setStyle(Paint.Style.FILL);
//                int width = getWidth();
//                int height = getHeight();
//                canvas.drawCircle(width/2, height/2, height/3, paint);
                Painter painter = new Painter();
                painter.drawColumn(canvas,0,00,20,20);

                super.onDraw(canvas);

        }
}

