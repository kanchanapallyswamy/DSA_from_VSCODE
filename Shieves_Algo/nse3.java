import java.util.*;
public class nse3 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
           a[i]=s.nextInt();
        }
        int res[]=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&&st.peek()>=a[i]) {
                st.pop();}
            res[i]=st.isEmpty()?-1:st.peek();
            st.add(a[i]);
        }
        for(var i:res) System.out.print(i+" ");
    }
}
