import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

// https://stackoverflow.com/questions/16100175/store-text-file-content-line-by-line-into-array

public final class TextUtils {

  public TextUtils() {}
  /* 
  public static final String[] txtToArr() {
    Path path = Paths.get("src/data/ArtisticNames.txt");

    List<String> list = Files.readAllLines(path, StandardCharsets.UTF_8);
    String[] a = list.toArray(new String[list.size()]);
    return a;
  }
*/
}
