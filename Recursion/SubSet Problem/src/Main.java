import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] a={1,2,2,6,11};
        int t=11;
        List<Integer> subSet=new ArrayList<>();
        sol(a,t);
        sol(a);
        reSol(a,0,a.length,subSet,t);
    }
//    Using power set
    private static void sol(int[] a,int t) {
        int n=a.length;
        int pN=(int)Math.pow(2,n);
        for(int i=0;i<pN;i++){
            int sum=0;
            List<Integer> subSets=new ArrayList<>();
            for(int j=0;j<n;j++)
                if((i&1<<j)!=0){
                    sum+=a[j];
                    subSets.add(a[j]);
                }
            if(sum==t) System.out.println(subSets);
        }
    }
    private static void sol(int[] a) {
        int t=0;
        for(int i:a) t+=i;
        if(t%2==0) sol(a,t/2);
        else System.out.println("Invalid");
    }
//    Using Recursion
    private static void reSol(int[] a,int ind,int n,List<Integer> subSet,int target) {
        if(target==0){
            System.out.println(subSet);
            return;
        }
        if(ind==n || target<0) return;
        subSet.add(a[ind]);
        reSol(a,ind+1,n,subSet,target-a[ind]);
        subSet.removeLast();
        reSol(a,ind+1,n,subSet,target);
    }

}