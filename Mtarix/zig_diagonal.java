import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class zig_diagonal {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4, 1, 6},
            {5, 6, 7, 8, 2, 7},
            {9, 0, 1, 2, 3, 8},
            {1, 4, 5, 6, 4, 9},
            // {7, 8, 9, 0, 5, 0},
        };
        List<List<Integer>> list=zizag_diagonal(matrix);
        for(var i: list)System.out.println(i);
        System.out.println();
    }

public static List<List<Integer>> zizag_diagonal(int[][] a) {
    
    List<List<Integer>> l=new ArrayList<>();
    int r=a.length;
    int c=a[0].length;
    int i=0,j=0,k=0;
        List<Integer> temp=new ArrayList<>();
        for(int y=0;y<r;y++){
         i=y;j=0;
        while(i>=0 && j>=0 && i<r && j<c){
             temp.add(a[i--][j++]);
        }
           if(k%2==1)Collections.reverse(temp);
            l.add(temp);
            temp=new ArrayList<>();
            k++;
       }
        k=0;
        for(int x=1;x<c;x++){
        i=r-1;j=x;
        while(i>=0 && j>=0 && i<r && j<c){
             temp.add(a[i--][j++]);
        }
           if((k%2==0 && r%2==1) ||(k%2==1 && r%2==0 ))Collections.reverse(temp);
            l.add(temp);
            temp=new ArrayList<>();
            k++;
       }

    return l;
}
}
