package src;

import java.io.File;
import java.util.Scanner;

public class WordCount {
  public static void main(String[] args) throws Exception {
    File file = new File("src/wordCount/file.txt");
    Scanner scanner = new Scanner(file);

    int totalWords = 0;

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      totalWords += line.split(" ").length;
    }

    System.out.println("Total words: " + totalWords);

    scanner.close();
  }
}
