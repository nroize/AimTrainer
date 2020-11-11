import java.io.*;
import java.util.*;
import java.awt.print.Printable;


/*
    TODO:
        - Make Leaderboard constructor take in directory, make add to variable
*/
public class Leaderboard {
    HashMap<String, Integer> lb;


    public Leaderboard() {

        try {
            lb = convert("Leaderboard.csv");
        } catch (IOException e) {
            System.out.println("Could not find file.");
        }
    }

    private static HashMap convert(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        while ((line = br.readLine()) != null) {
            String str[] = line.split(",");
            map.put(str[0], Integer.parseInt(str[1]));
        }

        return map;
    }

    public HashMap returnMap() throws IOException {
        lb = convert("Leaderboard.csv");
        return sortByValues(lb);
    }

    public void writeToLeaderboard(String name, Integer points) throws IOException {
        FileWriter fw = new FileWriter("Leaderboard.csv", true);
        PrintWriter pw = new PrintWriter(fw);
        pw.println(name + "," + points);
        pw.close();
    }

    private static HashMap sortByValues(HashMap map) {
        List list = new LinkedList(map.entrySet());
        // Defined Custom Comparator here
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable)((Map.Entry) (o2)).getValue())
                        .compareTo(((Map.Entry) (o1)).getValue());
            }
        });

        // Here I am copying the sorted list in HashMap
        // using LinkedHashMap to preserve the insertion order
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }


    }




/*
5 methods
- constructor- blank, calls private method
- private method- convert csv to hash map
- get leaderboard, returns maps
- write to leaderboard, takes 2 inputs, adds a line with that information
- sorting the hash map

 */