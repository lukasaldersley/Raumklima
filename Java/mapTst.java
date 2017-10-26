public class mapTst
{
    public mapTst()
    {
    }

    public int reMap(double minPre,double maxPre,double minPost,double maxPost,double val){
        double Fact=val/(maxPre-minPre);
        System.out.println(Fact);
        double zws=Fact*(maxPost-minPost);
        zws+=minPost;
        return (int)zws;
    }
}
