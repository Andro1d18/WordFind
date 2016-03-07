package ru.trandep.wordfind;

import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by zhezlov on 07.03.2016.
 */
public class MyTouchListener implements View.OnTouchListener {
    IdentifyCoordsAllTextViewFromMainView identCoordAllTextView;
    public MainActivity.Painter mThread;
    ArrayList<Point> listPoints = new ArrayList<>();

    public MyTouchListener(IdentifyCoordsAllTextViewFromMainView ident, MainActivity.Painter mThread){
        this.identCoordAllTextView = ident;
        this.mThread = mThread;
    }

    float x;
    float y;
    String sDown;
    String sMove;
    String sUp;
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x = event.getX();
        y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: // нажатие
                //очистить предыдущий список тача
                identCoordAllTextView.listDynamicTextViewTouched.clear();

                //создать точку и записать её в список точек - для прорисовки линиий
                Point pointDown = new Point(x, y);
                listPoints.add(pointDown);
                mThread.draw(x, y);

                break;

            case MotionEvent.ACTION_MOVE: // движение
                //заполнение списка  текст вью по которым провели
                identCoordAllTextView.fillinglistDynamicTextViewTouched(x,y);

                //создать точку и записать её в список точек - для прорисовки линиий
                Point pointMove = new Point(x, y);
                listPoints.add(pointMove);
                mThread.draw(listPoints);

                // Рисуем график на SurfaceView
               // mThread.draw(x, y);
                break;

            case MotionEvent.ACTION_UP: // отпускание
            case MotionEvent.ACTION_CANCEL:
                //создание дублированной переменной списка динамик текстВью (по которым провели только что),
                // чтобы в список списков добавлился новый список, а не ссылка на listDynamicTextViewTouched
                // (если будет добавляться ссылка, то список списков будет содержать всегда один и тот же список тачей)
                ArrayList<TextView> oneTouched = new ArrayList<>();
                for (TextView tvOneTouched: identCoordAllTextView.listDynamicTextViewTouched){
                    oneTouched.add(tvOneTouched);
                }
                //добавляем в список списков наш только что созданный список
                identCoordAllTextView.listListsTouch.add(oneTouched);


                //сбрасываем линию
                mThread.wipeLine(listPoints);

                //рисуем Комплитед лайн
                mThread.complitedLine(identCoordAllTextView.listDynamicTextViewTouched);

                //очистка списка точек после поднятия пальца
                listPoints.clear();
                break;
        }

        return true;
    }


    public class Point {
        float x;
        float y;
        Point (float x, float y){
            this.x = x;
            this.y = y;
        }
    }
}
