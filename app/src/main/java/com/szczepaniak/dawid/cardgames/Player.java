package com.szczepaniak.dawid.cardgames;

/**
 * Created by dawid on 29.07.2018.
 */

public class Player {


    String playerName;
    String playerCards;

    public Player(String playerName, String playerCards) {
        this.playerName = playerName;
        this.playerCards = playerCards;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerCards() {
        return playerCards;
    }

    public void setPlayerCards(String playerCards) {
        this.playerCards = playerCards;
    }
}
