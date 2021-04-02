package encryptdecrypt;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        String mode = "enc";
        String data = "";
        int key = 0;
        String inputPath = "";
        String outputPath = "";

        String argStr = Arrays.toString(args);
        for (int i = 0; i < args.length; i += 2) {
            if ("-mode".equals(args[i])) {
                mode = args[i + 1];
            }
            if ("-key".equals(args[i])) {
                key = Integer.parseInt(args[i + 1]);
            }
            if ("-data".equals(args[i])) {
                data = args[i + 1];
            }
            if ("-in".equals(args[i]) && !argStr.contains("-data")) {
                inputPath = args[i + 1];
            }
            if ("-out".equals(args[i])) {
                outputPath = args[i + 1];
            }
        }

        if (!inputPath.isEmpty()) {
            File inputFile = new File(inputPath);
            Scanner scanner = new Scanner(inputFile);
            data = scanner.nextLine();
            scanner.close();
        }

        StringBuilder result = doEncDec(data, key, mode);

        if (!outputPath.isEmpty()) {
            File outputFile = new File(outputPath);
            FileWriter writer = new FileWriter(outputFile);
            writer.write(result.toString());
            writer.close();
        } else {
            System.out.print(result);
        }
    }

    public static StringBuilder doEncDec(String data, int key, String mode) {
        StringBuilder str = new StringBuilder();
        if ("dec".equals(mode)) {
            key = -key;
        }
        for (int i = 0; i < data.length(); i++) {
            str.append(Character.toChars(data.charAt(i) + key));
        }
        return str;
    }
}