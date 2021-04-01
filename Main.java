package encryptdecrypt;

import java.util.Scanner;

public class Main {

     static void encryption(int keyArg,String word) {
        StringBuilder result = new StringBuilder();
        for (char character : word.toCharArray()) {
            if (character != ' ') {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + keyArg) % 94;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                result.append(newCharacter);
            } else {
                result.append("%");
            }
        }
         System.out.println(result);
     }

     static void decryption(int keyArg,String word) {
         StringBuilder result = new StringBuilder();
         for (char character : word.toCharArray()) {
             if (character != '%') {
                 int originalAlphabetPosition = character - 'a';
                 int newAlphabetPosition = (originalAlphabetPosition - keyArg) % 94;
                 char newCharacter = (char) ('a' + newAlphabetPosition);
                 result.append(newCharacter);
             } else {
                 result.append(" ");
             }
         }
         System.out.println(result);
     }


    public static void main(String[] args) {
        int keyArg = 0;
        boolean decrypt = false;
        String word = "";
        for (int i = 1; i < args.length; i+=2) {
            if (args[i].equals("dec") && args[i - 1].equals("-mode"))
                decrypt = true;
            else if (args[i].matches("\\d+") && args[i - 1].equals("-key"))
                keyArg = Integer.parseInt(args[i]);
            else if (args[i].matches("^.*$") && args[i - 1].equals("-data"))
                word = args[i];
        }
        if (!decrypt)
            encryption(keyArg,word);
        else
            decryption(keyArg,word);
    }
}
