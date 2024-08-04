import java.util.ArrayList;

public class Rat_inMaze {
    public static void solveMaze(ArrayList<String> ans , int r , int c ,String p , int[][] m , int n , boolean[][] vis){
        
        if(r == (n-1) && c == (n-1) || m[r][c] != 0){
            ans.add(p);
            return;
        }
        
        if(r >= 0 && r < n && c >= 0 && c<n){
            if(vis[r][c] == true || m[r][c] == 0){
                return;
            }
            vis[r][c] = true;
            solveMaze(ans ,r+1,c, p+'D' , m , n , vis); //down ---> r+1 , c
            solveMaze(ans ,r-1,c, p+'U', m , n , vis); //up  --->  r-1 , c
            solveMaze(ans ,r,c+1, p+'R', m , n , vis); //right  --->  r , c+1 
            solveMaze(ans ,r,c-1, p+'L', m , n , vis); //left   --->  r , c-1
            vis[r][c] = false;
            
        }
        
    }
    
    public static ArrayList<String> findPath(int m[][] , int n){
        ArrayList<String> ans = new ArrayList<>();
        boolean vis[][] = new boolean[n][n];
        String p = "";
        solveMaze(ans ,0,0, p , m , n , vis);
        return ans;
    }
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        
        int m[][] = {
            {1,1,0,0},
            {1,1,0,0},
            {1,1,0,0},
            {0,1,1,1},
        };
        int n = m.length;
        // findPath(m,n);
        ArrayList<String> res = findPath(m,n);
        System.out.println(res);
        
        
    }
}
