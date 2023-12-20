import java.math.BigInteger;

public class Q302 {
    public static String solution(String x, String y) {
        BigInteger m = new BigInteger(x);
        BigInteger f = new BigInteger(y);
        BigInteger diff;
        BigInteger i = new BigInteger("0");
        if(!m.testBit(0) && !f.testBit(0)){return "impossible";}
        if((m.mod(f).intValue() == 0 || f.mod(m).intValue() == 0) && m.intValue() != 1 && f.intValue() != 1){return "impossible";} // if one is a factor of the other, impossible
        while(m.signum() > 0 && f.signum() > 0){
            diff = f.subtract(m);
            if(diff.signum() < 0) {
                i = i.add(m.divide(f));
                m = diff.abs().mod(f);
            }
            else{
                i = i.add(f.divide(m));
                f = diff.mod(m);
            }
        }
        if(m.abs().intValue() + f.abs().intValue() == 1){return i.subtract(new BigInteger("1")).toString();}
        return "impossible";
    }
}
