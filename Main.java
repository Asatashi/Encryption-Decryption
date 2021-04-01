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
                int newAlphabetPosition = (originalAlphabetPosition + howManyMoves) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }
         System.out.println(result);
     }



    public static void main(String[] args) {
        encryption();
    }
}
