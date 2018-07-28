package com.szczepaniak.dawid.cardgames;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class RoomsActivity extends AppCompatActivity {


    private EditText roomName;
    private Button back;
    private Button create;
    FirebaseDatabase database;
    DatabaseReference gamesBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);

         back = findViewById(R.id.Back);
         create = findViewById(R.id.Create);
         roomName = findViewById(R.id.RoomName);
         database = FirebaseDatabase.getInstance();
         gamesBase = FirebaseDatabase.getInstance().getReference("Games");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RoomsActivity.this, AccountActivity.class));
                finish();
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateGameRoom();
            }
        });
    }


    void CreateGameRoom(){

        if(roomName.getText() != null){

            String id =  gamesBase.push().getKey();
            DeckDatabase deckDatabase =  new DeckDatabase(this);

            ArrayList<String> cardsNames =  new ArrayList<>();
            String cardsString = "";

            for(Card card : deckDatabase.getCards()){

                cardsNames.add(card.getName());

            }

            //cardsString = String.join(",", deckDatabase.getCards().toString());

            for (String s : cardsNames)
            {
                cardsString += s + ", ";
            }
            Game newGame =  new Game(roomName.getText().toString(), cardsString);
            database.getReference().child(id).setValue(newGame);
            Intent gameIntent = new Intent(RoomsActivity.this, MainActivity.class);
            gameIntent.putExtra("GameID", id);
            startActivity(gameIntent);

        }

    }
}
