import java.util.ArrayList;
import java.util.Arrays;
public class Q201 {
    public static String loop(String n, int b){
        int z, k = n.length();
        StringBuilder x = new StringBuilder();
        StringBuilder y = new StringBuilder();
        StringBuilder zString;
        char[] chars = n.toCharArray();
        Arrays.sort(chars);
        for(int i = 0; i < k; i++){
            x.append(chars[k - i - 1]);
            y.append(chars[i]);
        }
        z = Integer.parseInt(x.toString(), b) - Integer.parseInt(y.toString(), b);
        zString = new StringBuilder(Integer.toString(z, b));
        for(int i = 0; i < k-zString.length(); i++)
            zString.insert(0, "0");
        return zString.toString();
    }
    public static int solution(String n, int b){
        ArrayList<String> answerList = new ArrayList<>();
        answerList.add(loop(n, b));
        String out;
        while(true){
            out = loop(answerList.get(answerList.size()-1), b);
            if(answerList.contains(out)){break;}
            answerList.add(out);
        }
        return answerList.size() - answerList.indexOf(out);
    }
}
