import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s="abc";
        sol(s);
        List<Character> c=new ArrayList<>();
        sol(s,c,s.length(),0);

    }

//Using PowerSet;
    private static void sol(String s) {
        int n=s.length();
        int pN=(int)Math.pow(2,n);
        for(int i=0;i<pN;i++){
            StringBuilder sB=new StringBuilder();
            for(int j=0;j<n;j++)
                if((i&1<<j)!=0)
                    sB.append(s.charAt(j));
            System.out.println(sB);
        }
    }
// Using Recursion
    private static void sol(String s,List<Character> c,int n,int ind) {
        if(n==ind){
            System.out.println(c);
            return;
        }
        c.add(s.charAt(ind));
        sol(s,c,n,ind+1);
        c.removeLast();
        sol(s,c,n,ind+1);
    }

}