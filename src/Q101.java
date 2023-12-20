public class Q101 {
    public static String solution(String s) {
        int pos, size = 6;
        StringBuilder myOut = new StringBuilder();
        String plainText = "the quick brown fox jumps over the lazy dog";
        String answer = "011110110010100010000000111110101001010100100100101000000000110000111010101010010111101110000000110100101010101101000000010110101001101100111100011100000000101010111001100010111010000000011110110010100010000000111000100000101011101111000000100110101010110110";
        String cap = "000001";
        for(int i = 0; i < s.length(); i++){
            pos = plainText.indexOf(s.toLowerCase().charAt(i)) * 6; // should have used size
            if(Character.isUpperCase(s.charAt(i))){
                myOut.append(cap);}
            myOut.append(answer, pos, pos + 6);
        }
        return myOut.toString();
    }
}