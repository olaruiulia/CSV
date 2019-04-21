package com.company;

import java.io.IOException;

public class Program {

    Input input = new Input();
    Scan scan = new Scan();

    private void printMenu() {
        System.out.println(" " +
                "Hello!\n" +
                "Choose from the menu: \n" +
                "\n" +
                "1. Generate a CVS file with products\n" +
                "2. Add a row\n" +
                "3. Read file\n" +
                "4. Update a row\n" +
                "5. Delete a row\n" +
                "0. Exit program\n");
    }

        private boolean programMenu() throws IOException {
            printMenu();
            int numberFromUser = scan.getIntFromKy();
            switch (numberFromUser){
                case 1:
                    create();
                    break;
                case 2:
                    addRow();
                    break;
                case 3:
                    readFile();
                    break;
                case 4:
                    //updateRow();
                    break;
                case 5:
                    deleteRow();
                    break;
                case 0:
                    return false;

            }
            return true;
        }


    public void runProgram() throws IOException {
            boolean repeat;
            do{
                repeat = programMenu();
                System.out.println("\n");
            }while (repeat);
        }


    private void create() throws IOException {
        input.createFile();
        System.out.println("Go and check out your generated CSV file");
    }

    private void addRow() {
        System.out.println("Check out your updated CSV file");
        input.addNewData();
    }
    private void readFile() {
        System.out.println("The CSV file:");
        input.readFile();
    }
//    private void updateRow() {
//        input.changeRow();
//    }
    private void deleteRow() {
        input.deleteRow();
        System.out.println("It worked!");
    }

}
