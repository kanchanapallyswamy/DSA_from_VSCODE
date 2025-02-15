public class string_reverse {
    public static void main(String[] args) {
        
        String s1="Hello Good Morning";
        String s2="";
        String n="";
        String h=s1;
        System.out.print("Normal String:   ");
        System.out.println(s1);
        
        String k="";
        for(int j=h.length()-1;j>=0;j--){
            k=k+h.charAt(j);
            
        }
        System.out.print("String Reverse:    ");
        System.err.println(k);
            
        for (int idx = 0; idx < s1.length(); idx++) {
            char c=s1.charAt(idx);
            String temp="";
            while(idx<s1.length()&&c!=' '){
                temp=c+temp;
idx++;
if(idx<s1.length())
c=s1.charAt(idx);   
            }
            s2=s2+temp+" ";

        }
        s2=s2.trim();
        System.out.print("reverse word in same position:   ");
        System.out.println(s2);
        for(int i=s2.length()-1;i>=0;i--){
            char c=s2.charAt(i);
            n=n+c;

        }
        System.out.print("reversing word in string:    ");
        System.out.println(n);

    }
    
}
