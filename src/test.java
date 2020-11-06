import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        String name="dfhersfgesr";
        int points= 100;
        Leaderboard lb=new Leaderboard();
        lb.writeToLeaderboard(name,points);
        lb.sorting(lb.returnMap());
        System.out.println(lb.returnMap());



    }




}
