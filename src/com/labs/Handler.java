package com.labs;

import java.util.Scanner;

public class Handler {
    private static final String REGEX = "\\s+|\\.|:|,";
    private static final String DEFAULT_LITERAL = "An example of sample text: " +
            "In War: Resolution, In Defeat: Defiance, In Victory: Magnanimity, In Peace: Goodwill \n teeeext";

    public static String prompt() {
        Scanner scanner = new Scanner(System.in);
        String auxiliary;

        for (;;) {
            System.out.print("Do you want to enter a text? [ Yes / No ] \n> ");
            auxiliary = scanner.nextLine().trim().toLowerCase();

            switch (auxiliary) {
                case "yes":
                    StringBuilder builder = new StringBuilder();

                    while (scanner.hasNextLine()) {
                        auxiliary = scanner.nextLine().trim().toLowerCase();
                        if (auxiliary.equals("exit"))
                            return builder.toString();
                        builder.append(auxiliary);
                        builder.append("\n");
                    }
                    break;
                case "no":
                    return DEFAULT_LITERAL;
                default:
                    System.out.println("Unknown answer. Please try again.");
            }
        }
    }

    public static void search(String text) {
        String[] parts = text.toLowerCase().split(REGEX);

        for (String word : parts) {
            if (!word.isEmpty() && word.charAt(0) == word.charAt(word.length() - 1)) {
                System.out.println("Found match: " + word);
            }
        }
    }

    public static void main(String[] args) {
        String text = Handler.prompt();

        System.out.println("Input text.\n" + text);
        Handler.search(text);
    }
}
