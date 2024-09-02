import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s="aabb";
        List<String> sB=new ArrayList<>();
        sol(s,0,sB,s.length());
    }

    private static void sol(String s, int ind, List<String> sB, int length) {
        if(ind==length){
            System.out.println(sB);
            return;
        }
        if(ind>=length) return;
        for(int i=ind;i<s.length();i++){
            if(isPalindrome(s.substring(ind,i+1))){
                sB.add(s.substring(ind,i+1));
                sol(s,ind+1,sB,length);
                sB.removeLast();
            }
        }
    }

    private static boolean isPalindrome(String s) {
        for(int i=0;i<s.length()/2;i++)
            if(s.charAt(i)!=s.charAt(s.length()-1-i))
                return false;
        return true;
    }
}