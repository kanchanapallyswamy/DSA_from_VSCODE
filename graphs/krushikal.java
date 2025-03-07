import java.util.*;
public class krushikal {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int nv=sc.nextInt(),ne=sc.nextInt();
        List<Edge> l=new ArrayList<>();
        UFDS ss=new UFDS(nv);
        for(int i=0;i<ne;i++){
            int u=sc.nextInt(),v=sc.nextInt(),w=sc.nextInt();
            l.add(new Edge(u,v,w));
        }
        Collections.sort(l,(a,b)->{
            return a.w-b.w;
        });
    
        UFDS uf=new UFDS(nv);
        int i=0,mn=0,cnt=0;
        while(cnt<nv-1){
            var e=l.get(i);
            int u=e.u,v=e.v;
            if(ss.merge(u,v)){
                mn+=e.w;
                cnt++;
            }
            i++;
        }
        System.out.println("Minium Cost : "+mn);


    }
}
 class UFDS{
    int n;
    int [] parent;
    public UFDS(int n){
        this.n=n;
        parent=new int[n];
        for(int i=0;i<n;i++)parent[i]=i;
        }

        int find(int x){
            if(x==parent[x]) return x;
            return parent[x] = find(parent[x]); // path compression
        }
        boolean merge(int x,int y){
                int leader_x=find(x);
                int leader_y=find(y);
                if(leader_x==leader_y)return false; // already merged
                parent[leader_y]=leader_x;
                return true; // can optimize by "union by size"

        }
}
class Edge {
    int u,v,w;
    public Edge(int u,int v,int w){
        this.u=u;
        this.v=v;
        this.w=w;
    }
}