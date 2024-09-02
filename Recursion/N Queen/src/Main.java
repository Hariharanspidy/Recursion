public class Main {
    public static void main(String[] args) {
        int n=4;
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                board[i][j]='.';
        sol(0,board,n);

    }

    private static void sol(int col, char[][] board, int n) {
        if(col==n){
            System.out.println();
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++)
                    System.out.print(board[i][j]+" ");
                System.out.println();
            }
            return;
        }
        for(int i=0;i<n;i++){
            if(isValidate(board,i,col,n)){
                board[i][col]='Q';
                sol(col+1,board,n);
                board[i][col]='.';
            }
        }

    }

    private static boolean isValidate(char[][] board,int row,int col,int n) {
        int dupRow=row;
        int dupCol=col;
        while(col>=0){
            if(board[row][col]=='Q') return false;
            col--;
        }
        row=dupRow;
        col=dupCol;
        while(col>=0 && row<n){
            if(board[row][col]=='Q') return false;
            col--;
            row++;
        }
        row=dupRow;
        col=dupCol;
        while(row>=0 && col>=0){
            if(board[row][col]=='Q') return false;
            col--;
            row--;
        }
        return true;
    }
}