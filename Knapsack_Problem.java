import java.util.*;
public class Knapsack_Problem {
    public static void main(String[] args) {
        
        int w = 4;
        int val[] = {6 ,3, 8, 6, 9, 8, 2, 4, 10, 9};
        int wt[] = {2 ,1 ,3 ,1 ,4 ,1 ,2 ,2 ,5 ,7};
        
        int n = val.length;
        
        float vw[] = new float[n];
        ArrayList<Integer> al = new ArrayList<>();
        
        for(int i=0 ; i<n ; i++){
            vw[i] = (float)val[i]/wt[i];
        }
        
        for(int i=0 ; i<n ; i++){
            float max = vw[i];
            // int maxidx = i;
            for(int j=i+1 ; j<n ; j++){
                if(vw[j] >max){
                    
                    float temp = vw[j];
                    vw[j] = vw[i];
                    vw[i] = temp;
                    
                    int tem = val[j];
                    val[j] = val[i];
                    val[i] = tem;
                    
                    int t = wt[j];
                    wt[j] = wt[i];
                    wt[i] = t;
                }
                // else if(vw[i] == vw[j]){
                //     if()
                // }
            }
        }
        
        int sum = 0;
        int valSum = 0; 
        
        for(int i=0 ; i<n ; i++){
            if(sum + wt[i] > w){
                al.add(0);
            }
            else{
                sum += wt[i];
                valSum += val[i];
                al.add(val[i]);
            }
        }
        
        System.out.println("Value sum is " + valSum);
        System.out.println("ArrayList " + al);
        System.out.println(Arrays.toString(val) + " value ");
        System.out.println(Arrays.toString(wt) + " weight ");
        System.out.println(Arrays.toString(vw) + " value / weight ");
    }
}
