public class squares_of_sorted_array {
    public static void main(String[] args) {
        int a[]={-4,-1,0,3,10};
        int b[]=squares_sorted(a);
        System.out.print("Array : ");
        for(var i:a)System.out.print(i+" ");
        System.out.println();
        System.out.print("Squared Array : ");
        for(var i:b)System.out.print(i+" ");
        System.out.println();

    }
    static int[] squares_sorted(int[] a) {
        int n = a.length;
        int b[]=new int[n];
        int i=0,j=n-1,k=n-1;
        while(i<=j){
            if(Math.abs(a[i]) > Math.abs(a[j])){
                b[k--]=a[i]*a[i];
                i++;
            }
            else {
                b[k--]=a[j]*a[j];
                j--;
            }
        }
        return b;
        
    
}
}
