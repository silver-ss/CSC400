import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ListFromFile {
    public static CustomLinkedList createList(String filePath) {
        CustomLinkedList list = new CustomLinkedList();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
                String line;
                while ((line = br.readLine()) != null) {
                    // split line into tokens at each instance with one or more , or space
                    String[] tokens = line.split("[,\\s]+");
                    // for each token in list parse Int and insert into list
                    for (String token : tokens) {
                        try {
                            list.insert(Integer.parseInt(token));
                        } catch (NumberFormatException e) {
                            System.err.println("Skipping invalid Integer value:" + token);
                        }
                    }
                }
            } catch (IOException e) { e.printStackTrace(); }
        return list;
    }
}