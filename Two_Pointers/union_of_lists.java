import java.util.*;
public class union_of_lists {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);
        System.out.println("list1:"+list1);
        System.out.println("list2:"+list2);
        List<Integer> result = union(list1, list2);
        System.out.println("Union of lsts : "+result);
    }
    static List<Integer> union(List<Integer> l1, List<Integer> l2) {
      List<Integer> ans = new ArrayList<>();
      int i=0,j=0;
      while(i<l1.size() &&  j<l2.size()){
        if(l1.get(i)!=l2.get(j)){
            ans.add(l1.get(i));
            i++;
        }
        else if(l1.get(i)==l2.get(j)){
            if(ans.isEmpty() || ans.get(ans.size()-1)!=l1.get(i))ans.add(l1.get(i));
            i++;
            j++;
      }
    }
    while(i<l1.size())ans.add(l1.get(i++));
    while(j<l2.size())ans.add(l2.get(j++));
    return ans;
}
}
