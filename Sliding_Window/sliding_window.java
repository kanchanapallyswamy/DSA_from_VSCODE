import java.util.*;
public class sliding_window {
    public static void main(String[] args) {
        int a[]={1,3,4,5,2};//
        // int a[]={1,2,3,4,5,6,7,8};
        int k=4;
        int n=a.length;
       
        List<Integer> ans=find_window(a,k,n);
        System.out.println(ans);
        System.out.println();      
    }
    static List<Integer> find_window(int a[],int k,int n){
        List<Integer> ans = new ArrayList<>();
        int c=0;
        for(int i=0;i<k;i++){
            if(a[i]%2==0)c++;
            
        }
        ans.add(c);

        for(int i=1;i<n-k+1;i++){
            int add=a[i+k-1];
            int delete=a[i-1];
            if(add%2==0)c++;
            if(delete%2==0)c--;
            ans.add(c);
        }
        return ans;
    }
    
}
