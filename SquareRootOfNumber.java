public class SquareRootOfNumber {
    public static long floorSqrt(long n) {
        long res = 0;
        for(long i=0 ; i<=n ; i++){
            if(i*i == n){
                return i;
            }
            
            else if(i*i > n){
                res = i-1;
                break;
            }
        }
        return res;
    }

    public static void main(String args[]){
        long n = 5;
        long res = floorSqrt(n);
        System.out.println("The square root of the number n is : "+ res);
    }
}
