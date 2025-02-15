import  java.util.*;
public class subst {
    public static void main(String[] args) {
        int[] arr = {10,-3,11};
        int t=8;
        int i=0,s=0,k=0;
        while(i<arr.length){
            s+=arr[i];
            if(s==t){
                System.out.println("Found at index "+k);
                break;
            }
            
           while(s>t){
            s-=arr[k++];
            if(s==t){
                System.out.println("Found at index "+k);
                break;
            }
        }
        i++;
    }
    System.out.println(k+"  "+i);
    List<Integer> l=new ArrayList<Integer>();
    List<Integer> r=new ArrayList<Integer>();
    l.add(1);
    l.add(2);
    l.add(3);
    r.add(1);
    r.add(2);
    r.add(3);
    System.out.println(l.equals(r));
} } 

