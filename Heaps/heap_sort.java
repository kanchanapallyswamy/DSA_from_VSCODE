class Solution{
static  void heapSort(int a[]){
        int n=a.length;
        build_heap(a);
        for(int i=n-1;i>0;i--){
           swap(a,0,i);
            heapify(a,0,i);
        }
    }

static void build_heap(int a[]){
    int n=a.length;
    for(int i=(n/2)-1;i>=0;i--){
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


class heap_sort{
    static  Solution s=new Solution();
    public static void main(String[] args) {
        int[] a = {12, 11, 13, 5, 6,10, 11,15,1,4};
        s.heapSort(a);
        for(int i:a)System.out.print(i+" ");

    }
}