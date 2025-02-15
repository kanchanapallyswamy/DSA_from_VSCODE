import java.util.*;
public class min_rotated_sorted {
    public static void main(String[] args) {
        int a[]={0,8,9,1,2,3};
        System.out.println("Array elements :"+Arrays.toString(a));
        int k=find_min(a);
        System.out.println("Minimum element is :"+k);
    }
    static int find_min(int a[]){
        int l=0;
        int h=a.length-1;
        int m=0,mn=Integer.MAX_VALUE;
        while(l<=h){
            m=l+(h-l)/2;
            if(a[l]<=a[m]){
                mn=Math.min(mn,a[l]);
                l=m+1;
            }
            else {
                mn=Math.min(mn,a[m]);
                h=m-1;
            }
        }
        return mn;
}
}
