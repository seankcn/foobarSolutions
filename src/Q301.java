public class Q301 {
    public static int solution(int start, int length) {
        int ans = 0; //String ans = "";
        for(int i = length; i > 0; i--){
            for(int j = start+(length*(length-i)); j < start+(length*(length-i))+i ; j++){
                ans = j ^ ans;
            }
        }
        return ans;
    }
}
