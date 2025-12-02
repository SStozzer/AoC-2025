import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

/*

Made by: Connor Storey
Date: 01/12/2025

*/

public class SafeCracker {
    public static void main(String[] args) {
        try {
            File safeFile = new File("..\\AoC-2025\\Day 1\\input.txt");
            Scanner fileDataInput = new Scanner(safeFile);
            ArrayList<String> data = new ArrayList<>();

            String lineSplit;
            int lineNumber;
            int safePosition = 50;
            int totalp1 = 0;
            int totalp2 = 0;

            while (fileDataInput.hasNextLine())
                data.add(fileDataInput.nextLine());

            for (int i = 0; i < data.size(); i++) {
                if (data.get(i).contains("R")) {
                    lineSplit = data.get(i).substring(1);
                    lineNumber = Integer.parseInt(lineSplit);

                    for (int j = 0; j < lineNumber; j++) {
                        safePosition++;
                        if (safePosition > 99) {
                            safePosition = 0;
                        }
                        if (safePosition == 0) {
                            totalp2++;
                        }
                    }
                } else if (data.get(i).contains("L")) {
                    lineSplit = data.get(i).substring(1);
                    lineNumber = Integer.parseInt(lineSplit);

                    for (int j = 0; j < lineNumber; j++) {
                        safePosition--;
                        if (safePosition < 0) {
                            safePosition = 99;
                        }
                        if (safePosition == 0) {
                            totalp2++;
                        }
                    }
                    
                }
               
                if (safePosition == 0) {
                    totalp1++;
                }
            }

            System.out.println("Total times at 0 after rotation ends: " + totalp1);
            System.out.println("Total times at 0: " + totalp2);

            fileDataInput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
