public class Two_Sum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 11, 15};
        int target = 9;
        int a[]=TwoSum(nums,target);
        for(var i:a)System.out.print(i+" ");
    }
    static int [] TwoSum(int[] a, int trgt) {
        int i=0,j=a.length-1;
        while(i<j) {
            if(a[i]+a[j]==trgt)return new int[]{i,j};
            else if(a[i]+a[j] < trgt) i++;
            else if(a[i]+a[j] > trgt) j--;
}
return new int[0];
    }
}
