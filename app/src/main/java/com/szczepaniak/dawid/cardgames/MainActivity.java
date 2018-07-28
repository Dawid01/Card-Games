package com.szczepaniak.dawid.cardgames;

import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private int gameID;

    LinearLayout cards;
    LinearLayout usedCards;

    ArrayList<Card> cardsList = new ArrayList<>();
    ArrayList<Card> playerCards = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras();
        gameID = extras.getInt("GameID");

        cards =  findViewById(R.id.Cards);
        usedCards =  findViewById(R.id.usedCards);
        DeckDatabase deckDatabase = new DeckDatabase(this);
        cardsList = deckDatabase.getCards();
        createCarts();
    }

    void createCarts(){

        for(int i = 0; i < 6; i++){
            int randomIndex = new Random().nextInt(cardsList.size());
            playerCards.add(cardsList.get(randomIndex));
            cardsList.remove(randomIndex);
        }

        for (int i = 0; i < playerCards.size(); i++) {

            final Card card = playerCards.get(i);
            if (card != null) {
                LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(378 / 2, 534 / 2);
                param.setMargins(10, 10, 10, 10);
                card.setLayoutParams(param);
                cards.addView(card);
                final int index = i;
                card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cards.removeView(v);
                        playerCards.remove(v);
                        usedCards.addView(v);
                        if (playerCards.size() == 0) {

                            createCarts();
                        }
                    }
                });

            }
        }

    }

//    void removePlayerCard(int index){
//
//            playerCards.remove(index);
//            cards.removeAllViews();
//
//    }
}
