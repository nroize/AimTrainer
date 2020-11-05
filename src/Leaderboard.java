import java.io.*;
import java.util.HashMap;
import java.awt.print.Printable;


/*
    TODO:
        - Make Leaderboard constructor take in directory, make add to variable
*/
public class Leaderboard {
    HashMap<String, Integer> lb;

    public Leaderboard(String cons) {

        try {
            lb = convert("Leaderboard.csv");
        } catch (IOException e) {
            System.out.println("Could not find file.");
        }
    }

    private HashMap convert(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Leaderboard.csv"));
        String line;
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        while ((line = br.readLine()) != null) {
            String str[] = line.split(",");
            map.put(str[0],Integer.parseInt(str[1]));
        }

        return map;
    }
    public HashMap returnLeaderboard (){


        return 
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