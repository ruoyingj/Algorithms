//From the last line to the first line
//x only from diagonal positon
//o from the under position


public class Knight2 {
    //BFS
    public boolean knight2(char[][] board){
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < col; i++){
            visited[row-1][i] = true;
        }
        helper(board,row-2,visited);
        for(int i = 0; i < col; i++){
            if(visited[0][i] == true){
                return true;
            }
        }
        return false;

    }


    public void helper(char[][] board, int row ,boolean[][] visited){
        int len = board.length;
        int col = board[0].length;
        for(int i = 0; i < col; i++){
            if(board[row][i] == 'O'){
                if(visited[row+1][i] == true){
                    visited[row][i] = true;
                }
            }else{
                if(i-1>=0&& visited[row+1][i-1] == true){
                    visited[row][i] = true;
                }
                if(i+1<col&& visited[row+1][i+1] == true){
                    visited[row][i] = true;
                }
            }
        }
        helper(board,row-1,visited);

    }

    //DFS
    public static boolean knight2(char[][] board){
        int row = board.length;
        int col = board[0].length;
        for(int i = 0; i < col; i++){
            if(helper(board,row-1,i) == true){
                return true;
            }
        }
        return false;
    }
    public static boolean helper(char[][] board, int x, int y){
        if(x == 0) return true;
        int col = board[0].length;
        if(board[x-1][y] == 'O'){
            if(helper(board,x-1,y)){
                return true;
            }
        }
        if( (y+1<col)&&board[x-1][y+1] == 'X'){
            if(helper(board,x-1,y+1)){
                return true;
            }
        }
        if( (y-1>=0)&&board[x-1][y-1] == 'X'){
            if(helper(board,x-1,y-1)){
                return true;
            }
        }
        return false;


    }

    //unique path
    //BFS
    public static int knight2(char[][] board){
        int row = board.length;
        int col = board[0].length;
        int[][] visited = new int[row][col];
        for (int i = 0; i < col; i++){
            visited[row-1][i] = 1;
        }
        helper(board,row-1,visited);


        int res = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.print(visited[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }

        return res;


    }


    public static void helper(char[][] board, int row ,int[][] visited){
        if (row == 0) return;
        int len = board.length;
        int col = board[0].length;
        for(int i = 0; i < col; i++){
            if(board[row-1][i] == 'O') {
                visited[row-1][i] += visited[row][i];
            }

            if(i-1>=0 && board[row-1][i-1] == 'X'){
                visited[row-1][i-1] += visited[row][i];
            }
            if(i+1<col && board[row-1][i+1] == 'X'){
                visited[row-1][i+1] += visited[row][i];
            }

        }
        helper(board,row-1,visited);

    }

    public static void main(String[] args){
        char[][] a = {{'X','O','X'},{'X','X','X'},{'O','O','O'}};
        System.out.print(knight2(a));

    }

}
