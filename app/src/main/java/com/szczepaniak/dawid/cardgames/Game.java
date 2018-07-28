package com.szczepaniak.dawid.cardgames;

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

    public Game(String name,String gameCards) {
        this.name = name;
        this.gameCards = gameCards;

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
}
