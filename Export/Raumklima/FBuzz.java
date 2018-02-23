package Raumklima;
public class FBuzz
{
    private static final int t1=3;
    private static final String kW1="Fizz";

    private static final int t2=5;
    private static final String kW2="Buzz";

    private static String out="";

    public static void FizzBuzz(int s, int e){
        for(int i=s;i<=e;i++){
            out=String.valueOf(i);
            if(i%t1==0){
                out=kW1;
            }
            if(i%t2==0){
                if(out.equals(kW1)){
                    out+=kW2;
                }
                else{
                    out=kW2;
                }
            }
            System.out.println(out);
        }
    }
}
