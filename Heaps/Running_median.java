import java.util.*;
class Solution{

static double [] data_stream(int a[]){
    PriorityQueue<Integer> mnpq=new PriorityQueue<>();
    PriorityQueue<Integer> mxpq=new PriorityQueue<>(Collections.reverseOrder());

    double median[]=new double[a.length];
    for(int i=0;i<a.length;i++){
        int x=a[i];
        // Adding 
        if(mxpq.isEmpty() || x<=mxpq.peek())mxpq.add(x);
        else mnpq.add(x);
        
        // Balancing
        if(mxpq.size()< mnpq.size())mxpq.add(mnpq.remove());
        if(mxpq.size() > mnpq.size()+1) mnpq.add(mxpq.remove());
        
        // Calculating Median

        if(mxpq.size() > mnpq.size())median[i]=(double)mxpq.peek();
        else median[i]=(double)(mxpq.peek() + mnpq.peek())/2.0;
    }
    return median;
    
}

}

public class Running_median {
    static Solution s=new Solution();
    public static void main(String[] args) {

        int a[]={4,1,2,8,3};
        double b[]=s.data_stream(a);
        for(var i:a)System.out.print(i+" ");
        System.out.println();
        for(var i:b)System.out.print(i+" ");
        System.out.println();

    }

    
}
