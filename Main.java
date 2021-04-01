package encryptdecrypt;

import java.util.Scanner;

public class Main {

     static void encryption() {
        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
         String s = "we found a treasure!";
        char c;
        StringBuilder sb = new StringBuilder();
        for (int i  = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (Character.isLetter(c)) {
                c = (char)(122 - (int)(c) + 97);
            }
            sb.append(c);
        }
         System.out.println(sb);
     }



    public static void main(String[] args) {
        encryption();
    }
}
