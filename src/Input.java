package src;

import java.util.Scanner;

public class Input {

    private static final Scanner scanner = new Scanner(System.in);
    private Input() {}

    public static Scanner getScanner() {
        return scanner;
    }

    public static String str() {
        return scanner.nextLine();
    }

    public static int nextInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Bitte eine gültige Zahl eingeben.");
            }
        }
    }


}
