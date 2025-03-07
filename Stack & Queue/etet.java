
import java.util.*;

public class etet {
    public static void main(String[] args){
        int arr[] = {2,3,4,5,6};
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for(int i=0; i<arr.length; i++){
            q1 = push(arr[i],q1,q2);
        }
        
        while (!q1.isEmpty()) {
            System.out.println(q1.poll());
        }
    }

    static Queue<Integer> push(int x, Queue<Integer> q1, Queue<Integer> q2){
        q2.offer(x);
        while(!q1.isEmpty()){
            q2.offer(q1.poll());
        }
        Queue<Integer> temp=q1;
        q1=q2;
        q2=temp;
        return q1;
    }
}
