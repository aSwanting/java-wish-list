package org.learning.wishlist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WishList {

    static ArrayList<Present> presents = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
    static boolean finished = false;

    public static void main(String[] args) {

        try {
            fetchList();
        } catch (FileNotFoundException e) {
            System.out.println("No list found, creating new one\n...");
        }

        addPresents();
        Collections.sort(presents);
        System.out.println(presents.toString());
        writeList();
        
    }

    private static void fetchList() throws FileNotFoundException {
        File xmasList = new File("xmaslist.txt");
        Scanner reader;

        reader = new Scanner(xmasList);

        while (reader.hasNextLine()) {
            presents.add(new Present(reader.nextLine()));
        }
    }

    private static void writeList() {
        try {
            FileWriter fw = new FileWriter("xmaslist.txt");
            for (Present present : presents) {
                fw.write(present.toString() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void addPresents() {
        while (!finished) {
            if (presents.isEmpty()) System.out.println("Welcome to our online Christmas List!");
            System.out.println("Your list currently contains " + presents.size() + " present(s)");
            System.out.println("Would you like to add a present? (y/n)");
            if (!scan.nextLine().equals("y")) {
                System.out.println("Thank you for submitting your list, Santa will be in touch");
                finished = true;
            } else {
                System.out.println("Type the name of your present to add it to the list!");
                presents.add(new Present(scan.nextLine()));
            }
        }
    }
}
