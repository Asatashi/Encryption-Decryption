package encryptdecrypt;

import java.util.Scanner;

public class Main {

     static void encryption() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int howManyMoves = scanner.nextInt();
        StringBuilder result = new StringBuilder();
        for (char character : s.toCharArray()) {
            if (character != ' ') {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + howManyMoves) % 94;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                result.append(newCharacter);
            } else {
                result.append("%");
            }
        }
         System.out.println(result);
     }

     static void decryption() {
         Scanner scanner = new Scanner(System.in);
         String s = scanner.nextLine();
         int howManyMoves = scanner.nextInt();
         StringBuilder result = new StringBuilder();
         for (char character : s.toCharArray()) {
             if (character != '%') {
                 int originalAlphabetPosition = character - 'a';
                 int newAlphabetPosition = (originalAlphabetPosition - howManyMoves) % 94;
                 char newCharacter = (char) ('a' + newAlphabetPosition);
                 result.append(newCharacter);
             } else {
                 result.append(" ");
             }
         }
         System.out.println(result);
     }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        switch (choice) {
            case "enc":
                encryption();
                break;
            case "dec":
                decryption();
                break;
            default:
                System.out.println("Bad Input");
                break;
        }
    }
}
