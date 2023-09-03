package global_converter.pkg;

import java.util.ArrayList;

public class GenerateTables {

    static final String[] HEXADECIMAL = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E",
            "F" };

    // static int[] octalTable = new int[63], decimalTable = new int[63];
    // static String[] binaryTable = new String[63], hexadecimalTable = new
    // String[63];

    private static ArrayList<String> binaryTable = new ArrayList<String>();
    private static ArrayList<String> octalTable = new ArrayList<String>();
    private static ArrayList<Integer> decimalTable = new ArrayList<Integer>();
    // private static int[] decimalTable = new int[63];
    private static ArrayList<String> hexadecimalTable = new ArrayList<String>();

    public static String[][] go(String[] textTable) {

        // Generate ASCII Decimal Table
        for (int i = 0, j = 32; i < 63 && j <= 123; j++) {
            if (j == 32 ||
                    (j >= 48 && j <= 57) ||
                    (j >= 65 && j <= 90) ||
                    (j >= 97 && j <= 122)) {
                // decimalTable[i] = Integer.toString(j);
                // decimalTable[i] = j;
                decimalTable.add(j);
                i++;
            }
        }

        // Generate ASCII Bases(2,8,16) Tables
        int[] bases = { 2, 8, 16 };
        for (int base : bases) {

            for (int idx = 0; idx < 63; idx++) {
                // int dec = decimalTable[idx];
                int dec = decimalTable.get(idx);
                // ArrayList<Integer> quotients = new ArrayList<Integer>();
                String[] quotients = new String[63];
                ArrayList<String> rests = new ArrayList<String>();

                do {
                    // quotients.add(idx, (int) Math.floor(dec / base));
                    quotients[idx] = Integer.toString((int) (Math.floor(dec / base)));

                    if (base == 16) {
                        rests.add(0, String.valueOf(HEXADECIMAL[dec % base]));
                    } else {
                        rests.add(0, String.valueOf(dec % base));
                    }

                    // dec = quotients.get(idx);
                    dec = Integer.valueOf(quotients[idx]);
                } while (dec != 0);

                // fill Tables
                if (base == 2) {
                    binaryTable.add(String.join("", rests));
                } else if (base == 8) {
                    octalTable.add(String.join("", rests));
                } else if (base == 16) {
                    hexadecimalTable.add(String.join("", rests));
                }
            }

        }

        // New decimal String Tab
        String[] decTable = new String[decimalTable.size()];

        for (int i = 0; i < 63; i++) {
            // // decTable[i] = String.valueOf(decimalTable.get(i));
            decTable[i] = String.valueOf(decimalTable.get(i));
            // System.out.println(i + " " + decimalTable.get(i) + " == " + decTable[i]);
        }

        final String[][] TABLES = { textTable, binaryTable.toArray(new String[63]), octalTable.toArray(new String[63]),
                decTable,
                hexadecimalTable.toArray(new String[63]) };

        return TABLES;
    }

}
