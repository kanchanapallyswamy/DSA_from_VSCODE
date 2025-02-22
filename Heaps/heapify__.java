class heapify__{
    public static void main(String[] args) {
        int[] a = {8,9,0,7,10,0,0,10,11,12,3};
        // heapify(a,1,a.length);
        heap_sort(a);

        for(int i:a)System.out.print(i+" ");

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
    static void  build_heap(int a[]){
        int n=a.length;
        for(int i=n-1;i>=0;i--){
            heapify(a,i,n);
        }
    }
    static void heap_sort(int a[]){
        int n=a.length;
        build_heap(a);
        for(int i=n-1;i>=0;i--){
            swap(a,0,i);
            heapify(a,0,i);
        }
    }
}