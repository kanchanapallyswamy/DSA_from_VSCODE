import java.util.*;
public class spiral_matrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
        };

        List<Integer> k=find(matrix);
        System.out.println(k);
    }


static public List<Integer> find(int a[][]){
    List<Integer> l=new ArrayList<>();
    int r=a.length,c=a[0].length,n=r*c;
    int cnt=0;
    int top=0,bottom=r-1,left=0,right=c-1;
    while(cnt<=n){
        for(int i=left;i<=right;i++){
            l.add(a[top][i]);
            cnt++;
        }
        top++;
        if(cnt==n)break;
        for(int i=top;i<=bottom;i++){
            l.add(a[i][right]);
            cnt++;
        }
        right--;
        if(cnt==n)break;
        for(int i=right;i>=left;i--){
            l.add(a[bottom][i]);
            cnt++;
        }
        bottom--;
        if(cnt==n)break;
        for(int i=bottom;i>=top;i--){
            l.add(a[i][left]);
            cnt++;
        }
        left++;
        if(cnt==n)break;
    }
    return l;

}
}
