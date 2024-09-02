
public class Main {
    public static void main(String[] args) {
        int n=4;
        int[][] maz={{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        StringBuilder sB=new StringBuilder();
        sol(maz,0,0,n,sB);
    }

    private static void sol(int[][] maz, int row, int col, int n,StringBuilder ans) {
        if(row==n-1 && col==n-1){
            System.out.println(ans);
            return;
        }
        maz[row][col]=0;
        if( row+1<n && maz[row+1][col]==1 ){
            ans.append('D');
            sol(maz,row+1,col,n,ans);
            ans.deleteCharAt(ans.length()-1);
        }
        if(col+1<n && maz[row][col+1]==1){
            ans.append('R');
            sol(maz,row,col+1,n,ans);
            ans.deleteCharAt(ans.length()-1);
        }
        if(row-1>=0 && maz[row-1][col]==1 ){
            ans.append('U');
            sol(maz,row-1,col,n,ans);
            ans.deleteCharAt(ans.length()-1);
        }
        if(col-1>=0 && maz[row][col-1]==1 ){
            ans.append('L');
            sol(maz,row,col-1,n,ans);
            ans.deleteCharAt(ans.length()-1);
        }
        maz[row][col]=1;
    }
}