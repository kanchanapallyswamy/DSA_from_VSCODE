import java.util.*;
class Solution{
//     static int[] NSE_idx(int a[]){
//         int n=a.length;
//         int nse[]=new int[n];
//         Arrays.fill(nse,-1);
//         Stack<Integer>st=new Stack<>();
//         // st.push(0);

//         for(int i=0;i<n;i++){

//             while(!st.isEmpty() && a[i]<a[st.peek()]){
//                 nse[st.pop()]=i;

//         }
//         st.push(i);

//     }
//     return nse;
//     }

static int[] NSE(int a[]){
        int n=a.length;
        int nse[]=new int[n];
        Arrays.fill(nse,-1);
        Stack<Integer>st=new Stack<>();
        // st.push(0);

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && a[i]>a[st.peek()]){
                nse[st.pop()]=a[i];

        }
        st.push(i);

    }
    return nse;
    }
}

public class NSE_Algoritm {
    static Solution s=new Solution();
    public static void main(String[] args) {
        int a[]={1,3,4,2};
        int b[]={4,1,2};
        Map<Integer,Integer> mp=new HashMap<Integer,Integer>();
        for(int i:a)System.out.print(i+" ");
        System.out.println();
        // int b[]=s.NSE_idx(a);
        // for(int i:b)System.out.print(i+" ");
        System.out.println();
        int c[]=s.NSE(a);
        // for(int i:c)System.out.print(i+" ");
        System.out.println();
        for(int i=0;i<a.length;i++){
            mp.put(a[i],c[i]);
        }
        for(int i:b){
            System.out.print(mp.get(i)+" ");
        }

    }
    
}
