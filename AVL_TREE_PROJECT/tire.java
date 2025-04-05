import java.util.*;

public class tire {
 public static void main(String[] args) {
         Trie t=new  Trie();
         t.insertWord("apple");   
        t.insertWord("app");   
       t.insertWord("srujan");
       List<String> ans=t.getAllWordWithPrfix("abc");
    //    System.out.println("All words with prefix 'ap':");
    // System.out.println(t.startsWith("ap"));

         for(var s:ans){
              System.out.println(s);
         }

       
 }   
}
 class TNode{
    boolean isEow=false ;   
    TNode[] child = new TNode[26];
   
 }
 class Trie{
        TNode root=new TNode();
        void insertWord(String s){
                TNode temp=root;
                for(var ch:s.toCharArray()){
                    int idx=ch-'a';
                    if(temp.child[idx]==null){
                        temp.child[idx]=new TNode();
                    }
                        temp=temp.child[idx];                    
                }
                temp.isEow=true;
        }
        boolean hasWord(String s){
            TNode temp=root;
            for(var ch:s.toCharArray()){
                int idx=ch-'a';
                if(temp.child[idx]==null){
                    return false;
                }
                temp=temp.child[idx];
            }
            if(temp.isEow==false){
                return false;
            }
            return true;
        }
        // static boolean startsWith(String prefix){

        // }
        List<String> allWords(){
            List<String> ans=new ArrayList<String>();
            StringBuilder path=new StringBuilder();
            helper(root,ans,path);          
            return ans;
        }
        void helper(TNode root, List<String> ans, StringBuilder path){
            if(root.isEow==true){
                ans.add(path.toString());
            }
            for(int i=0;i<26;i++){
                if(root.child[i]!=null){
                    path.append((char)(i+'a'));
                    helper(root.child[i],ans,path);
                    path.deleteCharAt(path.length()-1);
                }
            }
        }
        List<String> getAllWordWithPrfix(String prefix){
            List<String> ans=new ArrayList<String>();
            TNode temp=root;
            for(var ch:prefix.toCharArray()){
                int idx=ch-'a';
                if(temp.child[idx]==null){
                    return ans;
                }
                temp=temp.child[idx];
            }
            StringBuilder path=new StringBuilder(prefix);
            helper(temp,ans,path);          
            return ans;
        }
 }