public class Q202 {
    public static int[] solution(int[] pegs) {
        int ceiling, denominator = 1;
        int[] sumX = new int[pegs.length-1]; // distances between each peg
        int[] radii = new int[pegs.length]; // radius of each cog

        for(int i = 0; i < sumX.length; i++)
        {sumX[i] = pegs[i+1] - pegs[i];} // find distances

        ceiling = Integer.min(sumX[0], 2*sumX[sumX.length-1]);
        radii[0] = ceiling; // set first cog length

        while(true){

            if(radii[0] > denominator){ // if >1
                radii[0]--; // reduce by 1/denom
            }else if(denominator < ceiling){
                denominator++;
                radii[0] = (ceiling * denominator)-denominator;
            }else{
                return new int[]{-1, -1};
            }

            for(int i = 1; i < radii.length; i++) {
                radii[i] = (sumX[i-1]*denominator)-radii[i-1];
                if(radii[i] < denominator) {
                    radii[radii.length-1] = 0;
                    break;
                }
            }
            if(radii[0] == 2*radii[radii.length-1])
            {return new int[]{radii[0], denominator};}
        }
    }
}
