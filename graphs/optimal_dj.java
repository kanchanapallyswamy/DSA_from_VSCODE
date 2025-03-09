import java.util.*;

public class optimal_dj{
    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 1, 1));
        edges.add(Arrays.asList(0, 2, 10));
        edges.add(Arrays.asList(0, 5, 10));
        edges.add(Arrays.asList(1, 2, 1));
        edges.add(Arrays.asList(1, 3, 15));
        edges.add(Arrays.asList(2, 4, 2));
        edges.add(Arrays.asList(3, 4, 2));
        edges.add(Arrays.asList(3, 5, 1));
        edges.add(Arrays.asList(4, 5, 1));


        int start = 0;
        int[] result = dijkistra(edges, start);

        System.out.println("Shortest distances from node " + start + ": " + Arrays.toString(result));
   
    }
  static  int [] dijkistra(List<List<Integer>> edges , int start){
        int n = 0;
        for (var edge : edges) {
            n = Math.max(n, Math.max(edge.get(0), edge.get(1))); 
            }
            n++;
        Map<Integer,List<Pair>> mp=new HashMap<>();

        for(int i=0;i<edges.size();i++){
                int u=edges.get(i).get(0),v=edges.get(i).get(1),w=edges.get(i).get(2);
                if(!mp.containsKey(u))mp.put(u,new ArrayList<>());
                if(!mp.containsKey(v))mp.put(v,new ArrayList<>());
                mp.get(u).add(new Pair(v, w));
                mp.get(v).add(new Pair(u, w));
        }
        int [] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Pair> pq=new PriorityQueue<>( (x,y) ->{
            return x.w-y.w;
        });
        Set<Integer> st=new HashSet<>();
        pq.add(new Pair(start,0));
        dist[start]=0;
        while(!pq.isEmpty()){
            var p=pq.poll();
            int u=p.v;
            if(st.contains(u))continue;
            st.add(u);
            for(var k:mp.get(u)){
                int v=k.v,w=k.w;
                if(dist[u]+w < dist[v]){
                    dist[v]=dist[u]+w;
                    pq.add(new Pair(v,dist[v]));
                }
            }
        }
        return dist;
    }
}
class Pair{
    int v,w;
    Pair(int v,int w){
        this.v=v;
        this.w=w;
    }
}
