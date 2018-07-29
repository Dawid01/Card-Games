package com.szczepaniak.dawid.cardgames;

import java.util.ArrayList;

/**
 * Created by dawid on 29.07.2018.
 */

public class Game {

    private String name;
    private String gameCards;
    private String treflCards;
    private String karoCards;
    private String kierCards;
    private String pikCards;
    private Player player;

    public Game(String name,String gameCards, Player player) {
        this.name = name;
        this.gameCards = gameCards;
        this.player =  player;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGameCards() {
        return gameCards;
    }

    public void setGameCards(String gameCards) {
        this.gameCards = gameCards;
    }

    public String getTreflCards() {
        return treflCards;
    }

    public void setTreflCards(String treflCards) {
        this.treflCards = treflCards;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }


}
