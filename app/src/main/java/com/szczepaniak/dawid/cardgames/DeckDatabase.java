package com.szczepaniak.dawid.cardgames;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;

/**
 * Created by dawid on 24.07.2018.
 */

public class DeckDatabase {


    ArrayList<Card> cards;

    public DeckDatabase(Context context){

        cards =  new ArrayList<>();

        // #2
        cards.add(new Card(context,0, "2Trefl", "Trefl", "2", ContextCompat.getDrawable(context, R.drawable.trefl2)));
        cards.add(new Card(context,1, "2Karo", "Karo", "2", ContextCompat.getDrawable(context, R.drawable.karo2)));
        cards.add(new Card(context,2, "2Kier", "Kier", "2", ContextCompat.getDrawable(context, R.drawable.kier2)));
        cards.add(new Card(context,3, "2Pik", "Pik", "2", ContextCompat.getDrawable(context, R.drawable.pik2)));
        // #3
        cards.add(new Card(context,4, "3Trefl", "Trefl", "3", ContextCompat.getDrawable(context, R.drawable.trefl3)));
        cards.add(new Card(context,5, "3Karo", "Karo", "3", ContextCompat.getDrawable(context, R.drawable.karo3)));
        cards.add(new Card(context,6, "3Kier", "Kier", "3", ContextCompat.getDrawable(context, R.drawable.kier3)));
        cards.add(new Card(context,7, "3Pik", "Pik", "3", ContextCompat.getDrawable(context, R.drawable.pik3)));
        // #4
        cards.add(new Card(context,8, "4Trefl", "Trefl", "4", ContextCompat.getDrawable(context, R.drawable.trefl4)));
        cards.add(new Card(context,9, "4Karo", "Karo", "4", ContextCompat.getDrawable(context, R.drawable.karo4)));
        cards.add(new Card(context,10, "4Kier", "Kier", "4", ContextCompat.getDrawable(context, R.drawable.kier4)));
        cards.add(new Card(context,11, "4Pik", "Pik", "4", ContextCompat.getDrawable(context, R.drawable.pik4)));
        // #5
        cards.add(new Card(context,12, "5Trefl", "Trefl", "5", ContextCompat.getDrawable(context, R.drawable.trefl5)));
        cards.add(new Card(context,13, "5Karo", "Karo", "5", ContextCompat.getDrawable(context, R.drawable.karo5)));
        cards.add(new Card(context,14, "5Kier", "Kier", "5", ContextCompat.getDrawable(context, R.drawable.kier5)));
        cards.add(new Card(context,15, "5Pik", "Pik", "5", ContextCompat.getDrawable(context, R.drawable.pik5)));
        // #6
        cards.add(new Card(context,16, "6Trefl", "Trefl", "6", ContextCompat.getDrawable(context, R.drawable.trefl6)));
        cards.add(new Card(context,17, "6Karo", "Karo", "6", ContextCompat.getDrawable(context, R.drawable.karo6)));
        cards.add(new Card(context,18, "6Kier", "Kier", "6", ContextCompat.getDrawable(context, R.drawable.kier6)));
        cards.add(new Card(context,19, "6Pik", "Pik", "6", ContextCompat.getDrawable(context, R.drawable.pik6)));
        // #7
        cards.add(new Card(context,20, "7Trefl", "Trefl", "7", ContextCompat.getDrawable(context, R.drawable.trefl7)));
        cards.add(new Card(context,21, "7Karo", "Karo", "7", ContextCompat.getDrawable(context, R.drawable.karo7)));
        cards.add(new Card(context,22, "7Kier", "Kier", "7", ContextCompat.getDrawable(context, R.drawable.kier7)));
        cards.add(new Card(context,23, "7Pik", "Pik", "7", ContextCompat.getDrawable(context, R.drawable.pik7)));
        // #8
        cards.add(new Card(context,24, "8Trefl", "Trefl", "8", ContextCompat.getDrawable(context, R.drawable.trefl8)));
        cards.add(new Card(context,25, "8Karo", "Karo", "8", ContextCompat.getDrawable(context, R.drawable.karo8)));
        cards.add(new Card(context,26, "8Kier", "Kier", "8", ContextCompat.getDrawable(context, R.drawable.kier8)));
        cards.add(new Card(context,27, "8Pik", "Pik", "8", ContextCompat.getDrawable(context, R.drawable.pik8)));
        // #9
        cards.add(new Card(context,28, "9Trefl", "Trefl", "9", ContextCompat.getDrawable(context, R.drawable.trefl9)));
        cards.add(new Card(context,29, "9Karo", "Karo", "9", ContextCompat.getDrawable(context, R.drawable.karo9)));
        cards.add(new Card(context,30, "9Kier", "Kier", "9", ContextCompat.getDrawable(context, R.drawable.kier9)));
        cards.add(new Card(context,31, "9Pik", "Pik", "9", ContextCompat.getDrawable(context, R.drawable.pik9)));
        // #10
        cards.add(new Card(context,32, "10Trefl", "Trefl", "10", ContextCompat.getDrawable(context, R.drawable.trefl10)));
        cards.add(new Card(context,33, "10Karo", "Karo", "10", ContextCompat.getDrawable(context, R.drawable.karo10)));
        cards.add(new Card(context,34, "10Kier", "Kier", "10", ContextCompat.getDrawable(context, R.drawable.kier10)));
        cards.add(new Card(context,35, "10Pik", "Pik", "10", ContextCompat.getDrawable(context, R.drawable.pik10)));
        // #J
        cards.add(new Card(context,36, "JTrefl", "Trefl", "J", ContextCompat.getDrawable(context, R.drawable.jtrefl)));
        cards.add(new Card(context,37, "JKaro", "Karo", "J", ContextCompat.getDrawable(context, R.drawable.jkaro)));
        cards.add(new Card(context,38, "JKier", "Kier", "J", ContextCompat.getDrawable(context, R.drawable.jkier)));
        cards.add(new Card(context,39, "JPik", "Pik", "J", ContextCompat.getDrawable(context, R.drawable.jpik)));
        // #Q
        cards.add(new Card(context,40, "QTrefl", "Trefl", "Q", ContextCompat.getDrawable(context, R.drawable.qtrefl)));
        cards.add(new Card(context,41, "QKaro", "Karo", "Q", ContextCompat.getDrawable(context, R.drawable.qkaro)));
        cards.add(new Card(context,42, "QKier", "Kier", "Q", ContextCompat.getDrawable(context, R.drawable.qkier)));
        cards.add(new Card(context,43, "QPik", "Pik", "Q", ContextCompat.getDrawable(context, R.drawable.qpik)));
        // #K
        cards.add(new Card(context,44, "KTrefl", "Trefl", "K", ContextCompat.getDrawable(context, R.drawable.ktrefl)));
        cards.add(new Card(context,45, "KKaro", "Karo", "K", ContextCompat.getDrawable(context, R.drawable.kkaro)));
        cards.add(new Card(context,46, "KKier", "Kier", "K", ContextCompat.getDrawable(context, R.drawable.kkier)));
        cards.add(new Card(context,47, "KPik", "Pik", "K", ContextCompat.getDrawable(context, R.drawable.kpik)));
        // #A
        cards.add(new Card(context,48, "ATrefl", "Trefl", "A", ContextCompat.getDrawable(context, R.drawable.atrefl)));
        cards.add(new Card(context,49, "AKaro", "Karo", "A", ContextCompat.getDrawable(context, R.drawable.akaro)));
        cards.add(new Card(context,50, "AKier", "Kier", "A", ContextCompat.getDrawable(context, R.drawable.akier)));
        cards.add(new Card(context,51, "APik", "Pik", "A", ContextCompat.getDrawable(context, R.drawable.apik)));
        // #Joker
        cards.add(new Card(context,52, "JokerBlack", "Joker", "Joker", ContextCompat.getDrawable(context, R.drawable.jokerblack)));
        cards.add(new Card(context,53, "JokerRed", "Joker", "Joker", ContextCompat.getDrawable(context, R.drawable.jokerred)));
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
}
