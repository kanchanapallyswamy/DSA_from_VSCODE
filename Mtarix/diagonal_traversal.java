import java.util.*;
public class diagonal_traversal {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4, 1, 6},
            {5, 6, 7, 8, 2, 7},
            {9, 10, 11, 12, 3 ,8},
            {13, 14, 15, 16,4 ,9},
            {17, 18, 19, 20, 5 ,10},
        };

        List<List<Integer>> l=  printDiagonal(matrix);
        for(List<Integer> list: l)System.out.println(list);
        System.out.println();
        
        
      
    }
static List<List<Integer>> printDiagonal(int a[][]){
    List<List<Integer>> l = new ArrayList<>();
    int r=a.length;
    int c=a[0].length;
    int i=0,j=0;
    for(int si=0,k=0;k<r;k++){
        List<Integer> temp=new ArrayList<>();
        i=k;j=si;
        while(i>=0 && j>=0 && i<r && j<c){
            temp.add(a[i][j]);
            i--;
            j++;        
        }
        l.add(temp);
        temp=new ArrayList<>();
    }

    for(int si=r-1,k=1;k<c;k++){
        List<Integer> temp=new ArrayList<>();
        i=si;j=k;
        while(i>=0 && j>=0 && i<r && j<c){
            temp.add(a[i][j]);
            i--;
            j++;
    
    }
        l.add(temp);
        temp=new ArrayList<>();
    }    
    return l;
}
}
