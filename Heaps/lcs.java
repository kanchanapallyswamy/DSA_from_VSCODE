import java.util.Scanner;

public class lcs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1=sc.nextLine(),s2=sc.nextLine();
        // System.out.println(
            lcslen(s1,s2);
    }
    static void lcslen(String s1,String s2){
         helper(s1,s2,s1.length(),s2.length());
    }
    static void helper(String s1,String s2,int n1,int n2){
        int dp[][]=new int[n1+1][n2+1];
        for(int i=n1-1;i>=0;i--){
            for(int j=n2-1;j>=0;j--){
                if(s1.charAt(i)==s2.charAt(j))dp[i][j]=1+dp[i+1][j+1];
                else dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
                }
    }
    for(int i=0;i<dp.length;i++){
        for(int j=0;j<dp[0].length;j++){
            System.out.print(dp[i][j]+" ");
        }
        System.out.println();
    }
}

    
}
