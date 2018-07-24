package com.szczepaniak.dawid.cardgames;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.RelativeLayout;

/**
 * Created by dawid on 24.07.2018.
 */

public class Card extends View{

    private int index;
    private String name;
    private String type;
    private String value;
    private Drawable image;
    RelativeLayout.LayoutParams param;

    int deltaX;
    int deltaY;

    public Card(Context context, int index, String name, String type, String value, Drawable image) {
        super(context);
        this.index = index;
        this.name = name;
        this.type = type;
        this.value = value;
        this.image = image;
        this.setBackground(image);
       // param = new RelativeLayout.LayoutParams(378/2, 534/2);
       // param.setMargins(10,10,10,10);
        //this.setLayoutParams(param);
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent e) {
//
//
//        int x = (int) e.getX();
//        int y = (int) e.getY();
//
//
//        switch (e.getAction()) {
//
//            case MotionEvent.ACTION_DOWN:
//                deltaX = x - param.leftMargin;
//                deltaY = y - param.topMargin;
//
//                break;
//            case MotionEvent.ACTION_MOVE:
//                param.leftMargin = x - deltaX;
//                param.topMargin = y - deltaY;
//                param.rightMargin = param.width/2;
//                param.bottomMargin = param.height/2;
//                this.setLayoutParams(param);
//                break;
//
//        }
//
//        return true;
//    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public Drawable getImage() {
        return image;
    }
}
