import java.util.HashMap;
import java.awt.print.Printable;
import java.io.FileWriter;
import java.io.PrintWriter;
/*
    TODO:
        - Make Leaderboard constructor take in directory, make add to variable
*/
public class Leaderboard {
    HashMap<String, Integer> lb;
    public Leaderboard(String dir) {
    }
    public static void main(String[] args) throws Exception{
        FileWriter fw= new FileWriter("leaderboard.csv");
        PrintWriter pw= new PrintWriter(fw);


        
        pw.close();

    }
}