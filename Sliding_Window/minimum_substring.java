import java.util.*;
public class minimum_substring {
    public static void main(String[] args) {
        String s="hellajjbgcddancmb";
        String t="abc";
        System.out.println(minimum_substring(s,t));

    }
    static String minimum_substring(String s, String t) {
            if(t==null || t.length()==0 || t.equals(""))return "";
            int si=-1,ei=-1,ws=0,we=0,min=Integer.MAX_VALUE;
            Map<Character, Integer> mp=new HashMap<>();
            for(int i=0;i<t.length();i++){
                char c=t.charAt(i);
                mp.put(c, mp.getOrDefault(c,0)+1);
            }
            int still_Need=mp.size();
            for( we=0;we<s.length();we++){
                char c=s.charAt(we);
                if(mp.containsKey(c)){
                    mp.put(c,mp.get(c)-1);
                    if(mp.get(c)==0){
                        still_Need--;
                        if(still_Need==0){
                            if(we-ws+1 < min){
                                min=we-ws+1;
                                si=ws;
                                ei=we;
                            }
                            while(ws<=we){
                                char c1=s.charAt(ws);
                                ws++;
                                if(mp.containsKey(c1)){
                                    mp.put(c1,mp.get(c1)+1);
                                    if(mp.get(c1)==1){
                                    still_Need++;
                                    if(we-ws+2 < min)
                                    {
                                        min=we-ws+2;
                                        si=ws-1;
                                        ei=we;
                                    }
                                    break;}}}}

                            }
                        }
                    }
                    return s.substring(si,ei+1);
                }
            }
    


