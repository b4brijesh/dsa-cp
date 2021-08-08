package cookOff71;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by brijesh on 9/25/16.
 */
public class RIGHTTRI {
    static double e_07=0.0000001;
    static int e09$7=1000000007;
    public static void main (String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/A-small-attempt0.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/A-large.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/B-small-practice.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/B-large-practice.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine());
            long H=Long.parseLong(st.nextToken());
            long S=Long.parseLong(st.nextToken());
            BigInteger BH=BigInteger.valueOf(H);
            BigInteger BS=BigInteger.valueOf(S);
            BigInteger ter1=BH.pow(4);
            BigInteger ter2=BS.pow(2).multiply(BigInteger.valueOf(16));
            if(ter1.compareTo(ter2)<0)
                System.out.println(-1);
            else{
                BigSquareRoot bsqrt=new BigSquareRoot();
                BigDecimal ter3=bsqrt.get(ter1.subtract(ter2));
                //double D=ter3.longValue();
                double dH=H;
                BigDecimal bdH=new BigDecimal(BH);
                BigDecimal hsq1=bdH.multiply(bdH).subtract(ter3).divide(BigDecimal.valueOf(2));
                BigDecimal hsq2=bdH.multiply(bdH).subtract(ter3).divide(BigDecimal.valueOf(2));
                double th,tb;
                if(hsq1.compareTo(new BigDecimal(0))>0){
                    th=bsqrt.get(hsq1).doubleValue();
                    tb=Math.sqrt((dH*dH)-(th*th));
                    if(th<tb) System.out.println(th+" "+tb+" "+dH);
                    else System.out.println(tb+" "+th+" "+dH);
                }
                else if(hsq2.compareTo(new BigDecimal(0))>0){
                    th=bsqrt.get(hsq1).doubleValue();
                    tb=Math.sqrt((dH*dH)-(th*th));
                    if(th<tb) System.out.println(th+" "+tb+" "+dH);
                    else System.out.println(tb+" "+th+" "+dH);
                } else System.out.println(-1);
            }
        }
    }

    static class BigSquareRoot {

        private static BigDecimal ZERO = new BigDecimal ("0");
        private static BigDecimal ONE = new BigDecimal ("1");
        private static BigDecimal TWO = new BigDecimal ("2");
        public static final int DEFAULT_MAX_ITERATIONS = 1000;
        public static final int DEFAULT_SCALE = 50;

        private BigDecimal error;
        private int iterations;
        private boolean traceFlag;
        private int scale = DEFAULT_SCALE;
        private int maxIterations = DEFAULT_MAX_ITERATIONS;

        //---------------------------------------
        // The error is the original number minus
        // (sqrt * sqrt). If the original number
        // was a perfect square, the error is 0.
        //---------------------------------------

        public BigDecimal getError () {
            return error;
        }

        //-------------------------------------------------------------
        // Number of iterations performed when square root was computed
        //-------------------------------------------------------------

        public int getIterations () {
            return iterations;
        }

        //-----------
        // Trace flag
        //-----------

        public boolean getTraceFlag () {
            return traceFlag;
        }

        public void setTraceFlag (boolean flag) {
            traceFlag = flag;
        }

        //------
        // Scale
        //------

        public int getScale () {
            return scale;
        }

        public void setScale (int scale) {
            this.scale = scale;
        }

        //-------------------
        // Maximum iterations
        //-------------------

        public int getMaxIterations () {
            return maxIterations;
        }

        public void setMaxIterations (int maxIterations) {
            this.maxIterations = maxIterations;
        }

        //--------------------------
        // Get initial approximation
        //--------------------------

        private static BigDecimal getInitialApproximation (BigDecimal n) {
            BigInteger integerPart = n.toBigInteger ();
            int length = integerPart.toString ().length ();
            if ((length % 2) == 0) {
                length--;
            }
            length /= 2;
            BigDecimal guess = ONE.movePointRight (length);
            return guess;
        }

        //----------------
        // Get square root
        //----------------

        public BigDecimal get (BigInteger n) {
            return get (new BigDecimal (n));
        }

        public BigDecimal get (BigDecimal n) {

            // Make sure n is a positive number

            if (n.compareTo (ZERO) <= 0) {
                throw new IllegalArgumentException ();
            }

            BigDecimal initialGuess = getInitialApproximation (n);
            trace ("Initial guess " + initialGuess.toString ());
            BigDecimal lastGuess = ZERO;
            BigDecimal guess = new BigDecimal (initialGuess.toString ());

            // Iterate

            iterations = 0;
            boolean more = true;
            while (more) {
                lastGuess = guess;
                guess = n.divide(guess, scale, BigDecimal.ROUND_HALF_UP);
                guess = guess.add(lastGuess);
                guess = guess.divide (TWO, scale, BigDecimal.ROUND_HALF_UP);
                trace ("Next guess " + guess.toString ());
                error = n.subtract (guess.multiply (guess));
                if (++iterations >= maxIterations) {
                    more = false;
                }
                else if (lastGuess.equals (guess)) {
                    more = error.abs ().compareTo (ONE) >= 0;
                }
            }
            return guess;

        }

        //------
        // Trace
        //------

        private void trace (String s) {
            if (traceFlag) {
                //System.out.println (s);
            }
        }

        //----------------------
        // Get random BigInteger
        //----------------------

        public static BigInteger getRandomBigInteger (int nDigits) {
            StringBuffer sb = new StringBuffer ();
            java.util.Random r = new java.util.Random ();
            for (int i = 0; i < nDigits; i++) {
                sb.append (r.nextInt (10));
            }
            return new BigInteger (sb.toString ());
        }

    }
}
