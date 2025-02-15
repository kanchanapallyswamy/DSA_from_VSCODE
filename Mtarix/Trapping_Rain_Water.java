public class Trapping_Rain_Water {
    public static void main(String[] args) {
        int []height = {3,0,1,0,4,0,2};
        for(var i:height)System.out.print(i+" ");System.out.println();
        System.out.println("Trapped water: " + trap(height));
    }
   static int trap(int a[]) {
        int i=0,j=a.length-1,ans=0;
        int lmax=a[0],rmax=a[a.length-1];
        while(i<=j){
            if(lmax<rmax){
                lmax=Math.max(lmax,a[i]);
                ans+=lmax-a[i];
                i++;
            }
            else{
                rmax=Math.max(rmax,a[j]);
                ans+=rmax-a[j];
                j--;
            }
        }
        return ans;
    }
}
