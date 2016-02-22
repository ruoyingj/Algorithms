import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Knight {

        static int[][] dis = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{-1,2},{1,-2},{-1,-2}};
        public static int getPath(int[][] chess, int[] start, int[] end){
            int row = chess.length;
            int col = chess[0].length;
            Queue<Integer> queue = new LinkedList();
            int layer = 0;
            queue.add(start[0]*col+start[1]);
            boolean[][] visited = new boolean[row][col];
            visited[start[0]][start[1]] = true;
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    int index = queue.poll();
                    int x = index / chess[0].length;
                    int y = index % chess[0].length;
                    for(int m = 0; m < dis.length; m++){
                        int x_new = x + dis[m][0];
                        int y_new = y + dis[m][1];
                        if(x_new >= 0 && y_new >= 0 && x_new < row && y_new < col && visited[x_new][y_new] == false && chess[x_new][y_new] != 1){
                            if(x_new == end[0] && y_new == end[1]){
                                return layer+1;
                            }
                            visited[x_new][y_new] = true;
                            queue.add(x_new*col+y_new);
                        }
                    }
                }
                layer++;
            }

            return -1;

        }


        public static void main(String[] args) {
            // TODO Auto-generated method stub
            int[] start = new int[2];
            int[] end = new int[2];
            Scanner in = new Scanner(System.in);

            String s = in.nextLine();
            String[] board = s.split(" ");
            int[][] chess = new int[Integer.parseInt(board[0])][Integer.parseInt(board[1])];
            s = in.nextLine();
            board = s.split(" ");
            start[0] = Integer.parseInt(board[0]);
            start[1] = Integer.parseInt(board[1]);
            s = in.nextLine();
            board = s.split(" ");
            end[0] = Integer.parseInt(board[0]);
            end[1] = Integer.parseInt(board[1]);
            int n = Integer.parseInt(in.nextLine());
            for(int i = 0; i < n; i++){
                s = in.nextLine();
                board = s.split(" ");
                chess[Integer.parseInt(board[0])][Integer.parseInt(board[1])] = 1;
            }

            System.out.println(getPath(chess,start,end));


        }




}




