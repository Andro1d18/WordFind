package ru.trandep.wordfind;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by zhezlov on 10.02.2016.
 * Класс, который является инструментом для определения координат всех TextView элементов, в которых размещены буквы (каждая буква размещена в своём отдельном TextView)
 * Заранее установили, что TextView будут вложены в трёх уровневую модель: вначале подаётся FrameLayout, его дочерние элементы это 1 LinerLayout, а у этого
 * LinerLayout уже могут быть несколько дочерних элементов (тоже LinerLayout, но vertical), а уже в этиих вертикальных лайаутах, будут лежать нужные нам TextView.
 */
public class IdentifyCoordsAllTextViewFromMainView {
    //список всех TextView (в которых Буквы)
    ArrayList<TextView> listAllTextVeiwFromMainView = new ArrayList<TextView>();
    // список TextView заполняющийся динамически - те TV по которым прошёлся тачлистенер
    ArrayList<TextView> listDynamicTextViewTouched = new ArrayList<TextView>();



    public IdentifyCoordsAllTextViewFromMainView(ViewGroup v){ //на входе в метод подали контейнер View элементов


        //знаем что в нём 1 дочерний элемент
        ViewGroup v2 = (ViewGroup) v.getChildAt(0);

        //узнаем растояние от краёв экрана (по X и Y) до начальной точки (левой верхней) нашего главного контейнера
        int[] startAndEndPointV = new int[2];
        v.getLocationInWindow(startAndEndPointV);
        int lengthFromScreenEdgeToViewVbyY = startAndEndPointV[1];
        int lengthFromScreenEdgeToViewVbyX = startAndEndPointV[0];

        //У следующего контейнера (предполагается первый LL(вертикальный) мы не знаем сколько дочерних элементов. Нужно узнать
        int countChildFromV2 = v2.getChildCount();
        //Заходим в цикл и перебираем все контейнеры (тоже LL, но горизонтальные) в контейнере LL(вертикальном)
        for (int i = 0; i < countChildFromV2 ; i++) {
            //в цикле берем первый горизонтальный LL
            ViewGroup v3 = (ViewGroup) v2.getChildAt(i);    //TODO переделать на коллекцию
            //заходим в ещё один цикл и идём по каждому TextView который содержится в этом LL
            for (int j = 0; j <v3.getChildCount() ; j++) {
                //ОСТАНОВИЛСЯ ТУТ - нужно записать в список (как минимум) двумерных массивов координаты всех TextView.
                // Перепридумал - записать в коллекцию все TexTview элементы
                this.listAllTextVeiwFromMainView.add((TextView)v3.getChildAt(j));
                //создаём специальный объект клсса квадрант, который имеет одинаковый id, что и TextView, и хранит в себе координаты плащади TextView
                Quadrant q1 = new Quadrant((TextView)v3.getChildAt(j), lengthFromScreenEdgeToViewVbyX,lengthFromScreenEdgeToViewVbyY);

            }
        }

    }

    //Метод, который сообщает ID квадранта (он в свою очередь совпадает с id TextView) по координатам
    public int getIdTextViewByCoords (float x, float y){

        int id = 0;
        //идем по статик коллекции всех квадрантов
        for (Quadrant q: Quadrant.allQuadrant){
            if (q.startX <= x & x <= q.endX & q.startY <= y & y <= q.endY) // если нашли нужный элемент
                id = q.id;      //то записываем его id
        }
        return id;
    }

    //Метод возращающий Text у TextView по координатам.
    public String getTextFromTextViewByCoords (float x, float y){
        String result = "";
        int id = this.getIdTextViewByCoords(x,y);
        for (Quadrant q : Quadrant.allQuadrant){
            if (q.id == id) {
                result = q.letterFromTextView;
            }
        }
        return result;
    }

    //метод записывающий TextView в listDynamicTextViewTouched. Метод не добавляет те textView по которым уже был проведен
    public void fillinglistDynamicTextViewTouched (float x, float y){

        int id = this.getIdTextViewByCoords(x,y);
        for (TextView tv: listAllTextVeiwFromMainView){
            if (tv.getId() == id){
                if (listDynamicTextViewTouched.contains(tv)){
                    break;
                }
                else listDynamicTextViewTouched.add(tv);
            }
        }
    }


}
