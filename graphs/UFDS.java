public class UFDS{
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
        void merge(int x,int y){
                int leader_x=find(x);
                int leader_y=find(y);
                if(leader_x==leader_y)return; // already merged
                parent[leader_y]=leader_x; // can optimize by "union by size"

        }
}

