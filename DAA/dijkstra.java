
import java.util.*;
class Pair{
    int v,w;
    Pair(int v,int w){
        this.v=v;
        this.w=w;
    }
}
public class dijkstra {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int nv=sc.nextInt(),ne=sc.nextInt();
        Map<Integer, List<Pair>> mp=new HashMap<>();
        int u,v,w;
        for(int i=0;i<ne;i++){
            u=sc.nextInt();v=sc.nextInt();w=sc.nextInt();
            if(!mp.containsKey(u)){
               mp.put(u,new ArrayList<>());
            }
            if(!mp.containsKey(v)){
                mp.put(v,new ArrayList<>());
            }
             mp.get(u).add(new Pair(v,w));
            mp.get(v).add(new Pair(u,w));

        }
        // for(int i=1;i<=nv;i++){
        //     System.out.print(i+":");
        //     for(var p:mp.get(i)){
        //         System.out.print("["+p.v+","+p.w+"]  ");
        //     }
        //     System.out.println();
        

        long dist[]=new long[nv+1];
        long parent[]=new long[nv+1];
        boolean out[]=new boolean[nv+1];
        int src=0;
        Arrays.fill(dist,Long.MAX_VALUE);
        parent[src]=-1;
        dist[src]=0;
        while(true){
             u=MinOutVertex(dist, out);
            if(u==-1)break;
            for(var p:mp.get(u)){
                v =p.v ; w=p.w ;
                if(!out[v]){
                    if(dist[u]+ w < dist[v]){
                        dist[v]=dist[u]+w;
                        parent[v]=u;
                    }
                }
            }
            out[u]=true;
        }  
        for(var i:dist)System.out.print(i+" ");
        System.out.println();
    }
    static int MinOutVertex(long dist[],boolean out[]){
        long mn=Long.MAX_VALUE;
        int idx=-1;
        for(int i=0;i<dist.length;i++){
            if(dist[i]<mn && !out[i]){
                mn=dist[i];
                idx=i;
            }
        }
      return idx;
    }
}


