import java.math.BigInteger;

public class Q303 {
    public static int solution(String x) {
        if(x.equals("1")){return 0;}
        BigInteger n = new BigInteger(x);
        BigInteger four = new BigInteger("4");
        BigInteger two = new BigInteger("2");
        BigInteger one = new BigInteger("1");
        int i = 0;
        while(n.compareTo(four) > 0){
            if(!n.testBit(0)) {
                n = n.divide(two);
            }else{
                if(n.add(one).mod(four).intValue() == 0){
                    n = n.add(one);
                }else{
                    n = n.subtract(one);
                }
            }
            i++;
        }
        return i + (n.intValue()+1)/2;
    }
}
