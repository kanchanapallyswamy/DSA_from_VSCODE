import java.util.Scanner;

public class flody_warshall {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int nv=sc.nextInt(),ne = sc.nextInt();
        int m[][]=new int[nv][nv];
        int u,v,w;
        for(int i=0;i<ne;i++){
            u=sc.nextInt();v=sc.nextInt();w=sc.nextInt();
            m[u][v]=w;
        }
        int dist[][]=new int[nv][nv];
        int max=99;
        for(int i=0;i<nv;i++){
            for(int j=0;j<nv;j++){
                if(m[i][j]!=0)dist[i][j]=m[i][j];
                else if(i==j)dist[i][j]=0;
                else dist[i][j]=max;
        }
    }
    for(int mid=0;mid<nv;mid++){
        for(int strt=0;strt<nv;strt++){
            for(int end=0;end<nv;end++){
                // if(dist[strt][mid]!=max && dist[mid][end]!=max)
               dist[strt][end]=Math.min(dist[strt][end],dist[strt][mid]+dist[mid][end]);
            }
        }
    }
    for(int i=0;i<nv;i++){
        for(int j=0;j<nv;j++){
            System.out.print(dist[i][j]+" ");
        }
        System.out.println();
    }
    }
}
