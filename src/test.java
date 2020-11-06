import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class test {
    public static void main(String[] args) throws IOException {
        Leaderboard lb=new Leaderboard();
        HashMap<String, Integer> test = lb.sorting(lb.returnMap());
        System.out.println(lb.returnMap());
        Iterator i = test.entrySet().iterator();

        while (i.hasNext()) {
            HashMap.Entry current = (HashMap.Entry) i.next();
            System.out.println(current.getKey() + " : " + current.getValue());
        }






    }




}
