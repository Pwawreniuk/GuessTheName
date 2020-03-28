package com.company;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        String choosenMovie = null;

        File file = new File("Movies.txt");
        Scanner fileScanner1 = new Scanner(file);

        int movieNum = 0;
        while (fileScanner1.hasNextLine()) {
            String line = fileScanner1.nextLine();
            movieNum++;
        }

        int randMovie = (int) (Math.random() * movieNum) + 1;
        Scanner fileScanner2 = new Scanner(file);
        for(int i = 0; i < randMovie; i++) {
            choosenMovie = fileScanner2.nextLine();
        }
        System.out.println(choosenMovie);
    }
}