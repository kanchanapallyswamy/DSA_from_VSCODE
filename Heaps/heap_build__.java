public class heap_build__ {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 4, 6};
        build_heap(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    static void build_heap(int a[]){
        int n=a.length;
        for(int i=n-1;i>=0;i--){
            heapify(a,i,n);
        }
    }
    static void heapify(int a[], int bdx,int n){
        int mx=bdx;
        int lci=2*mx+1;
        int rci=2*mx+2;
        if(lci<n && a[lci]>a[bdx])mx=lci;
        if(rci<n && a[rci]>a[mx])mx=rci;
        if(mx==bdx)return;
        swap(a,bdx,mx);
        heapify(a,mx,n);
    }
    
    static void swap(int a[],int f,int s){
        int t=a[f];
        a[f]=a[s];
        a[s]=t;
    }
}
