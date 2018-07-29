package com.szczepaniak.dawid.cardgames;

import android.os.Debug;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private String gameID;

    private LinearLayout cards;
    private LinearLayout usedCards;

    private ArrayList<Card> cardsList = new ArrayList<>();
    private ArrayList<Card> playerCards = new ArrayList<>();
    private ArrayList<Integer> gameCardsIndex =  new ArrayList<>();

    private String dataBaseIndexs;

    private DeckDatabase deckDatabase;

    FirebaseDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras();
        gameID = extras.getString("GameID");

        database = FirebaseDatabase.getInstance();
        cards =  findViewById(R.id.Cards);
        usedCards =  findViewById(R.id.usedCards);
        deckDatabase = new DeckDatabase(this);

        database.getReference(gameID).child("gameCards").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                dataBaseIndexs = dataSnapshot.getValue().toString();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        database.getReference(gameID).child("name").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                getSupportActionBar().setTitle("" + dataSnapshot.getValue().toString());
                cardsList = getGameCardsIndex();
                createCarts();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

       // cardsList = getGameCardsIndex();
        //cardsList =  deckDatabase.getCards();
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

    ArrayList<Card> getGameCardsIndex(){

        ArrayList<Card> cards =  new ArrayList<>();


        //dataBaseIndexs = database.getReference(gameID).child("gameCards").;
        // dataBaseIndexs = database.getReference(gameID).child("gameCards").toString();
        String[] indexs = dataBaseIndexs.split(", ");

        for(String index : indexs){

            int i = Integer.parseInt(index);
            cards.add(deckDatabase.getCards().get(i));
        }

        return  cards;
    }


//    void removePlayerCard(int index){
//
//            playerCards.remove(index);
//            cards.removeAllViews();
//
//    }
}
