import java.io.File;
import java.util.Scanner;


public class IDValidatorPart2 {

    public static void main(String[] args) {
        
        try {

            File inputFile = new File("..\\AoC-2025\\Day 2\\input.txt");
            Scanner inputFileData = new Scanner(inputFile);
           
            String[] idRangeArray = new String[2];
            String inputData = inputFileData.nextLine();
            String idData = "";

            long badIDTotal = 0;

            for (String id: inputData.split(",")){
                idData=id;
                idRangeArray = idData.split("-");
                long start = Long.parseLong(idRangeArray[0]);
                long end = Long.parseLong(idRangeArray[1]);

                for (long i = start; i <= end; i++){
                    String s = Long.toString(i);

                    if (s.substring(0,0).equals(s.substring(1,1))){

                        char[] charArray = s.toCharArray();
                        for (char c : s.toCharArray()){
                            if (charArray[0] != c) 
                                break;                               
                            
                            badIDTotal += Long.parseLong(s);
                            System.out.println(badIDTotal);
                            break;
                        }
                    }

                    int half = s.length() / 2;
                    String p1 = s.substring(0, half);
                    String p2 = s.substring(half);

                    if (p1.equals(p2))
                        badIDTotal += Long.parseLong(s);
                    
                }
            }
            
            inputFileData.close();
            System.out.println(badIDTotal);

        } catch (Exception e) {
            e.printStackTrace();
        } 

    }

}
