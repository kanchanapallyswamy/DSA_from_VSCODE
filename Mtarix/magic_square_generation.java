import java.util.*;
public class magic_square_generation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the square");
         
    
    int n=sc.nextInt();
//    List<List<Integer>> l=new ArrayList<>();
     int a[][]=find(n);
// System.out.println(l);
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            System.out.print(a[i][j]+" ");
        }
        System.out.println();
    }
}

static public int [][] find(int n){
    int a[][]=new int[n][n];
    int i=0,j=n/2,x=1;
    while(x<=n*n){
        a[i][j]=x++;
        int ni=(i-1+n)%n,nj=(j+1+n)%n;
        if(a[ni][nj]!=0){
            i=(i+1+n)%n;
        }
        else{
            i=ni;
            j=nj;
        }
    }

    return a;
    // i=0;
    // j=0;
    // List<List<Integer>> l=new ArrayList<>();
    // for( i=0;i<n;i++){
    //     List<Integer> row=new ArrayList<>();
    //     for( j=0;j<n;j++){
    //         row.add(a[i][j]);
    //     }
    //     l.add(row);
    // }

    // return l;
}



}
