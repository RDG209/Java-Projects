import java.util.*;
import java.io.*;

public class URLExtract {

  public static void main(String[] args) {
    try {
      File urls = new File("urlInput.txt");
      Scanner file = new Scanner(urls);

      File out = new File("urloutput.txt");
      PrintWriter outFile = new PrintWriter(out);

      while (file.hasNext()) {
        String rawUrl = file.nextLine();
        String webName = extractName(rawUrl);

        outFile.println(rawUrl + "      " + webName);

      }

      file.close();
      outFile.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

  }

  public static String extractName(String url) {
    url = url.trim();

    int end = url.length() - 4;

    String website = url.substring(4, end);

    return website;
  }

}