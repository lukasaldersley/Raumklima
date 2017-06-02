package Raumklima;
public class createCSV
{
    public createCSV()
    {
        int anz=10000;
        for (int x = 0; x < anz; x++) {
            System.out.print(x + Math.random() * 4000.0);
            System.out.print(";");
            System.out.print((anz-x)+Math.random()*4000.0);
            System.out.print(";");
            System.out.print(x + Math.random() * 40000.0);
            System.out.print(";");
            System.out.println((anz-x)+Math.random()*40000.0);
        }
    }
}
