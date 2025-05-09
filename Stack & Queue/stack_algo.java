
import java.util.Arrays;
import java.util.Stack;

public class stack_algo{
    public static void main(String[] args) {
        
        int a[] = {4, 5, 2, 10, 8};
        System.out.println("given array is : ");
        for(var i : a)System.out.print(i+" ");
        System.out.println();
        int ans1[] = nge(a);
        System.out.println("next greater element is : ");
        for(var i : ans1)System.out.print(i+" ");
        System.out.println();
        int ans2[] = nse(a);
        System.out.println("next smaller element is : ");
        for(var i : ans2)System.out.print(i+" ");
        System.out.println();
        int ans3[] = pse(a);
        System.out.println("previous smaller element is : ");
        for(var i : ans3)System.out.print(i+" ");
        System.out.println();
        int ans4[] = pge(a);
        System.out.println("previous greater element is : ");
        for(var i : ans3)System.out.print(i+" ");
        System.out.println();
    }
    public static int [] nge(int a[]){
        int ans[] = new int[a.length];
        Arrays.fill(ans, -1);
        int n = a.length ;
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1; i >= 0; i--){
            while( !st.isEmpty() && a[st.peek()] < a[i]) 
            {
                st.pop();
            }
            if(!st.isEmpty() ) ans[i] = a[st.peek()];
            st.push(i); 
        }
        return ans;
    }
    public static int [] nse(int a[]){
        int ans[] = new int[a.length];
        Arrays.fill(ans, -1);
        int n = a.length ;
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1; i >= 0; i--){
            while( !st.isEmpty() && a[st.peek()] > a[i]) 
            {
                st.pop();
            }
            if(!st.isEmpty() ) ans[i] = a[st.peek()];
            st.push(i); 
        }
        return ans;
    }
    public static int [] pge(int a[]){
        int ans[] = new int[a.length];
        Arrays.fill(ans, -1);
        int n = a.length ;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            while( !st.isEmpty() && a[st.peek()] < a[i]) 
            {
                st.pop();
            }
            if(!st.isEmpty() ) ans[i] = a[st.peek()];
            st.push(i); 
        }
        return ans;
    }
    public static int [] pse(int a[]){
        int ans[] = new int[a.length];
        Arrays.fill(ans, -1);
        int n = a.length ;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            while( !st.isEmpty() && a[st.peek()] > a[i]) 
            {
                st.pop();
            }
            if(!st.isEmpty() ) ans[i] = a[st.peek()];
            st.push(i); 
        }
        return ans;
    }
}
