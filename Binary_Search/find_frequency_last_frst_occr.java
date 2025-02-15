public class find_frequency_last_frst_occr {
    public static void main(String[] args) {
    int a[]={-6,-1,-1,-1,5,10,10,10,10,10,15,15,20};
    int target=10;
    int first_occurrence=find_first_occurrence(a,target);
    int last_occurrence=find_last_occurrence(a,target);

    int ans=last_occurrence-first_occurrence+1;
    System.out.println("frequency of   "+target+" is : "+ans);
    

   
}

static int find_first_occurrence(int[] a, int t){
    int l=0,h=a.length-1,m=0,f=-1;
    while(l<=h){
        m=l+(h-l)/2;
        if(a[m]==t)
        {
            f=m;
            h=m-1;
        }
        else if(a[m]<t)l=m+1;
        else h=m-1;
    }
    if(f==-1)return 1;
    return f;
}

static int find_last_occurrence(int[] a, int t){
    int l=0,h=a.length-1,m=0,f=-1;
    while(l<=h){
        m=l+(h-l)/2;
        if(a[m]==t)
        {
            f=m;
            l=m+1;
        }
        else if(a[m]<t)l=m+1;
        else h=m-1;
    }
    if(f==-1)return 0;
   return f;
}
    
}
