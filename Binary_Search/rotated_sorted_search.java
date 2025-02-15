public class rotated_sorted_search {
    public static void main(String[] args) {
        int a[]={8,9,10,2,3,5,6};
        int t=10;
        int k=find_ele(a,t);
        if(k!=-1)System.out.println("Elememt found at "+k);
        else System.out.println("Element not found");
    }

    static int find_ele(int a[],int key){
        int l=0;
        int h=a.length-1;
        int m=0;
        while(l<=h){
            m=l+(h-l)/2;
            if(a[m]==key)return m;
            else if(a[l]<=a[m]){
                if(key>=a[l] && key<=a[m])h=m-1;
                else l=m+1;
            }
            else {
                if(key>=a[m] && key<=a[h])l=m+1;
                else h=m-1;

            }
        }
        return -1;
    }
}
