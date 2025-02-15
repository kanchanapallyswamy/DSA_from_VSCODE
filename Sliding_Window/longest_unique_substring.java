import java.util.*;
public class longest_unique_substring {
    public static void main(String[] args) {
        String s="aabcddabcdefaa";
        String k=find_substring(s);
        System.out.println("Longest Unique Substring : "+k);
    }
    static String find_substring(String s){
        Map<Character,Integer> mp=new HashMap<>();
        int mx=-1,ws=0,si=-1,ei=-1;
        for(int we=0;we<s.length();we++){
            char c=s.charAt(we);
            mp.put(c,1+mp.getOrDefault(c,0));
            if(mp.get(c)==1){
                mx=Math.max(mx,we-ws+1);
                si=ws;
                ei=we;
            }
            else{
                while(ws<=we){
                    char c1=s.charAt(ws);
                    ws++;
                    mp.put(c1,mp.get(c1)-1);
                    if(mp.get(c1)==1)break;
                }
            }
        }

        return s.substring(si,ei+1);
    }
    
}
