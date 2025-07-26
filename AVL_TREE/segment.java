class segmentTree{
    int [] st;
    segmentTree(int [] a){
        st=new int[4*a.length];
        build(a,0,0,a.length-1);
    }
    void build(int [] a,int v,int l,int r){
        if(l==r){
            st[v]=a[l];
        }
        else{
            int m=l+(r-l)/2;
            build(a,2*v+1,l,m);
            build(a,2*v+2,m+1,r);
            st[v]=st[2*v+1]+st[2*v+2];
        }
    }
    int range_sum(int a[],int l,int r){
        return sum(0,0,a.length-1,l,r);
    }
    int sum(int v,int stl,int str,int l,int r){
        if(l<=stl && r>=str){ // st range is completely inside the query range
            return st[v]; 
        }
        if(l>str || r<stl){ // st range is completely outside the query range
            return 0;
        }
        int m=stl+(str-stl)/2;
        return sum(2*v+1,stl,m,l,r)+sum(2*v+2,m+1,str,l,r);
     } 
    void update(int v,int l,int r,int pos,int val){
        if(l==r){
            st[v]=val;
            return;
        }
        else{
            int m=l+(r-l)/2;
            if(pos<=m){
                update(2*v+1,l,m,pos,val);
            }
            else{
                update(2*v+2,m+1,r,pos,val);
            }
            st[v]=st[2*v+1]+st[2*v+2];
        }
    }
}
public class segment {

    public static void main(String[] args) {
        int [] a={5,10,50,10,100,5};
        segmentTree st=new segmentTree(a);
        // for(var i:st.st)System.out.print(i+" ");
            System.out.println();
       st.update(1, 0, 5, 2, 100);
         for(var i:st.st)System.out.print(i+" ");
                System.out.println();
        System.out.println(st.range_sum(a, 0, 5));
        

    }

    
}
