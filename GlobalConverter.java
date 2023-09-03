package global_converter;

import global_converter.pkg.*;
import java.util.Scanner;

public class GlobalConverter {
    // Constants
    static final String[] TEXTTABLE = { " ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E",
            "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
            "v", "w", "x", "y", "z" };

    static int choice;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Check Args & Get base conversion Choice
        choice = Check.go(args, TEXTTABLE, in);

        // Generate Tables for conversions
        final String[][] TABLES = GenerateTables.go(TEXTTABLE);

        // Launch Code with (-t || text) flag make decoding process with cesar crypt if
        // you useit
        Conversion.go(TABLES, choice, args, in);

        in.close();
    }
}
