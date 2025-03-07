import java.util.*;
public class Path_Existence_In_Graph {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int nv=sc.nextInt(),ne=sc.nextInt();
        int q,u,v;
        UFDS k=new UFDS(nv);
        for(int i=0;i<ne;i++){
            q=sc.nextInt();
            if(q==1){
                u=sc.nextInt();v=sc.nextInt();
                k.merge(u,v);
            }
            else{
                u=sc.nextInt();v=sc.nextInt();
                System.out.println(k.get_path(u,v));
            }
        }

    }
}

class UFDS{
    int n;
    int p[];
    UFDS(int n){
        this.n=n;
        p=new int[n+1];
        for(int i=1;i<=n;i++)p[i]=i;
    }
    int find(int x){
        if(p[x]==x)return x;
        return p[x]=find(p[x]);
    }
    void merge(int x,int y){
        if(find(x)==find(y))return ;
        p[find(x)]=find(y);
    }
    String get_path(int x,int y){
        if(find(x)==find(y))return "Path exists";
        return "Path does not exist";
    }
}