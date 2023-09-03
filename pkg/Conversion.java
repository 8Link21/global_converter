package global_converter.pkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Conversion {

    public static void go(String[][] tables, int choice, String[] args, Scanner in) {

        // Discover rotation step of algo
        int key = args.length == 6 ? Integer.valueOf(args[5]) : 0;

        // Decode Ask from which ?
        int baseFrom = 0;
        int baseTo = choice;

        // -t || text >>> Decodage
        if (choice == 0) {
            String[] chBaseDecode = { "1", "2", "3", "4" };
            String inString = "";
            do {
                System.out.println(
                        "De quelle base provient le codage ?\n[1] binaire  [2] octal  [3] decimal  [4] hexadecimal");

                if (in.hasNextLine())
                    inString = in.nextLine().trim();

            } while (!Arrays.asList(chBaseDecode).contains(inString));

            baseFrom = Integer.parseInt(inString);
            baseTo = choice;
            // System.out.println(baseFrom + " <> " + baseTo);
        }

        // Get indexes of each Char from input (argument #2)
        String spliter = choice != 0 ? "" : " ";
        String[] inTextArr = args[1].split(spliter);

        ArrayList<Integer> indexes = new ArrayList<Integer>();
        for (String val : inTextArr) {

            for (int idx = 0; idx < tables[0].length; idx++) {
                if (tables[baseFrom][idx].equals(val)) {
                    if (choice == 0) { // DECODE Algo
                        indexes.add((idx + (-key)) % 63);
                    } else {
                        indexes.add((idx + key) % 63);
                    }
                }
            }

        }

        // Converting Text
        ArrayList<String> convertedTextArr = new ArrayList<String>(Arrays.asList());
        for (int index : indexes) {
            convertedTextArr.add(tables[baseTo][index]);
        }

        // Prepare String Ouput
        String delimiter = choice == 0 ? "" : " ";
        String convertedString = String.join(delimiter, convertedTextArr);

        // Final Output
        System.out.println(convertedString);
    }

}
