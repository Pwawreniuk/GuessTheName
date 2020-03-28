package com.company;

import java.util.Scanner;

public class Game {
    private String movieName;
    private String underscoreName;
    private boolean runningGame = false;
    private int nameLength;
    private int points;
    private char [] wrongLetters = new char[10];
    private int wrongLettersCount;

    public Game(String movieName) {
        this.movieName = movieName;
        nameLength = movieName.split(" ").length;
        runningGame = true;
        points = 10;
        wrongLettersCount = 0;
    }

    public void GameStart() {
        underscoreName = movieName.replaceAll("[a-zA-Z]", "_");
        System.out.println(underscoreName);

        while(points > 0 ) {
            AskForLetter();
            if(underscoreName.equals(movieName)) {
                System.out.println("YOU WON");
                points = 0;
            }
        }
    }

    public void AskForLetter() {
        Scanner scanner = new Scanner(System.in);
        boolean ifCorrect = false;
        boolean wasWrong = false;
        System.out.println("Guess a letter:");

        //String guess = scanner.next();

        int letterIndex = 0;
        String guess = scanner.next();
        Scanner WordScanner = new Scanner(movieName);
        for(int i = 0; i < nameLength; i++, letterIndex++) {
            String Word = WordScanner.next();
            char nextLetter;
            for(int j = 0; j < Word.length(); j++, letterIndex++) {
                nextLetter = Word.charAt(j);
                if(nextLetter == guess.charAt(0) ) {
                    underscoreName = underscoreName.substring(0, letterIndex) + guess + underscoreName.substring(letterIndex + 1);
                    ifCorrect = true;
                }
            }

        }
        if(!ifCorrect) {
            for(int k = 0; k < wrongLettersCount; k++) {
                if(wrongLetters[k] == guess.charAt(0)) {
                    wasWrong = true;
                }
            }

            if(!wasWrong) {
                wrongLetters[wrongLettersCount] = guess.charAt(0);
                wrongLettersCount++;
                points--;
                System.out.println("You guessed wrong.");
            }
            else {System.out.println("You already guessed that letter."); }
        }
        System.out.println("You are guessing:" + underscoreName);
        System.out.println("You have guessed (" + (10 - points) + ") wrong letters");
    }

}