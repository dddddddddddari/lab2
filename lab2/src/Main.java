import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Map карта, которая будет содержать каждое слово
        Map<String, Integer> map = new HashMap<>();
        int wordCounter = 0;
        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();

        try {
            Scanner s = new Scanner(new File("C:\\Users\\user\\filepath"));
            while (s.hasNext()) {
                list.add(s.next());
            }
            System.out.println(list.size());


            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < 100; j++) {
                    try {
                        Scanner d = new Scanner(new File("C:\\Users\\user\\filepath" + j));
                        while (d.hasNext()) {
                            list1.add(d.next());
                        }
                        d.close();
                        wordCounter = wordCounter + Collections.frequency(list1, list.get(i).toLowerCase());
                        list1.clear();

                    } catch (IOException k) {
                        k.printStackTrace();
                    }
                }
                map.put(list.get(i), wordCounter);
                if (wordCounter > 1) {
                    try {
                        FileWriter fw = new FileWriter("C:\\Users\\filePath", true);
                        PrintWriter pw = new PrintWriter(fw);
                        pw.append("\n");
                        pw.append(map.toString());
                        pw.close();

                    } catch (IOException f) {
                        f.printStackTrace();
                    }
                }
                map.clear();
                wordCounter = 0;
                System.out.println(i);
            }
        } catch (IOException f){
            f.printStackTrace();
        }
    }

}