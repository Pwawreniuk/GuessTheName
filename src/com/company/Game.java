package com.company;

public class Game {
    private String movieName;
    private String underscoreName;

    public Game(String movieName) {
        this.movieName = movieName;
    }

    public void GameStart() {
        underscoreName = movieName.replaceAll("[a-zA-Z]", "_");
        System.out.println(underscoreName);
    }
}
