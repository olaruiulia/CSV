package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Scan {


    public int getIntFromKy() {
        boolean repeat = true;
        int number = 0;
        while (repeat) {
            try {
                Scanner scan = new Scanner(System.in);
                number = scan.nextInt();
                repeat = false;
            } catch (InputMismatchException e) {
                System.err.println("Error: Incorrect character!");
            }
        }
        return number;
}
    public String getStringFromKy(){
        Scanner scan = new Scanner(System.in);
        String word = scan.next();
        return word;
    }


}
