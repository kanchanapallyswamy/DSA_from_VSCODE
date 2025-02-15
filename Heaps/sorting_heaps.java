
import java.util.*;

public class sorting_heaps {
    public static void main(String[] args) {
    int a[]={3,4,5,6,1,2,3,9,10,1,20,100};
    System.out.println("Elements before sorting : "+Arrays.toString(a));
    sort(a);
    System.out.println("Elements after sorting : "+Arrays.toString(a));


}

static void sort(int a[]){
    int n=a.length;
    build_heap(a);
    for(int i=n-1;i>0;i--){
        swap(a,0,i);
        heap(a,0,i);
    }
}

static void build_heap(int a[]){
    int n=a.length;
    for(int i=(n/2)-1;i>=0;i--){
        heap(a,i,n);
    }
}
static void swap(int a[],int a1,int b1){
    int temp=a[a1];
    a[a1]=a[b1];
    a[b1]=temp;
}

static void heap(int a[],int i,int n){
    int t=i;
    int lci=2*i+1;
    int rci=2*i+2;
    if(lci < n  && a[lci] > a[i])t=lci;
    if(rci < n && a[rci] > a[t])t=rci;
    if(t==i)return ;

    swap(a,t,i);
    heap(a,t,n);
    
}

}