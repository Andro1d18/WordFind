package ru.trandep.wordfind;



import android.widget.TextView;
import java.util.ArrayList;


/**
 * Created by zhezlov on 17.02.2016.
 * Класс объектов Quadrant - это объект, который соответствует какому то TextView (подрузамевается что у каждого TV будет существовать свой объект типа Quadrant).
 * Данный объект имеет id такой же как у TextView, координаты TextView начальной точки (левой верхней) и конечной (правой нижней).
 */
public  class Quadrant {
    int id;
    static ArrayList<Quadrant> allQuadrant = new ArrayList<Quadrant>();

    int startX; //X координата левой верхней точки квадранта
    int startY; //Y координата левой верхней точки квадранта
    int endX;   //X координата правой нижней точки квадранта
    int endY;   //Y координата правой нижней точки квадранта

    public Quadrant (TextView view,int lengthFromScreenEdgeToParentViewByX , int lengthFromScreenEdgeToParentViewByY){
        //делаем id квадранта такой же как id TextView
        this.id = view.getId();


        //Получаем координаты начальной (левой верхней) точки View относительно края Экрана
        int[] startAndEndPointTextViewOnParentView;
        startAndEndPointTextViewOnParentView = new int[2];
        view.getLocationInWindow(startAndEndPointTextViewOnParentView);

        //заполняем координаты начальной (левой верхней) точки квадранта относительно View(контейнера) (речь идёт о самом главном контейнере - самом первом - framelayout)
        startX = startAndEndPointTextViewOnParentView[0] - lengthFromScreenEdgeToParentViewByX; //вычитаем поданный параметр расстояния от края экрана до главного контейнера
        startY = startAndEndPointTextViewOnParentView[1] - lengthFromScreenEdgeToParentViewByY; //вычитаем поданный параметр расстояния от края экрана до главного контейнера

        //заполняем координаты конечной (правой нижней) точки квадранта
        endX = startX + view.getWidth();
        endY = startY + view.getHeight();

        //добавляем в статическую коллекцию квадрантов наш новый квадрант
        allQuadrant.add(this);

    }
}
