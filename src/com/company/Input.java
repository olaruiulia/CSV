package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class Input {


    public void createFile() throws IOException {
        File file = new File("products.csv");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter out = new PrintWriter(new FileWriter(file, true));

            StringBuffer productsHeader = new StringBuffer(" ");
            productsHeader.append("ProductName, Price, Quantity\n");
            out.write(productsHeader.toString());

            StringBuffer productsData = new StringBuffer(" ");

            productsData.append("Vans Old Skool, 350 RON, 50\n");
            productsData.append("Vans Authentic, 335 RON, 65\n");
            productsData.append("Supra Skytop, 575 RON, 50\n");
            productsData.append("Etnies Vanguard W's, 340 RON, 30\n");
            productsData.append("Etnies Barge LS, 320 RON, 20\n");
            productsData.append("DC Trase TX, 315 RON, 30\n");

            out.write(productsData.toString());
            out.flush();
            out.close();

            System.out.println("Success!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void addNewData() {
        File file = new File("products.csv");

        try {
            if (file.exists()) {
                PrintWriter out = new PrintWriter(new FileWriter(file, true));
                out.append("Vans SK8-High, 400 RON, 30\n");
                out.flush();
                out.close();

            } else file.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void readFile() {
        String fileName = "products.csv";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                String data = inputStream.nextLine();
                System.out.println(data);
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("Try again");
        }
    }


//    public void changeRow(){
//        String fileName = "products.csv";
//        File file = new File(fileName);
//        String line = readFile();
//        line.replaceAll(null,"DC");
//    }

        public void deleteRow () {
            String fileName = "products.csv";
            String lineToRemove = "Vans SK8-High, 400 RON, 30";
            try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
                stream.filter(line -> !line.trim().equals(lineToRemove)).forEach(System.out::println);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

