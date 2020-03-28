package com.company;

import java.util.Scanner;

public class Game {
    private String movieName;
    private String underscoreName;
    boolean runningGame = false;
    private int nameLength;

    public Game(String movieName) {
        this.movieName = movieName;
        nameLength = movieName.split(" ").length;
        runningGame = true;
    }

    public void GameStart() {
        underscoreName = movieName.replaceAll("[a-zA-Z]", "_");
        System.out.println(underscoreName);
    }

    public void AskForLetter() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Guess a letter:");

        //String guess = scanner.next();

        int letterIndex = 0;
        String guess = scanner.next();
        Scanner WordScanner = new Scanner(movieName);
        for(int i = 0; i < nameLength; i++) {
            String Word = WordScanner.next();
            char nextLetter;
            for(int j = 0; j < Word.length(); j++, letterIndex++) {
                nextLetter = Word.charAt(j);
                if(nextLetter == guess.charAt(0) ) {
                    underscoreName = underscoreName.substring(0, letterIndex) + guess + underscoreName.substring(letterIndex + 1);
                }
            }

        }
        System.out.println("You are guessing:" + underscoreName);

    }

}
