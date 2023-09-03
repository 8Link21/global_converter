package global_converter.pkg;

import java.util.Arrays;
import java.util.Scanner;

public class Check {
    private static final String[] TABARG0 = { "binary", "-b", "octal", "-o", "decimal", "-d", "hexadecimal", "-h",
            "text", "-t" };
    private static final String[] TABARG2 = { "algo", "-a" };
    private static final String[] TABARG3 = { "cesar" };
    private static final String[] TABARG4 = { "key", "-k" };

    public static int go(String[] args, String[] textTable, Scanner in) {
        int choice = 9;
        int status = 0;

        do {
            // check String
            for (String ch : args[1].split("")) {
                if (!Arrays.asList(textTable).contains(ch) || args[1] == "") {
                    System.out.println("Votre deuxième argument " + args[1]
                            + " doit contenir uniquement des lettres et des chiffres.\nVeuillez renseigner une nouvelle chaine:");
                    args[1] = in.nextLine();
                }
            }
            // Check Number of arguments
            if (args.length % 2 != 0) {
                System.out.println(
                        "Erreur !!! Veuillez vérifier vos arguments.\n     > octal \"Hello\" algo \"cesar\" key \"3\"\n     > -o \"Hello\" -a \"cesar\" -k \"3\"");
                System.exit(0);
                // Check base
            } else if (!Arrays.asList(TABARG0).contains(args[0])) {
                System.out.println("Votre premier argument " + args[0]
                        + " doit être :\n     > binary, -b, octal, -o, decimal, -d, hexadecimal, -h, text");
                args[0] = in.nextLine();
                // Check algo
            } else if (args.length == 6 && !Arrays.asList(TABARG2).contains(args[2])) {
                System.out.println("Votre troisième argument " + args[2] + " doit être :\n     > algo, -a");
                System.exit(0);
                // Check algo Selected
            } else if (args.length == 6 && !Arrays.asList(TABARG3).contains(args[3])) {
                System.out.println("Votre quatrième argument " + args[3]
                        + " doit être :\n     > \"cesar\" (d'autres à venir ...)");
                args[3] = in.nextLine();
                // Check key's name of algo
            } else if (args.length == 6 && !Arrays.asList(TABARG4).contains(args[4])) {
                System.out.println("Votre cinquième argument " + args[4] + " doit être :\n     > key, -k");
                System.exit(0);
                // Check the rotation key (only positive number) > reversing by -key into the
                // process
            } else if (args.length == 6 && !args[5].matches("[0-9]+$")) {
                System.out.println("Votre sixième argument " + args[5] + " doit être un nombre entier:\n     > \"3\"");
                args[5] = in.nextLine();
            } else {
                choice = args[0].equals("text") || args[0].equals("-t")
                        ? 0
                        : args[0].equals("binary") || args[0].equals("-b")
                                ? 1
                                : args[0].equals("octal") || args[0].equals("-o") ? 2
                                        : args[0].equals("decimal") || args[0].equals("-d") ? 3
                                                : args[0].equals("hexadecimal") || args[0].equals("-h") ? 4
                                                        : -1;

                status = 1;
            }

        } while (status != 1);

        // System.out.println("Choice >" + choice + "<\nCheck ok");
        return choice;
    }

}
