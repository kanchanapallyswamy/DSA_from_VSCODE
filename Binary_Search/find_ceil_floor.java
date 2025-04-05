import java.util.*;
public class find_ceil_floor {
    public static void main(String[] args) {
        int a[]={1,2,5,10,15,18,30};
        int ceil=find_ceil(a,9);
        int floor=find_floor(a,20);
        System.out.println("Array is : "+Arrays.toString(a));
        System.out.println("Ceil of 9 is : "+ceil);
       System.out.println("Floor of 20 is : "+floor);
    }
    static int find_ceil(int a[],int t ){
        int l=0,h=a.length-1,m=0,c=-1;
        while(l<=h){
            m=l+(h-l)/2;
            if(a[m]==t)return a[m];
            else if(a[m] < t ) l=m+1;
            else
            {
                c=m;
                h=m-1;
            }
        }
            if(c==-1)return Integer.MAX_VALUE;
            return a[c];
        }

static int find_floor(int a[],int t ){
            int l=0,h=a.length-1,m=0,f=-1;
            while(l<=h){
                m=l+(h-l)/2;
                if(a[m]==t)return a[m];
                else if(a[m] < t ) {
                    f=m;
                    l=m+1;
                }
                else h=m-1;
            }
                if(f==-1)return -1;
                return a[f];
            }
    }

