import java.util.*;

public class stack_implementation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- > 0) {
            int x=sc.nextInt();
            switch (x) {
                case 1:
                    int y=sc.nextInt();
                    push(y);
                    break;
                    case 2:
                    int ans=pop();
                    System.out.println("poped ele : "+ans);                    
                    break;
                    case 3:
                    int ans1=peek();
                    System.out.println("peek ele : "+ans1);
                    break; 
                }
            }
        }
        static Queue<Integer> q=new LinkedList<>();
static void push(int a) {
    q.add(a);
    for(int i=0;i<q.size()-1;i++){
        q.add(q.remove());
    }
}
static int pop(){
    if(q.isEmpty()){
        return -1;
    }
    return q.remove();
}
static int peek(){
    if(q.isEmpty()){
        return -1;
    }
    return q.peek();
}

}
