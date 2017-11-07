public class fib
{
    public static void main(String[] args){
        int n=Integer.parseInt(args[0]);
        int[] X=new int[n];
        long s=System.currentTimeMillis();
        X[0]=1;
        X[1]=1;
        for(int i=2;i<n;i++){
            X[i]=X[i-1]+X[i-2];
        }
        System.out.println(X[n-1]);
        System.out.println(System.currentTimeMillis()-s);
    }
}
