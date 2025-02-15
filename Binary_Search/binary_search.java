public class binary_search {
    public static void main(String[] args) {
        int a[]={-6,-1,-1,-1,5,10,15,15,20};
        int target=10;

        int k=find_ele(a, target);

        if(k!=-1)System.out.println("Element found at : "+k);
        else System.out.println("Element not found in array.");
    }

    static int find_ele(int[] a, int t){
        int l=0,h=a.length-1,m=0;
        while(l<=h){
            m=l+(h-l)/2;
            if(a[m]==t)return m;
            else if(a[m]<t)l=m+1;
            else h=m-1;
        }
        return -1;
    }
    
}
