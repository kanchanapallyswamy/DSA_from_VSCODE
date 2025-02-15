import java.util.*;
public class shieves_algorithm {
    public static void main(String[] args) {
        int n=48;
        boolean p[]=new boolean[1001];
        Arrays.fill(p,true);
        p[0]=p[1]=false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(p[i]){
                for(int j=i*i;j<=n;j=j+i){
                    p[j]=false;
                }
            }
        }
        System.out.println(p[n]);
    }
    
}
